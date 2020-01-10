package com.lanswon.menu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 系统启动类
 * @author GU-YW
 */
@SpringBootApplication
@MapperScan("com.lanswon.menu.dao")
@ComponentScan("com.lanswon")
@EnableSwagger2
public class MenuManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MenuManageApplication.class, args);
    }

}
