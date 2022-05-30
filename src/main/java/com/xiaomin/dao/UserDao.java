package com.xiaomin.dao;

import com.xiaomin.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: XiaoMin
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: UserManagement
 * @Date_Time: 2022/5/28 9:47
 */
@Repository
public class UserDao {
    //模拟数据
    public static Map<Integer, User> users=null;
    static {
        users=new HashMap<Integer, User>();
        users.put(1001,new User(1001,"XiaoMin","1314520",1,"xiaomin.spring@qq.com",1,1));
        users.put(1002,new User(1002,"XiaoYan","1314520",0,"xiaomin.summer@qq.com",1,1));
        users.put(1003,new User(1003,"JieNiYou","1314520",1,"xiaomin.winter@qq.com",0,0));
        users.put(1004,new User(1004,"JunXin","1314520",0,"xiaomin.autumn@qq.com",0,0));
        users.put(1005,new User(1005,"小敏","1314520",1,"xiaomin.spring@qq.com",0,0));
        users.put(1006,new User(1006,"小艳","1314520",0,"xiaomin.winter@qq.com",0,0));
        users.put(1007,new User(1007,"解你忧","1314520",1,"xiaomin.spring@qq.com",0,0));
        users.put(1008,new User(1008,"君心","1314520",0,"xiaomin.summer@qq.com",0,0));
        users.put(1009,new User(1009,"张三","5201314",1,"xiaomin.spring@qq.com",0,0));
        users.put(1010,new User(1010,"李四","5201314",1,"xiaomin.autumn@qq.com",0,0));
        users.put(1011,new User(1011,"王二麻","5201314",0,"xiaomin.spring@qq.com",0,0));
        users.put(1012,new User(1012,"ZhangSan","5201314",1,"xiaomin.summer@qq.com",0,0));
        users.put(1013,new User(1013,"LiSi","5201314",1,"xiaomin.autumn@qq.com",0,0));
        users.put(1014,new User(1014,"WangErMa","5201314",0,"xiaomin.summer@qq.com",0,0));

    }
    //初始化id   id自增
    public static Integer initId=1015;

    public void addUser(User user){
        if (user.getId() == null) {
            user.setId(initId++);
        }
        users.put(user.getId(),user);
    }

    public Collection<User> getAllUser(){
        return users.values();
    }

    public User getUserById(Integer id){
        return users.get(id);
    }


    public void deleteUserById(Integer id){
        users.remove(id);
    }

}
