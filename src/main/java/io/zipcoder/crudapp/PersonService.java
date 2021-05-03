package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class PersonService {

    PersonRepository personRepo;
    @Autowired
    public PersonService(PersonRepository personRepo){this.personRepo = personRepo;}

    public Person getPerson(@PathVariable int id){
        return personRepo.findOne(id);
    }

    public Iterable<Person> getPersonList(){
        return personRepo.findAll();
    }

    public Person createPerson( Person person){
        return personRepo.save(person);
    }

    public Person updatePerson(Person person, int id){
        Person updatePerson = personRepo.findOne(id);
        updatePerson.setId(person.getId());
        updatePerson.setFirstName(person.getFirstName());
        updatePerson.setLastName(person.getLastName());
        return personRepo.save(updatePerson);
    }

    public void deletePerson(int id){
        personRepo.delete(id);
    }

}
