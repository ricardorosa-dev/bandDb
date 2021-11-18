package com.coder.BandDb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coder.BandDb.entities.Band;

@Repository
public interface BandRepository extends JpaRepository<Band, Long>{

}
