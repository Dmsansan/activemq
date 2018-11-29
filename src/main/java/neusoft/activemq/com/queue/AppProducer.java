package neusoft.activemq.com.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class AppProducer {
    private static final String url = "tcp://47.96.179.77:61616";
    private static final String queueName="queue-test";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(queueName);
        MessageProducer producer = session.createProducer(destination);
        for (int i = 0; i < 100; i++) {
            TextMessage textMessage = session.createTextMessage("test"+i);
            producer.send(textMessage);
            System.out.println("发送的消息："+textMessage.getText());
        }
        connection.close();
    }
}
