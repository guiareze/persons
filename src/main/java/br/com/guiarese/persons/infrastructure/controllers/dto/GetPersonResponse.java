package br.com.guiarese.persons.infrastructure.controllers.dto;

import lombok.Builder;

@Builder
public record GetPersonResponse (String name, int age, String cep, String street, String city, String state) {
}
