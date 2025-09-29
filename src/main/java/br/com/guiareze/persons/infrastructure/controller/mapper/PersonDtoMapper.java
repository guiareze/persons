package br.com.guiareze.persons.infrastructure.controller.mapper;

import br.com.guiareze.persons.domain.Person;
import br.com.guiareze.persons.infrastructure.controller.dto.CreatePersonRequest;
import br.com.guiareze.persons.infrastructure.controller.dto.PersonResponse;

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
