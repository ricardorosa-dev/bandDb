package com.coder.BandDb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coder.BandDb.entities.Website;

@Repository
public interface WebsiteRepository extends JpaRepository<Website, Long>{

}
