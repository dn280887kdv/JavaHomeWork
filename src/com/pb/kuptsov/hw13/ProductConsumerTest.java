package com.pb.kuptsov.hw13;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ProductConsumerTest {

        static class Consumer implements Runnable {

            private final Object readLock;
            private List<Integer> list;

            public Consumer(Object readLock, List<Integer> list) {
                this.readLock = readLock;
                this.list = list;
            }

            public void run() {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " пользователь получил объект");
                try {
                    int seconds = new Random().nextInt(10);
                        readLock.wait();
                    System.out.println(threadName + " Время задержки чтения: " + seconds + " секунд.");
                    Thread.sleep(seconds * 1000);
                    String str = "";
                    for(Integer i: list){
                        str += i + " ";
                    }
                    System.out.println(threadName + " Читаем буфер: " + str);
                    list = null;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    readLock.notify();
                    System.out.println(threadName + " пользователь завершил чтение");
                }
            }
        }

        static class Product implements Runnable {

            private final Object writeLock;
            private final List<Integer> list;

            public Product(Lock writeLock, List<Integer> list) {
                this.writeLock = writeLock;
                this.list = list;
            }

            public void run() {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " попытка потребителя получить lock");

                System.out.println(threadName + " потребитель получил lock");
                try {
                    writeLock.wait();
                    int seconds = new Random().nextInt(10);
                    System.out.println(threadName + " Время задержки записи: " + seconds + " секунд.");
                    Thread.sleep(seconds * 1000);
                    for(int i = 0; i < 5; i++){
                        list.add(new Random().nextInt(10));
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    writeLock.notify();
                    System.out.println(threadName + " потребитель unlock");
                }
            }
        }

        public static void main(String[] args) {
            ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
            Lock readLock = readWriteLock.readLock();
            Lock writeLock = readWriteLock.writeLock();

            StringBuffer buffer = new StringBuffer("---");

            Thread productA = new Thread(new Product(writeLock, buffer));
            Thread productB = new Thread(new Product(writeLock, buffer));
            Thread productC = new Thread(new Product(writeLock, buffer));
            productA.setName("ProductA");
            productB.setName("ProductB");
            productC.setName("ProductC");

            Thread сonsumer1 = new Thread(new Consumer(readLock, buffer));
            Thread сonsumer2 = new Thread(new Consumer(readLock, buffer));
            сonsumer1.setName("Consumer1");
            сonsumer2.setName("Consumer2");

            productA.start();
            сonsumer1.start();

            productB.start();
            productC.start();

            сonsumer2.start();
        }
}
