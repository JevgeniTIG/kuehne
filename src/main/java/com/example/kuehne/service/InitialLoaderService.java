package com.example.kuehne.service;

import com.example.kuehne.entity.Person;
import com.example.kuehne.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class InitialLoaderService {

    public static final Logger LOG = LoggerFactory.getLogger(InitialLoaderService.class);

    @Value("${file.location}")
    private String fileLocation;

    @Autowired
    private PersonRepository personRepository;


    public void loadData() {

        List<Person> listOfPeople = new ArrayList<>();

        int counter = 0;

        try {
            File myObj = new File(fileLocation);
            Scanner fileScanner = new Scanner(myObj);
            while (fileScanner.hasNext()) {

                counter++;

                String[] personDataAsArrayOfStrings = fileScanner.nextLine().split(",");

                Person person = new Person();

                if (counter > 1) {

                    if (personDataAsArrayOfStrings.length == 2) {
                        person.setName(personDataAsArrayOfStrings[0]);
                        person.setUrlToPhoto(personDataAsArrayOfStrings[1].substring(1));
                    } else if (personDataAsArrayOfStrings.length == 3) {
                        person.setName(personDataAsArrayOfStrings[0] + personDataAsArrayOfStrings[1]);
                        person.setUrlToPhoto(personDataAsArrayOfStrings[2].substring(1));
                    }

                    listOfPeople.add(person);
                }
            }

            personRepository.saveAllAndFlush(listOfPeople);
            LOG.info("****** People.csv successfully loaded to database. Total number of profiles loaded: {} ******", counter - 1);
            fileScanner.close();
        } catch (FileNotFoundException e) {
            LOG.info("An error occurred.");
            e.printStackTrace();
        }
    }

}
