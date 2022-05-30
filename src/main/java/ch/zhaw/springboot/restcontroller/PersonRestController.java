package ch.zhaw.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Person;
import ch.zhaw.springboot.repositories.PersonRepository;

@RestController
public class PersonRestController {
	@Autowired
	private PersonRepository repository;

	@RequestMapping(value = "kaiku/persons", method = RequestMethod.GET)
	public ResponseEntity<List<Person>> getPersons() {
		List<Person> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Person>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Person>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "kaiku/persons/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<Person>> getPersonsByBirthdate(@PathVariable("name") String name) {
		List<Person> result = this.repository.findPersonsByName(name);

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Person>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Person>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "kaiku/persons", method = RequestMethod.POST)
	Person newPerson(@RequestBody Person newPerson) {
		return repository.save(newPerson);
	}
	
	@RequestMapping(value = "kaiku/persons/{id}", method = RequestMethod.DELETE)
	void deletePerson(@PathVariable Long id) {
	    repository.deleteById(id);
	  }
	
	@RequestMapping(value = "kaiku/persons/{id}", method = RequestMethod.PUT)
	Person replacePerson(@RequestBody Person newPerson, @PathVariable Long id) {
	    
	    return repository.findById(id)
	      .map(person -> {
	        person.setName(newPerson.getName());
	        person.setMail(newPerson.getMail());
	        person.setBirthdate(newPerson.getBirthdate());
	        return repository.save(person);
	      })
	      .orElseGet(() -> {
	    	  newPerson.setId(id);
	        return repository.save(newPerson);
	      });
	  }
	

}
