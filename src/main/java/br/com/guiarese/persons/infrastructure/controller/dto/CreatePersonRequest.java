package br.com.guiarese.persons.infrastructure.controller.dto;

public record CreatePersonRequest(
        String name,
        int age,
        String cep
) {
}
