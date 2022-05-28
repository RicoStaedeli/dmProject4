package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
