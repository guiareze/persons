package br.com.guiarese.persons.infrastructure.persistence.mapper;

import br.com.guiarese.persons.domain.Person;
import br.com.guiarese.persons.infrastructure.persistence.entity.PersonEntity;

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
