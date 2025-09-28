package br.com.guiarese.persons.infrastructure.controllers.rest;

import br.com.guiarese.persons.application.CreatePersonUseCase;
import br.com.guiarese.persons.infrastructure.controllers.dtos.CreatePersonRequest;
import br.com.guiarese.persons.infrastructure.controllers.dtos.PersonResponse;
import br.com.guiarese.persons.infrastructure.controllers.mappers.PersonDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonsControllers {

    private final PersonDtoMapper mapper;
    private final CreatePersonUseCase createPersonUseCase;

    @PostMapping
    public ResponseEntity<PersonResponse> create(@RequestBody CreatePersonRequest request) {
        log.info("POST /persons - Creating person with data: {}", request);
        var responseUseCase = createPersonUseCase.createPerson(mapper.toDomain(request));
        return ResponseEntity.ok(mapper.toResponseDto(responseUseCase));
    }

}
