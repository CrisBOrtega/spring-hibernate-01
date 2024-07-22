package com.ioc.java.hibernatepruebas;

import com.ioc.java.hibernatepruebas.entities.Person;
import com.ioc.java.hibernatepruebas.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HibernatePruebasApplication implements CommandLineRunner {

    @Autowired
    private IPersonRepository repository;

    public static void main(String[] args) {

        SpringApplication.run(HibernatePruebasApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        List<Person> persons = (List<Person>) repository.findAll();
        persons.stream().forEach(System.out::println);

    }
}
