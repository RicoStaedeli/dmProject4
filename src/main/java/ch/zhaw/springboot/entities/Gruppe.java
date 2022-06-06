package ch.zhaw.springboot.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Gruppe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String gruppe_name;
	private int anzahl_personen;
	
	@OneToMany(mappedBy = "gruppe")
	private List<Person> teilnehmer;
	

	public Gruppe(String gruppe_name, int anzahl_personen) {
		this.gruppe_name = gruppe_name;
		this.anzahl_personen = anzahl_personen;
	}
	
	public Gruppe() {
		
	}

	public String getGruppe_name() {
		return gruppe_name;
	}

	public void setGruppe_name(String gruppe_name) {
		this.gruppe_name = gruppe_name;
	}

	public List<Person> getTeilnehmer() {
		return teilnehmer;
	}

	public void setTeilnehmer(List<Person> teilnehmer) {
		this.teilnehmer = teilnehmer;
	}

	public int getAnzahl_personen() {
		return anzahl_personen;
	}

	public void setAnzahl_personen(int anzahl_personen) {
		this.anzahl_personen = anzahl_personen;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
