package br.com.guiarese.persons.infrastructure.persistence;

import br.com.guiarese.persons.domain.Person;
import br.com.guiarese.persons.infrastructure.persistence.mapper.PersonEntityMapper;
import br.com.guiarese.persons.infrastructure.persistence.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PersonRepositoryGatewayImpl implements br.com.guiarese.persons.gateway.PersonRepositoryGateway {

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
