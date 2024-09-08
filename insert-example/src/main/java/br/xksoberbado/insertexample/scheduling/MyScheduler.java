package br.xksoberbado.insertexample.scheduling;

import br.xksoberbado.insertexample.model.Person;
import br.xksoberbado.insertexample.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.jeasy.random.EasyRandom;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@RequiredArgsConstructor
public class MyScheduler {

    private static final EasyRandom EASY_RANDOM = new EasyRandom();
    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    private final PersonRepository repository;


    @Scheduled(cron = "*/1 * * * * *")
    public void run() {
        final var people = EASY_RANDOM.objects(Person.class, 1000)
            .peek(person -> person.setNumber(atomicInteger.getAndIncrement()))
            .toList();

        repository.saveAll(people);
    }
}
