package ch.zhaw.springboot.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.repositories.RestaurantRepository;

@RestController
public class RestaurantRestController {
	@Autowired
	private RestaurantRepository repo;
	
}
