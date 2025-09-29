package br.com.guiareze.persons.application;

import br.com.guiareze.persons.gateway.PersonRepositoryGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePersonById {

    private final PersonRepositoryGateway personRepositoryGateway;

    public void deletePersonById(String id) {
        personRepositoryGateway.deletePersonById(id);
    }

}
