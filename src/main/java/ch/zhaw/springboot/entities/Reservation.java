package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	private Gruppe gruppe;
	
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	private Restaurant restaurant;

	private String reservationsdatum;

	public Reservation(String reservationsdatum) {
		this.reservationsdatum = reservationsdatum;
	}
	
	public Reservation() {
		
	}

	public Gruppe getGruppe() {
		return gruppe;
	}

	public void setGruppe(Gruppe gruppe) {
		this.gruppe = gruppe;
	}

	public String getReservationsdatum() {
		return reservationsdatum;
	}

	public void setReservationsdatum(String reservationsdatum) {
		this.reservationsdatum = reservationsdatum;
	}

}
