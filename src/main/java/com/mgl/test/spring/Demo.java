package com.mgl.test.spring;

import com.mgl.test.pojo.UserPO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfigs.class);
        UserPO user = context.getBean(UserPO.class);
        user.print();

        System.out.println(context.getBeanFactory());

        for (String data : context.getAliases("user")) {
            System.out.println(data);
        }


    }

}
