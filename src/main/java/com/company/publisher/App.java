package com.company.publisher;

import com.company.message.Task;
import com.company.publisher.utils.PublisherConstants;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import java.util.Random;


public class App {

    public static void main( String[] args ) throws JMSException, InterruptedException {

        MessagePublisher messagePublisher = new MessagePublisher();
        Session session = messagePublisher.getSession(PublisherConstants.CLIENT_ID);
        MessageProducer messageProducer = messagePublisher.getMessageProducer(session, PublisherConstants.QUEUE_NAME);

        //messagePublisher.sendMessage(session, messageProducer, "START");
        Thread.sleep(5000);
        while(true) {
            int randomVal = new Random().nextInt(PublisherConstants.ITEM_COUNT - 1);
            String itemName = PublisherConstants.AVAILABLE_ITEMS.get(randomVal);
            String itemLocation = PublisherConstants.ITEM_AVAILABLE_LOCATION.get(randomVal);
            Task task = new Task(itemName, itemLocation);
            messagePublisher.sendMessage(session, messageProducer, task);
            Thread.sleep(2000);
        }
    }

}
