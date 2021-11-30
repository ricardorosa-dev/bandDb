package dev.ricardorosa.BandDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.ricardorosa.BandDB.entity.BandMusician;
import dev.ricardorosa.BandDB.entity.BandMusiciansId;

@Repository
public interface BandMusicianRepository extends JpaRepository<BandMusician, BandMusiciansId>{

}
