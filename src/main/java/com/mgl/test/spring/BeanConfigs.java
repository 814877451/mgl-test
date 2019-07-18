package com.mgl.test.spring;

import com.mgl.test.pojo.UserPO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigs {

   /**
     * name : 创建bean的名称
     * initMethod ; 创建bean的时候执行的方法
     * destroyMethod : 销毁bean的时候执行的方法
     */
    /*@Bean(name = "user", initMethod = "", destroyMethod = "")
    public UserPO getUserPO() {
        return new UserPO();
    }*/
}
