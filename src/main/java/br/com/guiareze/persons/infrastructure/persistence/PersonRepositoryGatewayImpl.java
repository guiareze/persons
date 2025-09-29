package br.com.guiareze.persons.infrastructure.persistence;

import br.com.guiareze.persons.domain.Person;
import br.com.guiareze.persons.gateway.PersonRepositoryGateway;
import br.com.guiareze.persons.infrastructure.persistence.mapper.PersonEntityMapper;
import br.com.guiareze.persons.infrastructure.persistence.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PersonRepositoryGatewayImpl implements PersonRepositoryGateway {

    private final PersonRepository repository;
    private final PersonEntityMapper mapper;

    @Override
    public Person createPerson(Person person) {
        log.info("Saving person to database: {}", person);
        var entityToSave = mapper.toEntity(person);
        var responsedEntity = repository.save(entityToSave);
        return mapper.toDomain(responsedEntity);
    }

}
