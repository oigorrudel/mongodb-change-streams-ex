package br.xksoberbado.mongodbchangestreamsex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MongodbChangeStreamsExApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbChangeStreamsExApplication.class, args);
    }
}
