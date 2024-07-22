package com.ioc.java.hibernatepruebas.repositories;

import com.ioc.java.hibernatepruebas.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPersonRepository extends CrudRepository<Person, Long> {

    //el repo trae metodos predefinidos
    //pero se pueden trabajar metodos definidos
    //Convencion por sobre odigo:
    //comienzan con findBy
    List<Person> findByProgrammingLanguage(String programmingLanguage);
    List<Person> findByProgrammingLanguageAndAndName(String programmingLanguage, String name);

    @Query("select p from Person p where  p.programmingLanguage=?1 and p.name=?2")
    List<Person> buscarPorNombreYLenguaje(String programmingLanguage , String name);
}


