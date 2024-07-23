package com.ioc.java.hibernatepruebas.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "programming_language")
    private String programmingLanguage;



}
