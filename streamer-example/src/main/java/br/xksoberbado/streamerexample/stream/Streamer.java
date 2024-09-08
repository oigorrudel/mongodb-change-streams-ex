package br.xksoberbado.streamerexample.stream;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.core.ChangeStreamOptions;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Slf4j
@Component
@RequiredArgsConstructor
public class Streamer implements ApplicationRunner {

    private final ReactiveMongoOperations reactiveMongoOperations;

    @Override
    public void run(final ApplicationArguments args) throws Exception {
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
    }
}
