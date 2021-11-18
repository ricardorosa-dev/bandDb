package com.coder.BandDb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.BandDb.entities.Album;
import com.coder.BandDb.repository.AlbumRepository;

@Service
public class AlbumService {
	
	private AlbumRepository repository;
	
	@Autowired
	public AlbumService(AlbumRepository repository) {
		this.repository = repository;
	}
	
	public List<Album> findAll() {
		return repository.findAll();
	}
	
	public Album findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException());
	}
	
	public Album save(Album album) {
		if (album.getName() == null || album.getReleased() == 0) {
			throw new RuntimeException();
		}
		return repository.save(album);
	}
	
	public Album update(Long id, Album updateAlbum) {
		if (updateAlbum.getName() == null || updateAlbum.getReleased() == 0) {
			throw new RuntimeException();
		}
		
		Optional<Album> album = repository.findById(id);
		
		if (album.isPresent()) {
			album.get().setName(updateAlbum.getName());
			album.get().setReleased(updateAlbum.getReleased());
			
			repository.save(album.get());
			
			return album.get();
		}
		
		throw new RuntimeException();
	}
	
	public void delete(Long id) {
		Album album = repository.findById(id)
				.orElseThrow(() -> new RuntimeException());
		
		repository.delete(album);
	}

}
