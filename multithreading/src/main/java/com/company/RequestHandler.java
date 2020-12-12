package com.company;

public class RequestHandler implements Runnable {
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
        }
    }

    private void handleRequest(Request request) {
        System.out.printf("Выполнение операции %s\n", request.getUuid());
        if (request.getRequestType() == RequestType.Add) {
            backSystem.add(request.getSum());
        }
        else if (request.getRequestType() == RequestType.Subtract) {
            try {
                backSystem.waitAndSubtract(request.getSum());
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
