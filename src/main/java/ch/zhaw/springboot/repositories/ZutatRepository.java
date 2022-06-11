package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Zutat;

public interface ZutatRepository extends JpaRepository<Zutat, Long> {

}
