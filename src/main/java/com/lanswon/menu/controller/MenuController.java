package com.lanswon.menu.controller;

import com.lanswon.menu.domain.entity.menu.Menu;
import com.lanswon.menu.domain.vo.SimpleResponse;
import com.lanswon.menu.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Description:
 * @Author GU-YW
 * @Date 2020/1/10 9:26
 */
@RestController
@RequestMapping("/menu")
@Api(tags="菜单管理")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin
public class MenuController {

    private final MenuService menuService;

    @PostMapping("/list")
    @ApiOperation(value="查询菜单信息")
    public SimpleResponse queryDepartments() {
        return menuService.menus();
    }

    @PostMapping("/add")
    @ApiOperation(value="新增菜单")
    public SimpleResponse addDepartment(@RequestBody @Valid Menu menu){
        return menuService.addMenu(menu);
    }

    @PutMapping("/update")
    @ApiOperation(value="修改菜单")
    public SimpleResponse updateDepartment(@RequestBody @Valid Menu menu) {
        return menuService.updateMenu(menu);
    }
}
