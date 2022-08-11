package com.example.kuehne.service;

import com.example.kuehne.dto.PersonDTO;
import com.example.kuehne.entity.Person;
import com.example.kuehne.mapper.PersonToPersonDTO;
import com.example.kuehne.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonToPersonDTO mapper;


    public List<PersonDTO> getAllPeople() {
        List<Person> availablePeople = new ArrayList<>();
        availablePeople = personRepository.findAll();

        List<PersonDTO> personDTOList = new ArrayList<>();
        personDTOList = mapper.mapAll(availablePeople);

        return personDTOList;

    }

    public List<PersonDTO> getPersonByName(String partOfName) {
        List<Person> availablePeople = new ArrayList<>();
        availablePeople = personRepository.findAllByNameContainingOrderByNameAsc(partOfName);

        List<PersonDTO> personDTOList = new ArrayList<>();
        personDTOList = mapper.mapAll(availablePeople);

        return personDTOList;

    }
}
