package com.project.services;

import com.project.db.PersonRepository;
import com.project.models.Person;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.util.List;

public class PersonService extends Service<List<Person>> {
    PersonRepository personRepository = new PersonRepository();

    @Override
    protected Task<List<Person>> createTask() {

        Task mytask = new Task<List<Person>>() {

            @Override
            protected List<Person> call() throws Exception {
                Thread.sleep(5000);
                return personRepository.findAllPerson();
            }
        };

        return mytask;

       /* return new Task<List<Person>>() {
            @Override
            protected List<Person> call() throws Exception {
                //DO YOU HARD STUFF HERE
                List<Person> personList = personRepository.findAllPerson();
                //Thread.sleep(5000);
                return personList;
            }
        };*/
    }
}
