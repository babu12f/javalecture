package com.jdbcclass;

import java.util.List;

public class Class19 {
    public static void main(String[] args) {
        PersonRepository personRepository = new PersonRepository();

        //Person person = new Person("jahid", 23, "dhaka", "jaid@gmail.com");
        //Person person2 = new Person("jahid_2", 45, "dhaka", "jaid@gmail.com");

        //personRepository.save(person);
        //personRepository.save(person2);

        /*Update information*/

        /*Person personAli = personRepository.findById(1);
        System.out.println(personAli);
        System.out.println();

        personAli.setEmail("mohammedAli@gmail.com");
        personAli.setAddress("Sylhet");

        personRepository.update(personAli);

        personAli = personRepository.findById(1);
        System.out.println(personAli);*/

        /*show all information*/
        List<Person> allPerson = personRepository.findAllPerson();
        allPerson.forEach((p) -> System.out.println(p));
        System.out.println();

        personRepository.deleteById(8);

        allPerson = personRepository.findAllPerson();
        allPerson.forEach((p) -> System.out.println(p));
    }
}
