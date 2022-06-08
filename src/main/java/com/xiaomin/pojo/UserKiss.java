package com.xiaomin.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@NoArgsConstructor
@Alias("userkiss")
public class UserKiss {
    private Integer id;
    private String userName;
    private float intergal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getIntergal() {
        return intergal;
    }

    public void setIntergal(float intergal) {
        this.intergal = intergal;
    }

    public UserKiss(Integer id, String userName, float intergal) {
        this.id = id;
        this.userName = userName;
        this.intergal = intergal;
    }

}
