package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	private Gruppe gruppe;

	private long reservationsdatum;

	public Reservation(long reservationsdatum) {
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

	public long getReservationsdatum() {
		return reservationsdatum;
	}

	public void setReservationsdatum(long reservationsdatum) {
		this.reservationsdatum = reservationsdatum;
	}

}
