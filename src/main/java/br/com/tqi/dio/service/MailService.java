package br.com.tqi.dio.service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MailService {

    private static final Logger logger = LoggerFactory.getLogger(MailService.class);

    private static final String SENDER_MAIL = "mentoria@tqi.com.br";

    @Autowired
    private AmazonSimpleEmailService amazonSimpleEmailService;

    public void sendEmail(String email) {
        final String body = String.format("Olá %s nós do Banco X identificamos que você acaba de realizar uma transação. " +
                "\nCaso não tenha sindo você entre em contato o quanto antes para verificarmos a sua situação\n\n", email);
        final String subject = "Você acabou de realizar uma transação " + new Random().nextInt();
        SendEmailRequest request = new SendEmailRequest()
                .withDestination(new Destination().withToAddresses(email))
                .withMessage(new Message()
                        .withBody(new Body().withText(new Content().withCharset("UTF-8").withData(body)))
                        .withSubject(new Content().withCharset("UTF-8").withData(subject)))
                .withSource(SENDER_MAIL);
        amazonSimpleEmailService.sendEmail(request);
        logger.info("Email sent to={} sender={}", email, SENDER_MAIL);
    }

}
