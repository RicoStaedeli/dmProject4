package ch.zhaw.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Restaurant;
import ch.zhaw.springboot.repositories.RestaurantRepository;

@RestController
public class RestaurantRestController {
	@Autowired
	private RestaurantRepository repo;
	
	@RequestMapping(value = "kaiku/restaurants", method = RequestMethod.GET)
	public ResponseEntity<List<Restaurant>> getRestaurants() {
		List<Restaurant> result = this.repo.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Restaurant>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Restaurant>>(HttpStatus.NOT_FOUND);
		}
	}
}
