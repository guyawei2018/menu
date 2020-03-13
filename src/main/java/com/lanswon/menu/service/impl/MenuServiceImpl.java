package com.lanswon.menu.service.impl;

import com.lanswon.menu.dao.menu.MenuMapper;
import com.lanswon.menu.domain.entity.menu.Menu;
import com.lanswon.menu.domain.vo.SimpleResponse;
import com.lanswon.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Description:
 * @Author GU-YW
 * @Date 2020/1/10 9:05
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MenuServiceImpl implements MenuService {

    private final MenuMapper menuMapper;

    @Override
    public SimpleResponse addMenu(Menu menu) {
        SimpleResponse check = check(menu);
        if(!Objects.isNull(check)){
            return check;
        }
        menu.setCrtDate(new Date());
        menu.setLastDate(new Date());
        menuMapper.insert(menu);
        return SimpleResponse.builder()
                .status(HttpStatus.OK.value())
                .description("新增成功")
                .build();
    }

    @Override
    public SimpleResponse updateMenu(Menu menu) {
        SimpleResponse check = check(menu);
        if(!Objects.isNull(check)){
            return check;
        }
        menu.setLastDate(new Date());
        menuMapper.updateByPrimaryKeySelective(menu);
        return SimpleResponse.builder()
                .status(HttpStatus.OK.value())
                .description("修改成功")
                .build();
    }

    @Override
    public SimpleResponse menus() {
        List<Menu> menus = menuMapper.selectAll();
        return SimpleResponse.builder()
                .status(HttpStatus.OK.value())
                .object(menus)
                .build();
    }

    private SimpleResponse check(Menu menu){
        List<Menu> menus = menuMapper.selectAll();
        for(Menu m : menus){
            if((m.getMenuName().equals(menu.getMenuName())||
                    m.getMenuUrl().equals(menu.getMenuUrl()))){
                if(menu.getId()!=null){
                    if(menu.getId().intValue() != m.getId().intValue()){
                        return SimpleResponse.builder()
                                .status(HttpStatus.MULTIPLE_CHOICES.value())
                                .description("菜单名或地址重复")
                                .build();
                    }
                }

            }
        }
        return null;
    }
}
