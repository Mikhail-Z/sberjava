package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static int CLIENT_COUNT = 20;
    private static int THREAD_COUNT = 4;
    private static int HANDLER_COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        FrontSystem frontSystem = new FrontSystem();
        ExecutorService clientsExecutorService = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < CLIENT_COUNT; i++) {
            clientsExecutorService.submit(new Client(frontSystem));
        }

        BackSystem backSystem = new BackSystem();
        ExecutorService handlersExecutorService = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < HANDLER_COUNT; i++) {
            handlersExecutorService.submit(new RequestHandler(frontSystem, backSystem));
        }

        System.out.println("the end...");
    }
}
