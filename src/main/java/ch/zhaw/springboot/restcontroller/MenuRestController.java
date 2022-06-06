package ch.zhaw.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Menu;
import ch.zhaw.springboot.repositories.MenuRepository;

@RestController
public class MenuRestController {

	@Autowired
	private MenuRepository repository;
	
	@RequestMapping(value = "kaiku/menus", method = RequestMethod.GET)
	public ResponseEntity<List<Menu>> getPersons() {
		List<Menu> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Menu>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Menu>>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
}
