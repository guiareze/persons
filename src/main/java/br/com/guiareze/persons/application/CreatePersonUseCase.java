package br.com.guiareze.persons.application;

import br.com.guiareze.persons.domain.CepInfo;
import br.com.guiareze.persons.domain.Person;
import br.com.guiareze.persons.gateway.CepInfoGateway;
import br.com.guiareze.persons.gateway.PersonRepositoryGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePersonUseCase {

    private final PersonRepositoryGateway personRepositoryGateway;
    private final CepInfoGateway cepInfoGateway;

    public Person createPerson(Person person) {
        Person newPerson = generateNewPersonWithAddress(person, cepInfoGateway.getCepInfo(person.cep()));
        return personRepositoryGateway.createPerson(newPerson);
    }

    private Person generateNewPersonWithAddress(Person person, CepInfo cepInfo) {
        return person.toBuilder()
                .street(cepInfo.logradouro())
                .city(cepInfo.localidade())
                .state(cepInfo.estado())
                .build();
    }

}
