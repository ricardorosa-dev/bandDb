package dev.ricardorosa.BandDB.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.ricardorosa.BandDB.entity.Band;

@Repository
public interface BandRepository extends JpaRepository<Band, Long>{
	
	Band findByName(String name);

}
