package com.ioc.java.hibernatepruebas;

import com.ioc.java.hibernatepruebas.entities.Person;
import com.ioc.java.hibernatepruebas.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class HibernatePruebasApplication implements CommandLineRunner {

    @Autowired
    private IPersonRepository repository;

    public static void main(String[] args) {

        SpringApplication.run(HibernatePruebasApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        create();
    }

    public void create(){
        Person person = Person.builder().name("John").lastName("Bonatchon").id(null).build();
        //objecto creado
        Person personNew = repository.save(person);
        System.out.println(personNew);

    }

    public void findOne(){
        //Primera manera
        //Person person = repository.findById(1L).orElseThrow();
        //System.out.println(person);

        //Segunda manera
        /*Person person = null;
        Optional<Person> personOptional = repository.findById(1L);
        if(personOptional.isPresent()){
            person = personOptional.get();
        }
        System.out.println(person);*/

        //JPA query methods: https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
        //repository.buscarPorId(2L).ifPresent(System.out::println);
        //repository.buscarPorLikeName("An").ifPresent(System.out::println);
        repository.findByNameContaining("An").ifPresent(System.out::println);

    }

    public void list(){
        //List<Person> persons = (List<Person>) repository.findByProgrammingLanguage("Java");
        //persons.stream().forEach(System.out::println);

        //List<Person> persons = repository.buscarPorNombreYLenguaje("Java" , "Andres");
        //persons.stream().forEach(System.out::println);

        //List<Person> persons = (List<Person>) repository.findByProgrammingLanguage("Java");
        //persons.stream().forEach(System.out::println);

        //List<Object[]> personsValue = (List<Object[]>) repository.obtenerPersonData();
        List<Object[]> personsValue = (List<Object[]>) repository.obtenerPersonData("Java" , "Andres");
        personsValue.stream().forEach(
                pV -> {
                    System.out.println(pV[0] + " es experto en " + pV[1]);
                }
        );
    }
}
