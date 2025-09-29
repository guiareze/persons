package br.com.guiareze.persons.infrastructure.controller;

import br.com.guiareze.persons.application.*;
import br.com.guiareze.persons.domain.Person;
import br.com.guiareze.persons.infrastructure.controller.dto.PersonRequest;
import br.com.guiareze.persons.infrastructure.controller.dto.PersonResponse;
import br.com.guiareze.persons.infrastructure.controller.mapper.PersonDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/persons")
@RequiredArgsConstructor
public class PersonsController {

    private final PersonDtoMapper mapper;
    private final CreatePersonUseCase createPersonUseCase;
    private final GetAllPersonsUseCase getAllPersonsUseCase;
    private final GetPersonByIdUseCase getPersonByIdUseCase;
    private final UpdatePersonUseCase updatePersonUseCase;
    private final DeletePersonById deletePersonById;

    @PostMapping
    public ResponseEntity<PersonResponse> create(@RequestBody PersonRequest request) {
        log.info("POST /persons - Creating person with data: {}", request);
        Person responseUseCase = createPersonUseCase.createPerson(mapper.toDomain(request));
        PersonResponse responseDto = mapper.toResponseDto(responseUseCase);
        log.info("POST /persons - Person created successfully: {}", responseUseCase);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<Page<PersonResponse>> getAll(Pageable pageable) {
        log.info("GET /persons - Retrieving all persons with pagination: {}", pageable);
        Page<Person> personPage = getAllPersonsUseCase.getAllPersons(pageable);
        Page<PersonResponse> responseDto = personPage.map(mapper::toResponseDto);
        log.info("GET /persons - Retrieved {} persons", responseDto.getTotalElements());
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> getById(@PathVariable String id) {
        log.info("GET /persons/{} - Retrieving person by ID", id);
        Person person = getPersonByIdUseCase.getPersonById(id);
        PersonResponse responseDto = mapper.toResponseDto(person);
        log.info("GET /persons/{} - Person retrieved successfully: {}", id, responseDto);
        return ResponseEntity.ok(responseDto);
    }

    @PatchMapping("{id}")
    public ResponseEntity<PersonResponse> updateById(@PathVariable String id, @RequestBody PersonRequest request) {
        log.info("PATCH /persons/{} - Updating person with data: {}", id, request);
        Person personToUpdate = mapper.toDomain(request, id);
        Person updatedPerson = updatePersonUseCase.updatePerson(personToUpdate);
        PersonResponse responseDto = mapper.toResponseDto(updatedPerson);
        log.info("PATCH /persons/{} - Person updated successfully: {}", id, responseDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        log.info("DELETE /persons/{} - Deleting person by ID", id);
        deletePersonById.deletePersonById(id);
        log.info("DELETE /persons/{} - Person deleted successfully", id);
        return ResponseEntity.noContent().build();
    }

}
