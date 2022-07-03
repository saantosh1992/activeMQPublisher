package com.company.publisher;

import com.company.publisher.utils.ActiveMQUtils;
import org.apache.log4j.Logger;

import javax.jms.*;
import java.io.Serializable;

public class MessagePublisher {
    private static final Logger LOGGER = Logger.getLogger(MessagePublisher.class);

    public Session getSession(String clientId) {
        Connection connection = ActiveMQUtils.getConnection();
        return ActiveMQUtils.getSession(connection, clientId);

    }

    public MessageProducer getMessageProducer(Session session, String queue) {
        try {
            if (session != null ) {
                return ActiveMQUtils.getMessagePublisher(queue, session);
            }
        }catch (JMSException jmse) {
            LOGGER.error("Error while creating message producer:{}", jmse);
        }
        return null;
    }

    public void sendMessage(Session session, MessageProducer messageProducer, Serializable message)
            throws JMSException {
        if (messageProducer != null && session != null) {
            ObjectMessage objectMessage = session.createObjectMessage(message);
            // send the message to the topic destination
            messageProducer.send(objectMessage);
            LOGGER.info("Publisher: Sent message with info:{}" + message);
        }
    }

}
