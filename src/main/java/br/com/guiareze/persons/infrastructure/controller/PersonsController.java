package br.com.guiareze.persons.infrastructure.controller;

import br.com.guiareze.persons.application.CreatePersonUseCase;
import br.com.guiareze.persons.infrastructure.controller.dto.CreatePersonRequest;
import br.com.guiareze.persons.infrastructure.controller.dto.PersonResponse;
import br.com.guiareze.persons.infrastructure.controller.mapper.PersonDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/persons")
@RequiredArgsConstructor
public class PersonsController {

    private final PersonDtoMapper mapper;
    private final CreatePersonUseCase createPersonUseCase;

    @PostMapping
    public ResponseEntity<PersonResponse> create(@RequestBody CreatePersonRequest request) {
        log.info("POST /persons - Creating person with data: {}", request);
        var responseUseCase = createPersonUseCase.createPerson(mapper.toDomain(request));
        log.info("Person created successfully: {}", responseUseCase);
        return ResponseEntity.ok(mapper.toResponseDto(responseUseCase));
    }

}
