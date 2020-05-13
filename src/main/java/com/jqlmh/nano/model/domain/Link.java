package com.jqlmh.nano.model.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 博客友情链接实体类
 *
 * @author LMH
 * @version 1.0
 * @create 2019-05-12 12:33
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "nano_link")
public class Link implements Serializable{

    private static final long serialVersionUID = 5441686055841177588L;

    /**
     * 友情链接编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long linkId;

    /**
     * 友情链接名称
     */
    private String linkName;

    /**
     * 友情链接地址
     */
    private String linkUrl;

    /**
     * 友情链接头像
     */
    private String linkPic;

    /**
     * 友情链接描述
     */
    private String linkDesc;
}
