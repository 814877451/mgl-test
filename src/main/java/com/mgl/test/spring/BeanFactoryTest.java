package com.mgl.test.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {

    /**
     *@Description: ignoreDependencyInterface测试
     *
     *@Author: magla
     *@Date: 2019/7/11_9:36
     *@Param:  * @Param: null
     *@Return:
     *@since: v1.0.0
     */
    public void ignoreDependencyInterfaceTest() {

    }

    /**
     *@Description: ignoreDependencyType测试
     *
     *@Author: magla
     *@Date: 2019/7/11_9:36
     *@Param:  * @Param: null
     *@Return:
     *@since: v1.0.0
     */
    public void ignoreDependencyTypeTest() {

    }

    public static void main(String[] args) {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource(""));
    }
}
