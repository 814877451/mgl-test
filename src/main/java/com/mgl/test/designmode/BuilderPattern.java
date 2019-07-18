package com.mgl.test.designmode;

import java.util.ArrayList;
import java.util.List;

/**
 *@Description: 建造者模式
 * Product：产品类，指要创建的复杂对象，通常实现了模板方法模式。
 * Builder：抽象建造类，规范产品的组建，一般是由子类实现的。
 * ConcreteBuilder：具体建造类，实现抽象建造类定义的方法并返回一个建造好的对象。
 * Director：导演类，也就是指挥者，负责安排流程。
 *
 *@Author: magla
 *@Date: 2019/7/17_11:03
 *@since: v1.0.0
 */

public class BuilderPattern {

    /**
     *@Description: 产品
     *
     *@Author: magla
     *@Date: 2019/7/17_11:03
     *@since: v1.0.0
     */
     abstract class Product {

         private List<String> orderList = new ArrayList<>();

         abstract void stepA();
         abstract void stepB();
         abstract void stepC();

         public void build() {

         }

         abstract class builder {
             abstract void stepA();
             abstract void stepB();
             abstract void stepC();
         }

         class ConcreteBuilderA extends builder {
             @Override
             void stepA() {
                 System.out.println("A---------------stepA");
             }

             @Override
             void stepB() {
                 System.out.println("A---------------stepB");
             }

             @Override
             void stepC() {
                 System.out.println("A---------------stepC");
             }
         }

        class ConcreteBuilderB extends builder {
            @Override
            void stepA() {
                System.out.println("B---------------stepA");
            }

            @Override
            void stepB() {
                System.out.println("B---------------stepB");
            }

            @Override
            void stepC() {
                System.out.println("B---------------stepC");
            }
        }

        class Director {

        }
    }
}
