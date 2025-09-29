package br.com.guiareze.persons.application;

import br.com.guiareze.persons.domain.Person;
import br.com.guiareze.persons.gateway.PersonRepositoryGateway;
import br.com.guiareze.persons.infrastructure.exception.DatabaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPersonByIdUseCase {

    private final PersonRepositoryGateway personRepositoryGateway;

    public Person getPersonById(String id) {
        return personRepositoryGateway.getPersonById(id).orElseThrow(() -> new DatabaseException("Person not found with ID: " + id));
    }

}
