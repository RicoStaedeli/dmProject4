package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Gruppe;

public interface GruppeRepository extends JpaRepository<Gruppe, Long>{

}
