package com.mgl.test.pojo;

import org.springframework.stereotype.Component;

@Component
public class UserPO {

    UserPO() {
        System.out.println("实例化user!");
    }

    private String userId;

    private String name;

    private String phone;

    private String idCardType;

    private String idCardNo;

    public void print() {
        System.out.println("我是user");
    }
}
