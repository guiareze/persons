package br.com.guiareze.persons.infrastructure.controller.dto;

public record PersonRequest(
        String name,
        int age,
        String cep
) {
}
