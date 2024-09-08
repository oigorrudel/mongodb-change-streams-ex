package br.xksoberbado.mongodbchangestreamsex.repository;

import br.xksoberbado.mongodbchangestreamsex.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface PersonRepository extends MongoRepository<Person, UUID> {
}
