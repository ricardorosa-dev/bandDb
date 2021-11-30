package dev.ricardorosa.BandDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.ricardorosa.BandDB.entity.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>{
	
	Album findByName(String name);

}
