package br.xksoberbado.mongodbchangestreamsex.scheduling;

import br.xksoberbado.mongodbchangestreamsex.model.Person;
import br.xksoberbado.mongodbchangestreamsex.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MyScheduler {

    private final PersonRepository repository;

    @Scheduled(cron = "*/10 * * * * *")
    public void run() {
        final var person = Person.of(UUID.randomUUID(), "Maria");

        repository.save(person);
    }
}
