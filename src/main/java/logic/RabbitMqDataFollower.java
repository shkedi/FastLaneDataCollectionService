package logic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import model.FastLaneConstant;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMqDataFollower implements DataFollower {

    public RabbitMqDataFollower() {

    }

    @Override
    public void follow(String data) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = null;
        Channel channel = null;

        try {
            try {
                connection = factory.newConnection();
                channel = connection.createChannel();
                channel.queueDeclare(FastLaneConstant.PERSISTENCE_QUEUE, false, false, false, null);
                String message = "Hello World!";
                channel.basicPublish("", FastLaneConstant.PERSISTENCE_QUEUE, null, data.getBytes());
                System.out.println(" [x] Sent '" + message + "'");
            } finally {
                channel.close();
                connection.close();
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
