package com.mgl.test.thread;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;

/**
 *@Description: 创建多线程
 * 1.通过继承Thread实现
 * 2.通过实现Runnable实现
 *
 *
 *
 *@Author: magla
 *@Date: 2019/6/17_10:41
 *@since: v1.0.0
 */
public class CreateThread {

    static class ThreadWithThread extends Thread{
        private static int num = 5;
        private static CountDownLatch countDownLatch = new CountDownLatch(num);

        public void run() {
            countDownLatch.countDown();
            System.out.println("线程等待发令枪发令  --- 继承Thread");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " ".concat("继承Thread"));
        }

        public static void main(String[] args) {
            for (int i=0; i< num; i++) {
                ThreadWithThread threadWithThread = new ThreadWithThread();
                threadWithThread.start();
            }
        }
    }

    static class ThreadWithThread_0 extends Thread{
        private static int num = 5;
        private static CountDownLatch countDownLatch = new CountDownLatch(num);

        public void run() {
            System.out.println(Thread.currentThread().getName() + "开始运行  --- 继承Thread");
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " ".concat("运行完毕  --继承Thread"));
            countDownLatch.countDown();
        }

        public static void main(String[] args) {

            new Thread(){
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "等待其他线程运行完毕  --- 继承Thread");
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " ".concat("其他线程运行完毕, 开始执行本线程  --继承Thread"));

                }
            }.start();

            for (int i=0; i< num; i++) {
                ThreadWithThread_0 threadWithThread = new ThreadWithThread_0();
                threadWithThread.start();
            }
        }
    }

    static class ThreadWithThread_1 extends Thread{
        private static int num = 8;
        private static Semaphore semaphore = new Semaphore(4);

        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + "获得一个许可证, 开始访问");
                Thread.sleep(20000);
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + "释放一个许可证");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        public static void main(String[] args) {
            for (int i=0; i< num; i++) {
                ThreadWithThread_1 threadWithThread = new ThreadWithThread_1();
                threadWithThread.start();
            }
        }
    }

    static class ThreadWithThread_2 extends Thread{
        private static int num = 5;
        private static CyclicBarrier cyclicBarrier = new CyclicBarrier(num);

        public void run() {
            try {

                System.out.println(Thread.currentThread().getName() + "等待全组线程准备完毕");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() +  "等待完毕, 开始运行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }

        public static void main(String[] args) {
            for (int i=0; i< num; i++) {
                ThreadWithThread_2 threadWithThread = new ThreadWithThread_2();
                threadWithThread.start();
            }
        }
    }

    static class ThreadWithRunnable implements Runnable{
        private static int num = 50;
        private static CountDownLatch countDownLatch = new CountDownLatch(num);

        public void run() {
            countDownLatch.countDown();
            System.out.println("线程等待发令枪发令  --- 实现Runnable");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " ".concat("实现Runnable"));
        }

        public static void main(String[] args) {
            for (int i=0; i< num; i++) {
                ThreadWithRunnable threadWithRunnable = new ThreadWithRunnable();
                Thread thread = new Thread(threadWithRunnable);
                thread.start();
            }
        }
    }

    static class ThreadWithCallable implements Callable<Integer> {
        private static int num = 50;
        private static CountDownLatch countDownLatch = new CountDownLatch(num);

        public Integer call() throws Exception {
            countDownLatch.countDown();
            System.out.println("线程等待发令枪发令  --- 实现callable");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " ".concat("实现callable"));
            return 1;
        }

        public static void main(String[] args) {
            for (int i=0; i< num; i++) {
                Callable<Integer> callable = new ThreadWithCallable();
                FutureTask<Integer> futureTask = new FutureTask(callable);
                Thread thread = new Thread(futureTask);
                thread.start();
            }
        }
    }
}
