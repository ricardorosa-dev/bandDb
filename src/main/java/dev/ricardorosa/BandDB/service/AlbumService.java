package dev.ricardorosa.BandDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ricardorosa.BandDB.entity.Album;
import dev.ricardorosa.BandDB.repository.AlbumRepository;

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
		return repository.findById(id)
				.orElseThrow(RuntimeException::new);
	}
	
	public Album save(Album newAlbum) {
		return repository.save(newAlbum);
	}
	
	public Album update(Long id, Album updateAlbum) {
		Album foundAlbum = repository.findById(id)
				.orElseThrow(RuntimeException::new);
		foundAlbum.setName(updateAlbum.getName());
		foundAlbum.setReleased(updateAlbum.getReleased());
		
		return repository.save(foundAlbum);
	}
	
	public void delete(Long id) {
		Album foundAlbum = repository.findById(id)
				.orElseThrow(RuntimeException::new);
		
		repository.delete(foundAlbum);
	}

}
