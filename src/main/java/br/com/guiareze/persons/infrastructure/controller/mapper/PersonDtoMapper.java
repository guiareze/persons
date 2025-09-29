package br.com.guiareze.persons.infrastructure.controller.mapper;

import br.com.guiareze.persons.domain.Person;
import br.com.guiareze.persons.infrastructure.controller.dto.PersonRequest;
import br.com.guiareze.persons.infrastructure.controller.dto.PersonResponse;

public class PersonDtoMapper {

    public PersonResponse toResponseDto(Person person) {
        return PersonResponse.builder()
                .id(person.getId())
                .name(person.getName())
                .age(person.getAge())
                .cep(person.getCep())
                .street(person.getStreet())
                .city(person.getCity())
                .state(person.getState())
                .build();
    }

    public Person toDomain(PersonRequest request) {
        return new Person(
                request.name(),
                request.age(),
                request.cep()
        );
    }

    public Person toDomain(PersonRequest request, String id) {
        return new Person(
                id,
                request.name(),
                request.age(),
                request.cep()
        );
    }

}
