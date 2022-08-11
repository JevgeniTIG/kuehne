package com.example.kuehne.mapper;

import com.example.kuehne.dto.PersonDTO;
import com.example.kuehne.entity.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonToPersonDTO {

    public PersonDTO map(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setName(person.getName());
        personDTO.setUrlToPhoto(person.getUrlToPhoto());
        return personDTO;
    }

    public List<PersonDTO> mapAll(List<Person> availablePeople) {
        List<PersonDTO> personDTOList = new ArrayList<>();

        availablePeople.forEach(availablePerson -> {
            PersonDTO personDTO = new PersonDTO();
            personDTO = map(availablePerson);
            personDTOList.add(personDTO);
        });
        return personDTOList;
    }

}
