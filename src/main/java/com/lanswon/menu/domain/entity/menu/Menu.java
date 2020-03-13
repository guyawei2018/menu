package com.lanswon.menu.domain.entity.menu;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 菜单名
     */
    @Column(name = "menu_name")
    @NotNull(message = "菜单名不能为空")
    private String menuName;

    /**
     * 菜单地址
     */
    @Column(name = "menu_url")
    @NotNull(message = "菜单地址不能为空")
    private String menuUrl;

    /**
     * 使用状态
     */
    @Column(name = "use_status")
    private Integer useStatus;

    /**
     * 创建时间
     */
    @Column(name = "crt_date")
    @ApiModelProperty(hidden = true)
    private Date crtDate;

    /**
     * 最近修改时间
     */
    @Column(name = "last_date")
    @ApiModelProperty(hidden = true)
    private Date lastDate;

    @Column(name = "need_login")
    private boolean needLogin;
}