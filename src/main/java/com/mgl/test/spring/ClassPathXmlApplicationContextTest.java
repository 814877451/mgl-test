package com.mgl.test.spring;

import com.mgl.test.pojo.UserPO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class ClassPathXmlApplicationContextTest  {

    static class MyAnnotationConfigApplicationContext extends AnnotationConfigApplicationContext {
        public MyAnnotationConfigApplicationContext(Class<?>... annotatedClasses) {
            super(annotatedClasses);
        }

        protected void initPropertySources() {
            //添加验证要求
            getEnvironment().setRequiredProperties("classpathwwwwww");
        }
    }



    public static void main(String[] args) {
        ApplicationContext context = new MyAnnotationConfigApplicationContext(BeanConfigs.class);
        Environment env = context.getEnvironment();
        env.getProperty("classpathwwwwww");
        System.out.println("=====================" + env.getProperty("classpathwwwwww"));
        UserPO user = context.getBean(UserPO.class);
        user.print();
    }
}
