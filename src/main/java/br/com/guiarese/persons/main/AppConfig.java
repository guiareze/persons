package br.com.guiarese.persons.main;

import br.com.guiarese.persons.application.CreatePersonUseCase;
import br.com.guiarese.persons.gateway.CepInfoGateway;
import br.com.guiarese.persons.gateway.PersonRepositoryGateway;
import br.com.guiarese.persons.infrastructure.controller.mapper.PersonDtoMapper;
import br.com.guiarese.persons.infrastructure.integration.cep.CepInfoGatewayImpl;
import br.com.guiarese.persons.infrastructure.integration.cep.mapper.CepInfoMapper;
import br.com.guiarese.persons.infrastructure.persistence.PersonRepositoryGatewayImpl;
import br.com.guiarese.persons.infrastructure.persistence.mapper.PersonEntityMapper;
import br.com.guiarese.persons.infrastructure.persistence.repository.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {

    @Bean
    public CreatePersonUseCase createPersonUseCase(PersonRepositoryGatewayImpl usuarioGateway, CepInfoGateway cepInfoGateway) {
        return new CreatePersonUseCase(usuarioGateway, cepInfoGateway);
    }

    @Bean
    public PersonRepositoryGateway personRepositoryGateway(PersonRepository repository, PersonEntityMapper mapper) {
        return new PersonRepositoryGatewayImpl(repository, mapper);
    }

    @Bean
    public CepInfoGateway cepInfoGateway(RestClient restClient, CepInfoMapper mapper) {
        return new CepInfoGatewayImpl(restClient, mapper);
    }

    @Bean
    public RestClient restClient() {
        return RestClient.create();
    }

    @Bean
    public PersonEntityMapper personEntityMapper() {
        return new PersonEntityMapper();
    }

    @Bean
    public PersonDtoMapper personDtoMapper() {
        return new PersonDtoMapper();
    }

    @Bean
    public CepInfoMapper cepInfoMapper() {
        return new CepInfoMapper();
    }

}
