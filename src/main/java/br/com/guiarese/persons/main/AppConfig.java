package br.com.guiarese.persons.main;

import br.com.guiarese.persons.application.CreatePersonUseCase;
import br.com.guiarese.persons.infrastructure.controllers.mappers.PersonDtoMapper;
import br.com.guiarese.persons.infrastructure.persistence.PersonRepositoryMongoGateway;
import br.com.guiarese.persons.infrastructure.persistence.mappers.PersonEntityMapper;
import br.com.guiarese.persons.infrastructure.persistence.repository.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean("mongodb")
    public CreatePersonUseCase createPersonUseCaseMongo(PersonRepositoryMongoGateway usuarioGateway) {
        return new CreatePersonUseCase(usuarioGateway);
    }

    @Bean
    public PersonRepositoryMongoGateway personRepositoryMongoGateway(PersonRepository repository, PersonEntityMapper mapper) {
        return new PersonRepositoryMongoGateway(repository, mapper);
    }

    @Bean
    public PersonEntityMapper personEntityMapper() {
        return new PersonEntityMapper();
    }

    @Bean
    public PersonDtoMapper personDtoMapper() {
        return new PersonDtoMapper();
    }

}
