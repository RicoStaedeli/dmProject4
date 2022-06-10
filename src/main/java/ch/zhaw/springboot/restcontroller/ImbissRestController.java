package ch.zhaw.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import ch.zhaw.springboot.entities.Imbiss;
import ch.zhaw.springboot.repositories.ImbissRepository;

@RestController
public class ImbissRestController {

	@Autowired
	private ImbissRepository repository;
	
	
	@RequestMapping(value = "kaiku/imbiss", method = RequestMethod.GET)
	public ResponseEntity<List<Imbiss>> getGroups() {
		List<Imbiss> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Imbiss>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Imbiss>>(HttpStatus.NOT_FOUND);
		}
	}
	
}
