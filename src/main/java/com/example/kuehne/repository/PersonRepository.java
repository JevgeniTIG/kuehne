package com.example.kuehne.repository;

import com.example.kuehne.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAllByNameContainingOrderByNameAsc(String partOfName);
}
