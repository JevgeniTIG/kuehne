package com.example.kuehne.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "person")
@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String urlToPhoto;

}
