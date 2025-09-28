package br.com.guiarese.persons.infrastructure.controllers;

import br.com.guiarese.persons.infrastructure.controllers.dto.GetPersonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonsControllers {

    private static final Logger log = LoggerFactory.getLogger(PersonsControllers.class);

    @GetMapping("/persons")
    public List<GetPersonResponse> findAll() throws InterruptedException {
        log.info(Thread.currentThread().toString());
        Thread.sleep(5000); // Simula uma demora de 5 segundos
        return List.of(GetPersonResponse.builder()
                        .name("Guilherme Rezende")
                        .age(30)
                        .cep("04931010")
                        .street("Rua João da Silva")
                        .city("São Paulo")
                        .state("SP")
                .build());
    }

}
