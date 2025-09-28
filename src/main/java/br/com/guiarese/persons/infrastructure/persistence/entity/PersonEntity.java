package br.com.guiarese.persons.infrastructure.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record PersonEntity(
    @Id
    String id,
    String name,
    int age,
    String cep,
    String street,
    String city,
    String state) {
}
