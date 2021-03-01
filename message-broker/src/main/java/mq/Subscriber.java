package mq;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Document;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.*;

public class Subscriber implements ExceptionListener {

    public void subscribe(String topic) {
        Connection connection = null;
        Session session = null;
        MessageConsumer consumer = null;
        try {
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");

            connection = connectionFactory.createConnection();
            connection.start();

            connection.setExceptionListener(this);

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createTopic(topic);

            consumer = session.createConsumer(destination);

            consumer.setMessageListener(message -> {
                try {
                    if (message == null) return;
                    String event = message.getStringProperty("event");
                    System.out.println(event);
                    System.out.println(message.getJMSRedelivered());
                    if (message instanceof BytesMessage) {
                        BytesMessage bytesMessage = (BytesMessage)message;
                        var bytes = new byte[(int)bytesMessage.getBodyLength()];
                        bytesMessage.readBytes(bytes);
                        var objectMapper = new ObjectMapper();
                        Document document = objectMapper.readValue(bytes, Document.class);
                        System.out.println(document.getText());
                    } else {
                        System.out.println("Received: " + message);
                    }

                    //message.acknowledge();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            });

            while (true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (connection != null) connection.close();
                if (consumer != null) consumer.close();
                if (session != null) session.close();
            }
            catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void onException(JMSException ex) {
        System.out.println("JMS Exception occured.  Shutting down client.");
    }
}
