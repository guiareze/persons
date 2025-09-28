package br.com.guiarese.persons.infrastructure.controllers.dtos;

public record CreatePersonRequest(
        String name,
        int age,
        String cep
) {
}
