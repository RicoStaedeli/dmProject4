package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	
	private String mail;
	private long birthdate;

	public Person(String name, String mail, long birthdate) {
		this.name = name;
		this.mail = mail;
		this.birthdate = birthdate;
	}

	public Person() {

	}

	public String getMail() {
		return mail;
	}

	public String getName() {
		return this.name;
	}

	public long getBirthdate() {
		return this.birthdate;
	}
}
