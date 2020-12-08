package com.company;

import java.util.Optional;

public class RequestHandler extends Thread {
    private FrontSystem frontSystem;
    private BackSystem backSystem;

    public RequestHandler(FrontSystem frontSystem, BackSystem backSystem) {
        super();
        this.frontSystem = frontSystem;
        this.backSystem = backSystem;
    }

    @Override
    public void run() {
        while (true) {
            Request newRequest = null;
            try {
                newRequest = frontSystem.getNewRequest();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            handleRequest(newRequest);
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private void handleRequest(Request request) {
        System.out.printf("Выполнение операции %s\n", request.getUuid());
        if (request.getRequestType() == RequestType.Add) {
            backSystem.add(request.getSum());
        }
        else if (request.getRequestType() == RequestType.Subtract) {
            backSystem.subtract(request.getSum());
        }
    }
}
