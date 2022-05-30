package ch.zhaw.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Gruppe;
import ch.zhaw.springboot.entities.Person;
import ch.zhaw.springboot.repositories.GruppeRepository;

@RestController
public class GruppeRestController {
	
	@Autowired
	private GruppeRepository repository;
	
	

	@RequestMapping(value = "kaiku/groups", method = RequestMethod.GET)
	public ResponseEntity<List<Gruppe>> getGroups() {
		List<Gruppe> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Gruppe>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Gruppe>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "kaiku/groups", method = RequestMethod.POST)
	Gruppe newGruppe(@RequestBody Gruppe newGruppe) {
		return repository.save(newGruppe);
	}
	
	@RequestMapping(value = "kaiku/groups/{id}", method = RequestMethod.DELETE)
	void deleteGruppe(@PathVariable Long id) {
	    repository.deleteById(id);
	  }
	
	@RequestMapping(value = "kaiku/groups/{id}", method = RequestMethod.PUT)
	Gruppe replaceGruppe(@RequestBody Gruppe newGruppe, @PathVariable Long id) {
	    
	    return repository.findById(id)
	      .map(gruppe -> {
	    	gruppe.setAnzahl_personen(newGruppe.getAnzahl_personen());
	    	gruppe.setGruppe_name(newGruppe.getGruppe_name());
	    	gruppe.setTeilnehmer(newGruppe.getTeilnehmer());
	        return repository.save(gruppe);
	      })
	      .orElseGet(() -> {
	    	  newGruppe.setId(id);
	        return repository.save(newGruppe);
	      });
	  }

}
