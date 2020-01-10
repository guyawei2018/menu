package com.lanswon.menu.service;

import com.lanswon.menu.domain.entity.menu.Menu;
import com.lanswon.menu.domain.vo.SimpleResponse;

/**
 * @Description:
 * @Author GU-YW
 * @Date 2020/1/10 9:04
 */
public interface MenuService {

    /**
     * 新增工程资源
     * @param menu
     * @return
     */
    SimpleResponse addMenu(Menu menu);

    /**
     * 更新工程资源
     * @param menu
     * @return
     */
    SimpleResponse updateMenu(Menu menu);

    /**
     * 查询所有工程资源
     * @return
     */
    SimpleResponse menus();
}
