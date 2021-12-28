package com.pb.kuptsov.hw13;


import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerTest {

    public static void main(String[] args) {

        Lock aLock = new ReentrantLock();
        Condition bufferNotFull = aLock.newCondition();
        Condition bufferNotEmpty = aLock.newCondition();

        List<Integer> list = new ArrayList<>();

        Producer p = new Producer(aLock, bufferNotEmpty, bufferNotFull, list);
        Consumer c = new Consumer(aLock, bufferNotFull, bufferNotEmpty, list);

        p.start();
        c.start();
    }

}

class Producer extends Thread {

    private static final int LIMIT = 10;
    private final Condition bufferNotEmpty;
    private final Condition bufferNotFull;
    private final List<Integer> list;
    private final Lock lock;

    public Producer(Lock lock, Condition bufferNotEmpty, Condition bufferNotFull, List<Integer> list) {
        super("PRODUCER");
        this.bufferNotEmpty = bufferNotEmpty;
        this.bufferNotFull = bufferNotFull;
        this.list = list;
        this.lock = lock;
    }

    public void put() throws InterruptedException {
        lock.lock();
        try {
            while (list.size() == LIMIT) {
                System.out.println(Thread.currentThread().getName() + " : Буфер заполнен, ожидание");
                bufferNotEmpty.await();
                bufferNotFull.signalAll();
            }

            int number = new Random().nextInt(10);
            boolean isAdded = list.add(number);
            if (isAdded) {
                System.out.printf("%s добавил число %d в буфер %n", Thread.currentThread().getName(), number);
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        try {
            for(;;){
                put();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {
    private final Condition bufferNotEmpty;
    private final Condition bufferNotFull;
    private final List<Integer> list;
    private final Lock lock;

    public Consumer(Lock lock, Condition bufferNotFull, Condition bufferNotEmpty, List<Integer> list) {
        super("CONSUMER");
        this.bufferNotFull = bufferNotFull;
        this.list = list;
        this.lock = lock;
        this.bufferNotEmpty = bufferNotEmpty;
    }

    public void get() throws InterruptedException {
        lock.lock();
        try {
            while (list.size() == 0) {
                System.out.println(Thread.currentThread().getName()
                        + " : Буфер пуст, ожидание");
                bufferNotEmpty.signalAll();
                bufferNotFull.await();
            }

            for(Integer o: list){
                if (o != null) {
                    System.out.printf("%s получено число %d из буфера %n", Thread
                            .currentThread().getName(), o);
                    Thread.sleep(1000);
                }
            }
            list.removeAll(list);


        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        try {
            for(;;){
                get();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}