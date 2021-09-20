package com.coder.BandDb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coder.BandDb.entities.BandMusician;
import com.coder.BandDb.entities.BandMusiciansId;

@Repository
public interface BandMusicianRepository extends JpaRepository<BandMusician, BandMusiciansId>{

}
