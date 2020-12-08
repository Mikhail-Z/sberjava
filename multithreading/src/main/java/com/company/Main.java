package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int CLIENT_COUNT = 20;
    private static int HANDLER_COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        FrontSystem frontSystem = new FrontSystem();
        BackSystem backSystem = new BackSystem();
        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < CLIENT_COUNT; i++) {
            Client client = new Client(frontSystem);
            client.start();
            clients.add(client);
        }

        List<RequestHandler> handlers = new ArrayList<>();
        for (int i = 0; i < HANDLER_COUNT; i++) {
            RequestHandler requestHandler = new RequestHandler(frontSystem, backSystem);
            requestHandler.start();
            handlers.add(requestHandler);
        }

        System.out.println("all clients are runnable");

        for (Client client : clients) {
            client.join();
        }

        System.out.println("the end...");
    }
}
