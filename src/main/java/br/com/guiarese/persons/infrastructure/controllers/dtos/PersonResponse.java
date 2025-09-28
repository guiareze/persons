package br.com.guiarese.persons.infrastructure.controllers.dtos;

import lombok.Builder;

@Builder
public record PersonResponse(
        String id,
        String name,
        int age,
        String cep,
        String street,
        String city,
        String state) {
}
