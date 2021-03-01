import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Document;
import mq.Publisher;
import mq.Subscriber;

import javax.jms.JMSException;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws JMSException, JsonProcessingException {
        var publisher = new Publisher();
        for (int i = 0; i < 100; i++) {
            Document document = new Document(UUID.randomUUID(), String.format("Hello world %s", i));
            ObjectMapper objectMapper = new ObjectMapper();
            byte[] jsonBytes = objectMapper.writeValueAsBytes(document);
            publisher.publish("default", jsonBytes);
        }

        Subscriber subscriber = new Subscriber();
        Thread t1 = new Thread(() -> subscriber.subscribe("default"));
        //Thread t2 = new Thread(() -> subscriber.subscribe("default"));
        t1.start();
        //t2.start();
        try {
            t1.join();
            //t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
    }
}
