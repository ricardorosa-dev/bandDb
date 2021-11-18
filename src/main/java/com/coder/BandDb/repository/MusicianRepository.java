package com.coder.BandDb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coder.BandDb.entities.Musician;

@Repository
public interface MusicianRepository extends JpaRepository<Musician, Long>{

}
