package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class FrontSystem {

    private static final int MAX_REQUESTS_NUMBER = 2;

    private Queue<Request> requests = new LinkedList<>();

    public synchronized void add(Request request) throws InterruptedException {
        System.out.printf("Добавление во фронтальную систему заявки с типом %s\n", request.getRequestType());
        while (requests.size() >= MAX_REQUESTS_NUMBER) {
            System.out.printf("Поток %d: Превышено кол-во заявок в фронтальной системе\n", Thread.currentThread().getId());
            wait();
        }
        System.out.printf("Поток %d продолжил выполнять добавление заявки\n", Thread.currentThread().getId());
        requests.add(request);
        notify();
    }

    public synchronized Request getNewRequest() throws InterruptedException {
        while (requests.size() < 1) {
            System.out.printf("Поток %d: В фронтальной системе отсутствуют заявки\n", Thread.currentThread().getId());
            wait();
        }

        System.out.printf("Поток %d продолжил выполнять получение новой заявки\n", Thread.currentThread().getId());
        Request request = requests.poll();
        if (request == null) {
            System.out.println("!!! Пустая заявка была взята из фронтальной системы !!!\n");
        }
        notify();
        return request;
    }
}
