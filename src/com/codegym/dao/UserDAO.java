package com.codegym.dao;

import com.codegym.model.Login;
import com.codegym.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static List<User> users;

    static {
        users=new ArrayList<>();
        User u1= new User();
        u1.setAge(15);
        u1.setAccount("nghia");
        u1.setEmail("nghiadang@gmail.com");
        u1.setName("NghiaDang");
        u1.setPassword("123456");
        users.add(u1);

        User u2= new User();
        u2.setAge(55);
        u2.setAccount("tuyen");
        u2.setEmail("tuyen06@gmail.com");
        u2.setName("TuyenNguyen");
        u2.setPassword("123456");
        users.add(u2);

        User u3= new User();
        u3.setAge(15);
        u3.setAccount("admin");
        u3.setEmail("admin@gmail.com");
        u3.setName("CodeGym");
        u3.setPassword("admin");
        users.add(u3);
    }

    public static User checkLogin(Login login){
        for (User u:users){
            if (u.getAccount().equals(login.getAccount())&&u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }
}
