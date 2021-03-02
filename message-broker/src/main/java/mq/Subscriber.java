package mq;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Document;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.*;

public class Subscriber implements ExceptionListener {

    public void subscribe(String topic) {
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
            JMSConsumer consumer = ctx.createConsumer(destination, "event = 'create'");
            consumer.setMessageListener(message -> {
                try {
                    if (message == null) return;
                    if (message instanceof BytesMessage) {
                        BytesMessage bytesMessage = (BytesMessage) message;
                        var bytes = new byte[(int) bytesMessage.getBodyLength()];
                        bytesMessage.readBytes(bytes);
                        var objectMapper = new ObjectMapper();
                        Document document = objectMapper.readValue(bytes, Document.class);
                        System.out.println(document.getText());
                    } else {
                        System.out.println("Received: " + message);
                    }
                    message.acknowledge();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            while (true);
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public synchronized void onException(JMSException ex) {
        System.out.println("JMS Exception occured.  Shutting down client.");
    }
}
