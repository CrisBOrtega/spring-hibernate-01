package com.ioc.java.hibernatepruebas.repositories;

import com.ioc.java.hibernatepruebas.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IPersonRepository extends CrudRepository<Person, Long> {


}
