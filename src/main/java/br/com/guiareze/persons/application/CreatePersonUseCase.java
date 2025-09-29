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
        CepInfo cepInfo = cepInfoGateway.getCepInfo(person.getCep());
        person.enrichAddress(cepInfo.logradouro(), cepInfo.localidade(), cepInfo.estado());
        return personRepositoryGateway.createPerson(person);
    }

}
