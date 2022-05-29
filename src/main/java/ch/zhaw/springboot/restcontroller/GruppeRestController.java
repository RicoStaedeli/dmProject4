package ch.zhaw.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Gruppe;
import ch.zhaw.springboot.repositories.GruppeRepository;

@RestController
public class GruppeRestController {
	
	@Autowired
	private GruppeRepository repo;
	
	

	@RequestMapping(value = "kaiku/groups", method = RequestMethod.GET)
	public ResponseEntity<List<Gruppe>> getGroups() {
		List<Gruppe> result = this.repo.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Gruppe>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Gruppe>>(HttpStatus.NOT_FOUND);
		}
	}

}
