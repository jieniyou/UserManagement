package com.xiaomin.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: UserManagement
 * @Date_Time: 2022/5/28 9:39
 */
@Data
@NoArgsConstructor
@Alias("user")
public class User {
    private Integer id;
    private String userName;
    private String password;
    private Integer gender;     //0:女   1:男
    private String email;
    private Date birth;

    private Integer identity;   //1:超级用户    0:普通用户

    private Integer status;     //1:已启用 0:已停用

    public User(Integer id, String userName, String password, Integer gender, String email,Integer identity,Integer status) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.email = email;
        //自动生成当前日期为生日
        this.birth = new Date();
        this.identity = identity;
        this.status = status;
    }
}
