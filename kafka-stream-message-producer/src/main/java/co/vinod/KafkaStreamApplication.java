package co.vinod;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@EnableScheduling
@EnableBinding(Source.class)
@RestController
@SpringBootApplication
public class KafkaStreamApplication {

	@Autowired
	private MessageChannel output;

	@Scheduled(fixedRate = 5000)
	public void timeCheck() {
		String payload = "Current time is: " + new Date().toString();
		output.send(MessageBuilder.withPayload(payload).build());
	}

	@PostMapping("/api/data")
	public Map<String, Object> post(@RequestBody Map<String, Object> data) {
		output.send(MessageBuilder.withPayload(data).build());
		return data;
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaStreamApplication.class, args);
	}
}
