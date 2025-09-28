package br.com.guiarese.persons.application;

import br.com.guiarese.persons.domain.CepInfo;
import br.com.guiarese.persons.domain.Person;
import br.com.guiarese.persons.gateways.CepInfoGateway;
import br.com.guiarese.persons.gateways.PersonRepositoryGateway;
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
