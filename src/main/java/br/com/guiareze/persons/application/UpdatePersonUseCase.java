package br.com.guiareze.persons.application;

import br.com.guiareze.persons.domain.CepInfo;
import br.com.guiareze.persons.domain.Person;
import br.com.guiareze.persons.gateway.CepInfoGateway;
import br.com.guiareze.persons.gateway.PersonRepositoryGateway;
import br.com.guiareze.persons.infrastructure.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdatePersonUseCase {

    private final PersonRepositoryGateway personRepositoryGateway;
    private final CepInfoGateway cepInfoGateway;

    public Person updatePerson(Person person) {
        Person personSaved = personRepositoryGateway
                .getPersonById(person.getId())
                .orElseThrow(() -> new BusinessException("Person should be created before to be updated. ID: " + person.getId()));
        if (!person.getCep().equals(personSaved.getCep())){
            CepInfo cepInfo = cepInfoGateway.getCepInfo(person.getCep());
            person.enrichAddress(cepInfo.logradouro(), cepInfo.localidade(), cepInfo.estado());
        }
        return personRepositoryGateway.savePerson(person);
    }

}
