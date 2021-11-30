package dev.ricardorosa.BandDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ricardorosa.BandDB.entity.Album;
import dev.ricardorosa.BandDB.exceptions.AlreadyExistsException;
import dev.ricardorosa.BandDB.exceptions.IncompleteBodyException;
import dev.ricardorosa.BandDB.exceptions.NotFoundException;
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
				.orElseThrow(() -> new NotFoundException("album", id));
	}
	
	public Album save(Album newAlbum) {
		if (newAlbum.getName() == null
			|| newAlbum.getReleased() == 0) {
			throw new IncompleteBodyException("album", "'name' and 'released'");
		}
		
		Album exists = repository.findByName(newAlbum.getName());
		if (exists != null) {
			throw new AlreadyExistsException("album", "name", exists.getName());
		}
		
		return repository.save(newAlbum);
	}
	
	public Album update(Long id, Album updateAlbum) {
		if (updateAlbum.getName() == null
				|| updateAlbum.getReleased() == 0) {
				throw new IncompleteBodyException("album", "'name' and 'released'");
			}
		
		Album foundAlbum = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("album", id));
		foundAlbum.setName(updateAlbum.getName());
		foundAlbum.setReleased(updateAlbum.getReleased());
		
		return repository.save(foundAlbum);
	}
	
	public void delete(Long id) {
		Album foundAlbum = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("album", id));
		
		repository.delete(foundAlbum);
	}

}
