package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
