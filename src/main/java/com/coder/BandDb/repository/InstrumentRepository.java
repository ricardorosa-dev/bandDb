package com.coder.BandDb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coder.BandDb.entities.Instrument;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Long>{

}
