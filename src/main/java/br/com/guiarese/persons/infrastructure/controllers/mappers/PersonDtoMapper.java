package br.com.guiarese.persons.infrastructure.controllers.mappers;

import br.com.guiarese.persons.domain.Person;
import br.com.guiarese.persons.infrastructure.controllers.dtos.CreatePersonRequest;
import br.com.guiarese.persons.infrastructure.controllers.dtos.PersonResponse;

public class PersonDtoMapper {

    public PersonResponse toResponseDto(Person person) {
        return PersonResponse.builder()
                .id(person.id())
                .name(person.name())
                .age(person.age())
                .cep(person.cep())
                .street(person.street())
                .city(person.city())
                .state(person.state())
                .build();
    }

    public Person toDomain(CreatePersonRequest request) {
        return new Person(
                request.name(),
                request.age(),
                request.cep()
        );
    }

}
