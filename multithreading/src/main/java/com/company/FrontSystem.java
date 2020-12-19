package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class FrontSystem {

    private static final int MAX_REQUESTS_NUMBER = 2;

    private BlockingQueue<Request> requests = new ArrayBlockingQueue<>(MAX_REQUESTS_NUMBER);

    public void add(Request request) throws InterruptedException {
        requests.put(request);
        Future
    }

    public Request getNewRequest() throws InterruptedException {
        return requests.take();
    }
}
