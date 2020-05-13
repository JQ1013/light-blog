package com.jqlmh.nano.model.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 博客菜单实体类
 *
 * @author LMH
 * @version 1.0
 * @create 2019-05-12 11:33
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "nano_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = -7726233157376388786L;

    /**
     * 编号 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单路径
     */
    private String menuUrl;

    /**
     * 排序编号
     */
    private Integer menuSort;

    /**
     * 图标，可选，部分主题可显示
     */
    private String menuIcon;
}
