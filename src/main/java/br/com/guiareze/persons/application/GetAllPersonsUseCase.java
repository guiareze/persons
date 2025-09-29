package br.com.guiareze.persons.application;

import br.com.guiareze.persons.domain.Person;
import br.com.guiareze.persons.gateway.PersonRepositoryGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllPersonsUseCase {

    private final PersonRepositoryGateway personRepositoryGateway;

    public List<Person> getAllPersons() {
        return personRepositoryGateway.getAllPersons();
    }

}
