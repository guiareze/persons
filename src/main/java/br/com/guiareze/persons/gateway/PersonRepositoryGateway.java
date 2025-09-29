package br.com.guiareze.persons.gateway;

import br.com.guiareze.persons.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PersonRepositoryGateway {

    Person savePerson(Person person);
    Page<Person> getAllPersons(Pageable pageable);
    Optional<Person> getPersonById(String id);
    void deletePersonById(String id);

}
