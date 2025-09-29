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
    private String advice;

    public Person(String name, int age, String cep) {
        this.name = name;
        this.age = age;
        this.cep = cep;
    }

    public Person(String id, String name, int age, String cep) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cep = cep;
    }

    public void enrichAddress(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", cep='" + cep + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
