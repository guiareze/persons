package br.com.guiarese.persons.domain;

public record Person (
        String id,
        String name,
        int age,
        String cep,
        String street,
        String city,
        String state) {

    public Person(String name, int age, String cep) {
        this(null, name, age, cep, null, null, null);
    }
}
