package com.jqlmh.nano.web.controller.admin;

import com.jqlmh.nano.model.domain.Attachment;
import com.jqlmh.nano.model.domain.Logs;
import com.jqlmh.nano.model.dto.LogsRecord;
import com.jqlmh.nano.model.dto.NanoConst;
import com.jqlmh.nano.service.AttachmentService;
import com.jqlmh.nano.service.LogsService;
import com.jqlmh.nano.util.NanoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * 附件系统控制器
 *
 * @author LMH
 * @version 1.0
 * @create 2019-12-12 16:36
 */
@Slf4j
@Controller
@RequestMapping(value = "/admin/attachments")
public class AttachmentController {

	@Autowired
	private AttachmentService attachmentService;

	@Autowired
	private LogsService logsService;

	/**
	 * 刷新NanoConst中的保存附件的list
	 */
	private void updateConst() {
		NanoConst.ATTACHMENTS.clear();
		NanoConst.ATTACHMENTS = attachmentService.findAllAttachments();
	}

	/**
	 * 获取upload的所有图片资源并渲染页面
	 *
	 * @param model model
	 * @return 模板路径admin/admin_attachment
	 */
	@GetMapping
	public String attachments(Model model,
							  @RequestParam(value = "page", defaultValue = "0") Integer page,
							  @RequestParam(value = "size", defaultValue = "18") Integer size) {
		Sort sort = new Sort(Sort.Direction.DESC, "attachId");
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<Attachment> attachments = attachmentService.findAllAttachments(pageable);
		model.addAttribute("attachments", attachments);

		return "admin/admin_attachment";
	}

	/**
	 * 上传附件
	 *
	 * @param file    file
	 * @param request request
	 * @return Map<String, Object></>
	 */
	@PostMapping(value = "/upload", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public Map<String, Object> upload(@RequestParam("file") MultipartFile file,
									  HttpServletRequest request) {
		return uploadAttachment(file, request);
	}

	/**
	 * 上传图片
	 *
	 * @param file    file
	 * @param request request
	 * @return Map<String, Object></>
	 */
	private Map<String, Object> uploadAttachment(MultipartFile file, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		if (!file.isEmpty()) {
			try {
				File basePath = new File(ResourceUtils.getURL("classpath:").getPath());
				File mediaPath = new File(basePath.getAbsolutePath(), "upload/" + NanoUtil.YEAR + "/" + NanoUtil.MONTH + "/");
				if (!mediaPath.exists()) {
					boolean mkdirs = mediaPath.mkdirs();
				}
				file.transferTo(new File(mediaPath.getAbsoluteFile(), Objects.requireNonNull(file.getOriginalFilename())));
				String fileName = file.getOriginalFilename();
				String nameWithOutSuffix = fileName.substring(0, fileName.lastIndexOf('.'));
				String fileSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.') + 1);

				//保存在数据库
				Attachment attachment = new Attachment();
				attachment.setAttachName(fileName);
				attachment.setAttachPath("/upload/" + NanoUtil.YEAR + "/" + NanoUtil.MONTH + "/" + fileName);
				System.out.println(mediaPath.getAbsolutePath() + "\\" + fileName);
				//判断图片大小，如果长宽都小于500，则保存原始图片路径
				BufferedImage sourceImg = ImageIO.read(new FileInputStream(mediaPath.getPath() + "/" + fileName));
				if (sourceImg.getWidth() < 500 && sourceImg.getHeight() < 500) {
					attachment.setAttachSmallPath("/upload/" + NanoUtil.YEAR + "/" + NanoUtil.MONTH + "/" + fileName);
				} else {
					attachment.setAttachSmallPath("/upload/" + NanoUtil.YEAR + "/" + NanoUtil.MONTH + "/" + nameWithOutSuffix + "_small." + fileSuffix);
					//剪裁图片
					NanoUtil.cutCenterImage(mediaPath.getAbsolutePath() + "/" + fileName, mediaPath.getAbsolutePath() + "/" + nameWithOutSuffix + "_small." + fileSuffix, 500, 500, fileSuffix);
				}

				attachment.setAttachType(file.getContentType());
				attachment.setAttachSuffix("." + fileSuffix);
				attachment.setAttachCreated(NanoUtil.getDate());
				attachmentService.saveByAttachment(attachment);

				updateConst();

				log.info("上传文件[" + file.getOriginalFilename() + "]到[" + mediaPath.getAbsolutePath() + "]成功");
				logsService.saveByLogs(
						new Logs(LogsRecord.UPLOAD_FILE, file.getOriginalFilename(), NanoUtil.getIpAddr(request), NanoUtil.getDate())
				);

				result.put("success", 1);
				result.put("message", "上传成功！");
				result.put("url", attachment.getAttachPath());
			} catch (Exception e) {
				log.error("未知错误!", e.getMessage());
				result.put("success", 0);
				result.put("message", "上传失败！");
			}
		} else {
			log.error("文件不能为空");
		}
		return result;
	}


	/**
	 * 处理获取附件详情的请求
	 *
	 * @param model    model
	 * @param attachId 附件编号
	 * @return 模板路径admin/widget/_attachment-detail
	 */
	@GetMapping(value = "/attachment")
	public String attachmentDetail(Model model, @RequestParam("attachId") Long attachId) {
		Optional<Attachment> attachment = attachmentService.findByAttachId(attachId);
		if (attachment.isPresent()) {
			model.addAttribute("attachment", attachment.get());
		}
		//设置选项
		model.addAttribute("options", NanoConst.OPTIONS);
		return "admin/widget/_attachment-detail";
	}

	/**
	 * 移除附件的请求
	 *
	 * @param attachId 附件编号
	 * @param request  request
	 * @return true：移除附件成功，false：移除附件失败
	 */
	@GetMapping(value = "/remove")
	@ResponseBody
	public boolean removeAttachment(@PathParam("attachId") Long attachId,
									HttpServletRequest request) {
		Optional<Attachment> attachment = attachmentService.findByAttachId(attachId);
		String delSmallFileName = null;
		String delFileName = null;
		if (attachment.isPresent()) {
			delFileName = attachment.get().getAttachName();
			delSmallFileName = delFileName.substring(0, delFileName.lastIndexOf('.')) + "_small" + attachment.get().getAttachSuffix();
		}
		try {
			//删除数据库中的内容
			attachmentService.removeByAttachId(attachId);

			//刷新NanoConst变量
			updateConst();

			//删除文件
			File basePath = new File(ResourceUtils.getURL("classpath:").getPath());
			File mediaPath = new File(basePath.getAbsolutePath(), attachment.get().getAttachPath().substring(0, attachment.get().getAttachPath().lastIndexOf('/')));
			File delFile = new File(mediaPath.getAbsolutePath() + "/" + delFileName);
			File delSmallFile = new File(mediaPath.getAbsolutePath() + "/" + delSmallFileName);

			FileInputStream fis = new FileInputStream(delFile);
			BufferedImage sourceImg = ImageIO.read(fis);
			if (sourceImg.getWidth() > 500 && sourceImg.getHeight() > 500) {
				if (delSmallFile.exists()) {
					if (delSmallFile.delete()) {
						updateConst();
					}
				}
			}
			fis.close();

			if (delFile.exists() && delFile.isFile()) {
				if (delFile.delete()) {
					updateConst();
					log.info("删除文件[" + delFileName + "]成功！");
					logsService.saveByLogs(
							new Logs(LogsRecord.REMOVE_FILE, delFileName, NanoUtil.getIpAddr(request), NanoUtil.getDate())
					);
				} else {
					log.error("删除附件[" + delFileName + "]失败！");
					return false;
				}
			}
		} catch (Exception e) {
			log.error("删除附件[" + delFileName + "]失败！:", e.getMessage());
			return false;
		}
		return true;
	}


	/**
	 * 跳转选择附件页面
	 *
	 * @param model model
	 * @param page  page 当前页码
	 * @return 模板路径admin/widget/_attachment-select
	 */
	@GetMapping(value = "/select")
	public String selectAttachment(Model model,
								   @RequestParam(value = "page", defaultValue = "0") Integer page,
								   @RequestParam(value = "id", defaultValue = "userAvatar") String id) {
		Sort sort = new Sort(Sort.Direction.DESC, "attachId");
		Pageable pageable = PageRequest.of(page, 18, sort);
		Page<Attachment> attachments = attachmentService.findAllAttachments(pageable);
		// System.err.println(attachments.getTotalPages());
		// System.err.println(attachments.getContent());
		model.addAttribute("attachments", attachments);
		model.addAttribute("id", id);
		return "admin/widget/_attachment-select";
	}


	/**
	 * editor.md上传图片
	 *
	 * @param file    file
	 * @param request request
	 * @return Map<String, Object></>
	 */
	@PostMapping(value = "/upload/editor", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public Map<String, Object> editorUpload(@RequestParam("editormd-image-file") MultipartFile file,
											HttpServletRequest request) {
		return uploadAttachment(file, request);
	}
}
