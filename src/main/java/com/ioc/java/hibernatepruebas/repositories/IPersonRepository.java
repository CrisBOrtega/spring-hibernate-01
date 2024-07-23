package com.ioc.java.hibernatepruebas.repositories;

import com.ioc.java.hibernatepruebas.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IPersonRepository extends CrudRepository<Person, Long> {

    //el repo trae metodos predefinidos
    //pero se pueden trabajar metodos definidos
    //Convencion por sobre odigo:
    //comienzan con findBy
    List<Person> findByProgrammingLanguage(String programmingLanguage);
    List<Person> findByProgrammingLanguageAndAndName(String programmingLanguage, String name);

    @Query("select p from Person p where  p.programmingLanguage=?1 and p.name=?2")
    List<Person> buscarPorNombreYLenguaje(String programmingLanguage , String name);

    @Query("select p.name , p.programmingLanguage from Person  p")
    List<Object[]> obtenerPersonData();

    @Query("select p.name , p.programmingLanguage from Person  p where p.programmingLanguage = ?1 and p.name = ?2  ")
    List<Object[]>  obtenerPersonData(String programmingLanguage , String name );

    //Metodos de objecto
    @Query("select p from Person p where p.id=?1")
    Optional<Person> buscarPorId(Long id);

    @Query("select p from Person p where p.name like ?1%")
    Optional<Person> buscarPorLikeName(String name);

    //el metodo anterior pero declarativa con nomenclatura de nombres
    Optional<Person> findByNameContaining(String name);
}


