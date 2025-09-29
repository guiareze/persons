package br.com.guiareze.persons.gateway;

import br.com.guiareze.persons.domain.Person;

public interface PersonRepositoryGateway {

    Person createPerson(Person person);

}
