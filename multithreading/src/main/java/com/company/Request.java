package com.company;

import java.util.UUID;

public class Request {
    private RequestType requestType;
    private int sum;
    private UUID uuid = UUID.randomUUID();

    public Request(RequestType requestType, int sum) {
        this.requestType = requestType;
        this.sum = sum;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public int getSum() {
        return sum;
    }

    public UUID getUuid() {
        return uuid;
    }
}
