package br.com.guiareze.persons.infrastructure.persistence;

import br.com.guiareze.persons.domain.Person;
import br.com.guiareze.persons.gateway.PersonRepositoryGateway;
import br.com.guiareze.persons.infrastructure.persistence.mapper.PersonEntityMapper;
import br.com.guiareze.persons.infrastructure.persistence.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class PersonRepositoryGatewayImpl implements PersonRepositoryGateway {

    private final PersonRepository repository;
    private final PersonEntityMapper mapper;

    @Override
    public Person savePerson(Person person) {
        log.info("Saving person to database: {}", person.toString());
        var entityToSave = mapper.toEntity(person);
        var responsedEntity = repository.save(entityToSave);
        return mapper.toDomain(responsedEntity);
    }

    @Override
    public Page<Person> getAllPersons(Pageable pageable) {
        log.info("Retrieving all persons from database");
        return repository.findAll(pageable).map(mapper::toDomain);
    }

    @Override
    public Optional<Person> getPersonById(String id) {
        log.info("Retrieving person by ID from database: {}", id);
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public void deletePersonById(String id) {
        log.info("Deleting person by ID from database: {}", id);
        repository.deleteById(id);
    }

}
