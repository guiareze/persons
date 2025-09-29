package br.com.guiareze.persons.infrastructure.persistence.mapper;

import br.com.guiareze.persons.domain.Person;
import br.com.guiareze.persons.infrastructure.persistence.entity.PersonEntity;

public class PersonEntityMapper {

    public PersonEntity toEntity(Person person) {
        return new PersonEntity(
                null,
                person.name(),
                person.age(),
                person.cep(),
                person.street(),
                person.city(),
                person.state()
        );
    }

    public Person toDomain(PersonEntity entity) {
        return new Person(
                entity.id(),
                entity.name(),
                entity.age(),
                entity.cep(),
                entity.street(),
                entity.city(),
                entity.state()
        );
    }

}
