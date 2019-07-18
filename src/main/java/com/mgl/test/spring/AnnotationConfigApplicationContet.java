package com.mgl.test.spring;

import com.mgl.test.configuration.TestConfig;
import com.mgl.test.pojo.UserPO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *@Description: 注解上下文
 *
 *@Author: magla
 *@Date: 2019/7/17_11:40
 *@since: v1.0.0
 */
public class AnnotationConfigApplicationContet {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        UserPO userPO = context.getBean(UserPO.class);
        userPO.print();
    }
}
