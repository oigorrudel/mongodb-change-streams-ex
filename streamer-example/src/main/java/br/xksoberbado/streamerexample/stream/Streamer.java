package br.xksoberbado.streamerexample.stream;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.ChangeStreamOptions;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Slf4j
@Component
@RequiredArgsConstructor
public class Streamer {

    private final ReactiveMongoOperations reactiveMongoOperations;

    @Scheduled(initialDelay = 1)
    public void run() {
        final var stream = reactiveMongoOperations.changeStream(
            "persons",
            ChangeStreamOptions.builder().filter(newAggregation(match(where("operationType").is("insert")))).build(),
            Person.class
        );

        stream.doOnNext(event -> log.info(String.format("Received: %s", event.getBody())))
            .subscribe();
    }

    @Data
    private static class Person {
        private UUID id;
        private String name;
        private Integer number;
    }
}
