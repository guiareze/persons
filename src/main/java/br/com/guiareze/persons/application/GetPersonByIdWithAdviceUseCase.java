package br.com.guiareze.persons.application;

import br.com.guiareze.persons.domain.Person;
import br.com.guiareze.persons.gateway.AdviceGateway;
import br.com.guiareze.persons.gateway.PersonRepositoryGateway;
import br.com.guiareze.persons.infrastructure.exception.DatabaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPersonByIdWithAdviceUseCase {

    private final PersonRepositoryGateway personRepositoryGateway;
    private final AdviceGateway adviceGateway;

    public Person getPersonNameWithAdviceById(String id) {
        var person = personRepositoryGateway.getPersonById(id)
                .orElseThrow(() -> new DatabaseException("Person not found with ID: " + id));
        person.setAdvice(adviceGateway.getRandomAdvice(id));
        return person;
    }
}
