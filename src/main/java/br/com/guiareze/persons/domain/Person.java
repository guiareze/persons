package br.com.guiareze.persons.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class Person{

    private String id;
    private String name;
    private int age;
    private String cep;
    private String street;
    private String city;
    private String state;

    public Person(String name, int age, String cep) {
        this.name = name;
        this.age = age;
        this.cep = cep;
    }

    public void enrichAddress(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }
}
