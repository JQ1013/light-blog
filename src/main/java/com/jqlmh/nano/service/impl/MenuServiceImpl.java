package com.jqlmh.nano.service.impl;

import com.jqlmh.nano.model.domain.Menu;
import com.jqlmh.nano.repository.MenuRepository;
import com.jqlmh.nano.service.MenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 16:05
 */
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;

	/**
	 * 新增/修改菜单
	 *
	 * @param menu menu
	 * @return Menu
	 */
	@Override
	public Menu saveByMenu(Menu menu) {
		//有id,修改菜单,先查出数据库的数据,在看前台传过来的书库是否为空,为空不变,不为空就修改
		Long menuId = menu.getMenuId();
		if (null != menuId) {
			Optional<Menu> optional = this.findByMenuId(menuId);
			Menu menuFromDb = null;
			if (optional.isPresent()) {
				menuFromDb = optional.get();
				if (StringUtils.isNotEmpty(menu.getMenuName())) {
					menuFromDb.setMenuName(menu.getMenuName());
				}
				if (StringUtils.isNotEmpty(menu.getMenuIcon())) {
					menuFromDb.setMenuName(menu.getMenuName());
				}
				if (null != menu.getMenuSort()) {
					menuFromDb.setMenuSort(menu.getMenuSort());
				}
				if (StringUtils.isNotBlank(menu.getMenuUrl())) {
					menuFromDb.setMenuUrl(menu.getMenuUrl());
				}
			}
			return menuRepository.save(menuFromDb);
		}
		//没有id直接保存
		return menuRepository.save(menu);
	}

	/**
	 * 查询所有菜单
	 *
	 * @return list
	 */
	@Override
	public List<Menu> findAllMenus() {
		return menuRepository.findAll();
	}

	/**
	 * 根据编号查询菜单
	 *
	 * @param menuId menuId
	 * @return Menu
	 */
	@Override
	public Optional<Menu> findByMenuId(Long menuId) {
		return menuRepository.findById(menuId);
	}


	/**
	 * 根据编号删除菜单
	 *
	 * @param menuId menuId
	 * @return menu
	 */
	@Override
	public Menu removeByMenuId(Long menuId) {
		Optional<Menu> optional = this.findByMenuId(menuId);
		if (!optional.isPresent()) {
			return null;
		}
		menuRepository.delete(optional.get());
		return optional.get();
	}
}
