package br.xksoberbado.streamerexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class StreamerExampleApplication {

    public static void main(final String[] args) {
        SpringApplication.run(StreamerExampleApplication.class, args);
    }
}
