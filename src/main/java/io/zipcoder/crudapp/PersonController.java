package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people/")
public class PersonController {

    PersonService personService;

    @Autowired
    public  PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person p){
        return new ResponseEntity<>(personService.createPerson(p), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> getPerson(@PathVariable int id){
        return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getPersonList(){
        return new ResponseEntity<>((List<Person>) personService.getPersonList(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable int id){
        return new ResponseEntity<>(personService.updatePerson(person, id), HttpStatus.OK);
    }

    @DeleteMapping
    public void deletePerson(@PathVariable int id){
        return new ResponseEntity<>(personService.deletePerson(id), HttpStatus.OK;);

    }

}
