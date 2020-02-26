package co.vinod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableBinding(Sink.class)
@SpringBootApplication
public class KafkaStreamClient {

	@StreamListener("input")
	public void post(Object data) {
		log.info("Got this message: {}", data);
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaStreamClient.class, args);
	}
}
