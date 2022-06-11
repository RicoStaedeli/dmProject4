package ch.zhaw.springboot.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Gruppe;
import ch.zhaw.springboot.entities.Zutat;
import ch.zhaw.springboot.repositories.ZutatRepository;

@RestController
public class ZutatRestController {

	@Autowired
	private ZutatRepository repo;
	
	@RequestMapping(value = "kaiku/zutaten", method = RequestMethod.GET)
	public ResponseEntity<List<Zutat>> getZutaten() {
		List<Zutat> result = this.repo.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "kaiku/zutaten/{id}", method = RequestMethod.GET)
	public ResponseEntity<Zutat> getZutatById(@PathVariable("id") long id) {
		Optional<Zutat> result = this.repo.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity<Zutat>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Zutat>(HttpStatus.NOT_FOUND);
		}
	}
	

}
