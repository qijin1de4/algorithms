package me.hqj.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 编写一个程序，开启 3 个线程，这三个线程的 ID 分别为A、B、C，每个线程将自己的 ID 在屏幕上打印 10 遍，要求输出的结果必须按顺序显示。如：ABCABCABC…… 依次递归。
 * https://blog.csdn.net/qq_40121502/article/details/88219548
 */
public class LockConditionDemo {

    public static void main(String[] args) {

        new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                Print.printA();
            }
        }, "A").start();

        new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                Print.printB();
            }
        }, "B").start();

        new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                Print.printC();
            }
        }, "C").start();

    }

    static class Print {

        private static volatile int num = 1;

        private static ReentrantLock LOCK = new ReentrantLock();

        private static Condition conditionA = LOCK.newCondition();
        private static Condition conditionB = LOCK.newCondition();
        private static Condition conditionC = LOCK.newCondition();

        public static void printA() {
            LOCK.lock();
            try {
                if (num != 1) {
                    conditionA.await();
                }
                System.out.print(Thread.currentThread().getName());
                num = 2;
                conditionB.signal();
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        }

        public static void printB() {
            LOCK.lock();
            try {
                if (num != 2) {
                    conditionB.await();
                }
                System.out.print(Thread.currentThread().getName());
                num = 3;
                conditionC.signal();
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        }

        public static void printC() {
            LOCK.lock();
            try {
                if (num != 3) {
                    conditionC.await();
                }
                System.out.println(Thread.currentThread().getName());
                num = 1;
                conditionA.signal();
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        }
    }
}
