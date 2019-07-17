package com.mgl.test.spring;

import org.apache.catalina.core.ApplicationContext;
import org.apache.naming.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
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
