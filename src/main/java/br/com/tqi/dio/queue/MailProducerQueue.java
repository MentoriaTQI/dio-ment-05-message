package br.com.tqi.dio.queue;

import com.amazonaws.services.sqs.AmazonSQS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MailProducerQueue {

    private static final Logger logger = LoggerFactory.getLogger(MailProducerQueue.class);

    @Autowired
    private AmazonSQS amazonSQS;

    @Value("${aws.e-mail.queue}")
    private String queue;

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    public void convertAndSend(String message) {
        logger.info("Send message={}", message);
        queueMessagingTemplate.convertAndSend(queue, message);
    }

}
