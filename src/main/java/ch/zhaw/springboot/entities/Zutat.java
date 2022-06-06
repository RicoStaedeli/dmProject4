package ch.zhaw.springboot.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Zutat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private int kcal;
	
    @ManyToMany(mappedBy = "zutaten_in_Menu")
    Set<Menu> menu;

	public Zutat(String name, int kcal) {

		this.name = name;
		this.kcal = kcal;
	}
	
	public Zutat() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

}
