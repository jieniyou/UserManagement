package com.xiaomin.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: UserManagement
 * @Date_Time: 2022/5/28 9:39
 */
@Data
@NoArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private String password;
    private Integer gender;
    private String email;
    private Date birth;

    private Integer identity;

    public User(Integer id, String userName, String password, Integer gender, String email,Integer identity) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.email = email;
        //自动生成当前日期为生日
        this.birth = new Date();
        this.identity = identity;
    }
}
