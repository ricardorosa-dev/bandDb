package com.coder.BandDb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coder.BandDb.entities.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>{

}
