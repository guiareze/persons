package br.com.guiareze.persons.infrastructure.controller.dto;

public record CreatePersonRequest(
        String name,
        int age,
        String cep
) {
}
