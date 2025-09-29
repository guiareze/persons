package br.com.guiareze.persons.infrastructure.persistence.repository;

import br.com.guiareze.persons.infrastructure.persistence.entity.PersonEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<PersonEntity, String> {
}
