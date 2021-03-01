package mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Document;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.UUID;

public class Publisher {

    public void publish(String topic, byte[] data) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");

        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createTopic(topic);

        //MessageProducer producer = session.createProducer(destination);
        MessageProducer producer = session.createProducer(null);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);

        var message = session.createBytesMessage();
        message.writeBytes(data);
        message.setStringProperty("event", "create");
        message.setJMSRedelivered(true);
        producer.send(destination, message);

        session.close();
        connection.close();
    }
}
