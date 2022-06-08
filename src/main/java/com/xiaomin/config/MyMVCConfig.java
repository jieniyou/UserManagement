package com.xiaomin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: UserManagement
 * @Date_Time: 2022/5/28 23:11
 */
@Configuration
public class MyMVCConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");

        registry.addViewController("/main.html").setViewName("main");
        registry.addViewController("/main").setViewName("main");

        registry.addViewController("/member_add").setViewName("X-Admin/member-add");
        registry.addViewController("/member_show").setViewName("X-Admin/member-show");
        registry.addViewController("/member_edit").setViewName("X-Admin/member-edit");
        registry.addViewController("/kiss_edit").setViewName("X-Admin/kiss-edit");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/index.html","/registered.html","/","/user/login",
                        "/user/register","/register",
                        "/font/*","/css/*","/images/*","/js/*");
    }
}
