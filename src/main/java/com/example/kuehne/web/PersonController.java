package com.example.kuehne.web;

import com.example.kuehne.dto.PersonDTO;
import com.example.kuehne.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("")
    public ResponseEntity<List<PersonDTO>> getAllPeople() {
        List<PersonDTO> availablePeople = personService.getAllPeople();
        return new ResponseEntity<>(availablePeople, HttpStatus.OK);
    }

    @GetMapping("/{partOfName}")
    public ResponseEntity<List<PersonDTO>> getPersonByName(@PathVariable(value = "partOfName") String partOfName) {
        List<PersonDTO> availablePeople = personService.getPersonByName(partOfName);
        return new ResponseEntity<>(availablePeople, HttpStatus.OK);
    }

}
