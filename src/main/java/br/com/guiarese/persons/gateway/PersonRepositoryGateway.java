package br.com.guiarese.persons.gateway;

import br.com.guiarese.persons.domain.Person;

public interface PersonRepositoryGateway {

    Person createPerson(Person person);

}
