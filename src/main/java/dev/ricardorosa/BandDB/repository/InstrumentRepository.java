package dev.ricardorosa.BandDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.ricardorosa.BandDB.entity.Instrument;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Long>{
	
	Instrument findByName(String name);

}
