package br.com.tqi.dio.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MailProducerQueue {

    private static final Logger logger = LoggerFactory.getLogger(MailProducerQueue.class);

    @Value("${aws.e-mail.queue}")
    private String queue;

    @Autowired
    private JmsTemplate jmsTemplate;

    public void convertAndSend(String message) {
        logger.info("Send message={}", message);
        jmsTemplate.convertAndSend(queue, message);
    }

}
