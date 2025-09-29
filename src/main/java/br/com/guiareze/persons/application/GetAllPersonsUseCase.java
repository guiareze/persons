package br.com.guiareze.persons.application;

import br.com.guiareze.persons.domain.Person;
import br.com.guiareze.persons.gateway.PersonRepositoryGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllPersonsUseCase {

    private final PersonRepositoryGateway personRepositoryGateway;

    public Page<Person> getAllPersons(Pageable pageable) {
        return personRepositoryGateway.getAllPersons(pageable);
    }

}
