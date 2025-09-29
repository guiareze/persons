package br.com.guiareze.persons.gateway;

import br.com.guiareze.persons.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepositoryGateway {

    Person savePerson(Person person);
    List<Person> getAllPersons();
    Optional<Person> getPersonById(String id);
    void deletePersonById(String id);

}
