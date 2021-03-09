package mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Document;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.*;

public class Publisher {

    public void publish(String topic, byte[] data) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = null;
        try {
            connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }

        try (var ctx = connectionFactory.createContext()) {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic(topic);
            JMSProducer producer = ctx.createProducer();
            var message = session.createBytesMessage();
            message.writeBytes(data);
            message.setStringProperty("event", "create");
            message.setJMSRedelivered(true);
            producer.send(destination, message);
        }
    }
}
