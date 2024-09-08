package br.xksoberbado.streamerexample.stream;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
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
public class Streamer implements CommandLineRunner {

    private final ReactiveMongoOperations reactiveMongoOperations;

    @Override
    public void run(final String... args) throws Exception {
        final var stream = reactiveMongoOperations.changeStream(
            "persons",
            ChangeStreamOptions.builder().filter(newAggregation(match(where("operationType").is("insert")))).build(),
            Person.class
        );

        stream.doOnNext(event -> log.info(String.format("Received Message in collection %s.\n\trawsource: %s\n\tconverted: %s", event.getCollectionName(), event.getRaw(), event.getBody())))
            .subscribe();
    }

    @Data
    private static class Person {

        private UUID id;

        private String name;
    }
}
