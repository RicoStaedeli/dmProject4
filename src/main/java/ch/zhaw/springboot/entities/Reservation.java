package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private long reservationsdatum;

	public Reservation(long reservationsdatum) {
		this.reservationsdatum = reservationsdatum;
	}

	public long getReservationsdatum() {
		return reservationsdatum;
	}

	public void setReservationsdatum(long reservationsdatum) {
		this.reservationsdatum = reservationsdatum;
	}

}
