package ch.zhaw.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.zhaw.springboot.entities.Gruppe;

public interface GruppeRepository extends JpaRepository<Gruppe, Long>{

	@Query(value="SELECT *"
			+ " FROM Gruppe"
			+ " JOIN Person ON Person.id=Gruppe.id;",nativeQuery = true)
	public List<Gruppe> getGroupsWithpersons();
}
