package br.com.tqi.dio.queue;

import br.com.tqi.dio.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MailConsumerQueue {

    private static final Logger logger = LoggerFactory.getLogger(MailConsumerQueue.class);

    @Autowired
    private MailService mailService;

    @JmsListener(destination = "${aws.e-mail.queue}")
    public void receiveMessage(String message) {
        logger.info("Receive message={}", message);
        mailService.sendEmail(message);
    }

}
