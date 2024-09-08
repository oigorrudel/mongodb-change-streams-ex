package br.xksoberbado.insertexample.repository;

import br.xksoberbado.insertexample.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface PersonRepository extends MongoRepository<Person, UUID> {
}
