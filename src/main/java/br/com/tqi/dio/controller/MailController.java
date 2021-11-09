package br.com.tqi.dio.controller;

import br.com.tqi.dio.queue.MailProducerQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailController {

	private static final Logger logger = LoggerFactory.getLogger(MailController.class);

	@Autowired
	private MailProducerQueue mailProducerQueue;

	@GetMapping
	public String welcome() {
		return "WELCOME";
	}

	@PostMapping("/send/{email}")
	public void sendMail(@PathVariable String email) {
		logger.info("Sending email to={}", email);
		mailProducerQueue.convertAndSend(email);
	}

}
