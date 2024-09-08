package br.xksoberbado.insertexample.scheduling;

import br.xksoberbado.insertexample.model.Person;
import br.xksoberbado.insertexample.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.jeasy.random.EasyRandom;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MyScheduler {

    private static final EasyRandom EASY_RANDOM = new EasyRandom();

    private final PersonRepository repository;

    @Scheduled(cron = "*/2 * * * * *")
    public void run() {
        final var person = Person.of(UUID.randomUUID(), EASY_RANDOM.nextObject(String.class));

        repository.save(person);
    }
}
