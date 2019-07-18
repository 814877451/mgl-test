package com.mgl.test.designmode;

import java.util.ArrayList;
import java.util.List;

/**
 *@Description: 观察者模式
 *
 *@Author: magla
 *@Date: 2019/7/17_11:03
 *@since: v1.0.0
 */
public class ObserverPattern {

    /**
     *@Description: 被观察者
     *
     *@Author: magla
     *@Date: 2019/7/17_11:03
     *@since: v1.0.0
     */
    static class Observable {

        private static List<Observer> obList = new ArrayList<>();

        private void addObserver(Observer observer) {
            obList.add(observer);
        }

        private void notifyMessage(String param) {
            obList.forEach(data -> {
                data.seeMessage(param);
            });
        }
    }

    /**
     *@Description: 观察者
     *
     *@Author: magla
     *@Date: 2019/7/17_11:03
     *@since: v1.0.0
     */
    interface Observer {
        void seeMessage(String param);
    }

    static class ObserverA implements Observer{
        @Override
        public void seeMessage(String param) {
            System.out.println("A--接收到消息:::".concat(param));
        }
    }

    static class ObserverB implements Observer{
        @Override
        public void seeMessage(String param) {
            System.out.println("B--接收到消息:::".concat(param));
        }
    }

    public static void main(String[] args) {
        Observable observer = new Observable();
        observer.addObserver(new ObserverA());
        observer.addObserver(new ObserverB());

        observer.notifyMessage("观察者模式测试");
    }
}
