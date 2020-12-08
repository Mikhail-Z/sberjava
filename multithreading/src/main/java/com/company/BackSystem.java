package com.company;

import java.util.UUID;

public class BackSystem {
    private int balance = 0;

    public synchronized boolean add(int sum) {
        System.out.printf("Операция %s. Увеличиваю баланс на %d. Текущий баланс: %d\n", sum, balance);
        balance += sum;
        System.out.printf("Новый баланс: %d\n", balance);
        return true;
    }

    public synchronized boolean subtract(int sum) {
        System.out.printf("Операция %s. Уменьшаю баланс на %d. Текущий баланс: %d\n", sum, balance);
        if (balance - sum >= 0) {
            balance -= sum;
            System.out.printf("Новый баланс: %d\n", balance);
            return true;
        }
        System.out.println("Недостаточно средств на счете при попытке уменьшить баланс");
        return false;
    }
}
