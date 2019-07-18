package com.mgl.test.designmode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *@Description: 代理模式
 *
 *@Author: magla
 *@Date: 2019/7/17_11:03
 *@since: v1.0.0
 */
public class ProxyPattern {

    interface Subject {
        void printMessage();
    }

    static class SubjectImplA implements Subject {

        @Override
        public void printMessage() {
            System.out.println("A--代理模式:::输出A");
        }
    }

    static class SubjectImplB implements Subject {

        @Override
        public void printMessage() {
            System.out.println("B--代理模式:::输出B");
        }
    }

    static class ProxySubject implements Subject {
        private Subject subject;

        public ProxySubject(Subject subject) {
            this.subject = subject;
        }

        @Override
        public void printMessage() {
            subject.printMessage();
        }
    }

    public static void main(String[] args) {
        ProxySubject proxySubjectA = new ProxySubject(new SubjectImplA());
        proxySubjectA.printMessage();
        ProxySubject proxySubjectB = new ProxySubject(new SubjectImplB());
        proxySubjectB.printMessage();
    }
}
