package ch.zhaw.springboot.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.repositories.ZutatRepository;

@RestController
public class ZutatRestController {

	@Autowired
	private ZutatRepository repo;
}
