package com.company;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BackSystem {
    private int balance = 0;
    private Lock lock = new ReentrantLock();
    private Condition balanceIncreased = lock.newCondition();

    public boolean add(int sum) {
        System.out.printf("Увеличиваю баланс на %d. Текущий баланс: %d\n", sum, balance);
        lock.lock();
        try {
            balance += sum;
            balanceIncreased.signalAll();
        }
        finally {
            lock.unlock();
        }
        System.out.printf("Новый баланс: %d\n", balance);
        return true;
    }

    public boolean waitAndSubtract(int sum) throws InterruptedException {
        System.out.printf("Уменьшаю баланс на %d. Текущий баланс: %d\n", sum, balance);
        lock.lock();
        try {
            while (balance - sum < 0) {
                balanceIncreased.await();
            }
            balance -= sum;
            System.out.printf("Новый баланс: %d\n", balance);
            return true;
        }
        finally {
            lock.unlock();
        }
    }
}
