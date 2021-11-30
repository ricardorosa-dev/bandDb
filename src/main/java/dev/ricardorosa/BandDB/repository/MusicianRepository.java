package dev.ricardorosa.BandDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.ricardorosa.BandDB.entity.Musician;

@Repository
public interface MusicianRepository extends JpaRepository<Musician, Long>{
	
	Musician findByName(String name);

}
