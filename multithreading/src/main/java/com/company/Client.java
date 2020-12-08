package com.company;

import java.time.Instant;
import java.util.Random;

public class Client extends Thread {
    private FrontSystem frontSystem;
    private Random random = new Random();

    public Client(FrontSystem frontSystem) {
        this.frontSystem = frontSystem;
    }

    @Override
    public void run() {
        int sum = 10;
        try {
            //в 75% добавление на счет идет
            RequestType requestType = random.nextInt(4)  == 3 ? RequestType.Subtract : RequestType.Add;
            System.out.printf("Добавление во фронтальную систему операции %s на сумму %d\n", requestType, sum);
            frontSystem.add(new Request(requestType, sum));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
