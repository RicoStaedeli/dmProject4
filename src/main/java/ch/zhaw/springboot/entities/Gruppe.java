package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gruppe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String gruppe_name;
	private int anzahl_personen;

	public Gruppe(String gruppe_name, int anzahl_personen) {
		this.gruppe_name = gruppe_name;
		this.anzahl_personen = anzahl_personen;
	}

	public String getGruppe_name() {
		return gruppe_name;
	}

	public void setGruppe_name(String gruppe_name) {
		this.gruppe_name = gruppe_name;
	}

	public int getAnzahl_personen() {
		return anzahl_personen;
	}

	public void setAnzahl_personen(int anzahl_personen) {
		this.anzahl_personen = anzahl_personen;
	}

}
