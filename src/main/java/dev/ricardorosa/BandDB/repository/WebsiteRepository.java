package dev.ricardorosa.BandDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.ricardorosa.BandDB.entity.Website;

@Repository
public interface WebsiteRepository extends JpaRepository<Website, Long>{
	
	Website findByUrl(String url);
	
	

}
