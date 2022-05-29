package ch.zhaw.springboot.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String standort;
	private int bewertung;
	
	@OneToMany
	private List<Reservation> reservationen;


	public Restaurant(String name, String standort, int bewertung) {
		this.name = name;
		this.standort = standort;
		this.bewertung = bewertung;
	}
	
	public Restaurant() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getStandort() {
		return standort;
	}

	public void setStandort(String standort) {
		this.standort = standort;
	}
	

	public List<Reservation> getReservationen() {
		return reservationen;
	}

	public void setReservationen(List<Reservation> reservationen) {
		this.reservationen = reservationen;
	}

	public int getBewertung() {
		return bewertung;
	}

	public void setBewertung(int bewertung) {
		this.bewertung = bewertung;
	}

}
