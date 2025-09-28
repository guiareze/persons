package br.com.guiarese.persons.application;

import br.com.guiarese.persons.gateways.PersonRepositoryGateway;
import br.com.guiarese.persons.domain.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePersonUseCase {

    private final PersonRepositoryGateway personRepositoryGateway;

    public Person createPerson(Person person) {
        return personRepositoryGateway.createPerson(person);
    }

}
