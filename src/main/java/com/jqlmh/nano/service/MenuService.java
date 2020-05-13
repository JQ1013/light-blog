package com.jqlmh.nano.service;

import com.jqlmh.nano.model.domain.Menu;

import java.util.List;
import java.util.Optional;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 16:05
 */
public interface MenuService {

	/**
	 * 新增/修改菜单
	 *
	 * @param menu menu
	 * @return Menu
	 */
	Menu saveByMenu(Menu menu);

	/**
	 * 查询所有菜单
	 *
	 * @return list
	 */
	List<Menu> findAllMenus();

	/**
	 * 根据编号查询菜单
	 *
	 * @param menuId menuId
	 * @return Menu
	 */
	Optional<Menu> findByMenuId(Long menuId);

	/**
	 * 根据编号删除菜单
	 *
	 * @param menuId menuId
	 * @return menu
	 */
	Menu removeByMenuId(Long menuId);
}
