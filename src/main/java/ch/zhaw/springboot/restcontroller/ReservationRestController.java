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

import ch.zhaw.springboot.entities.Reservation;
import ch.zhaw.springboot.repositories.ReservationRepository;

@RestController
public class ReservationRestController {
	
	@Autowired
	private ReservationRepository repo;
	
	@RequestMapping(value = "kaiku/reservation", method = RequestMethod.GET)
	public ResponseEntity<List<Reservation>> getReservationen() {
		List<Reservation> result = this.repo.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Reservation>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Reservation>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "kaiku/reservation/{id}", method = RequestMethod.GET)
	public ResponseEntity<Reservation> getReservationById(@PathVariable("id") long id) {
		Optional<Reservation> result = this.repo.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity<Reservation>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
		}
	}

}