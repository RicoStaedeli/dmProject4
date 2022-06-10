package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Imbiss;

public interface ImbissRepository extends JpaRepository<Imbiss, Long>{

}
