package br.com.guiareze.persons.infrastructure.controller.dto;

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
