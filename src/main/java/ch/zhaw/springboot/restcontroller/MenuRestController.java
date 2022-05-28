package ch.zhaw.springboot.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.repositories.MenuRepository;

@RestController
public class MenuRestController {

	@Autowired
	private MenuRepository repo;
}
