package ch.zhaw.springboot.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private double preis;
	
    @ManyToMany
    @JoinTable(
    	name = "zutaten_in_Menu", 
    	joinColumns = @JoinColumn(name = "menu_id"), 
    	inverseJoinColumns = @JoinColumn(name = "zutat_id"))
    Set<Zutat> zutaten_in_Menu;
    
    @ManyToMany
    @JoinTable(
    	name = "menu_in_restaurant", 
    	joinColumns = @JoinColumn(name = "menu_id"), 
    	inverseJoinColumns = @JoinColumn(name = "restaurant_id"))
    Set<Restaurant> menu_in_restaurant;

	public Menu(String name, double preis) {
		this.name = name;
		this.preis = preis;
	}
	
	public Menu() {
		
	}

	public Set<Zutat> getZutaten_in_Menu() {
		return zutaten_in_Menu;
	}

	public void setZutaten_in_Menu(Set<Zutat> zutaten_in_Menu) {
		this.zutaten_in_Menu = zutaten_in_Menu;
	}

	public Set<Restaurant> getMenu_in_restaurant() {
		return menu_in_restaurant;
	}

	public void setMenu_in_restaurant(Set<Restaurant> menu_in_restaurant) {
		this.menu_in_restaurant = menu_in_restaurant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

}
