package ch.zhaw.springboot.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.repositories.ReservationRepository;

@RestController
public class ReservationRestController {
	
	@Autowired
	private ReservationRepository repo;

}
