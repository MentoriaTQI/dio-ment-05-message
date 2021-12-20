package br.com.tqi.dio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableSqs
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
