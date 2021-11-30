package dev.ricardorosa.BandDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.ricardorosa.BandDB.entity.Musician;
import dev.ricardorosa.BandDB.exceptions.AlreadyExistsException;
import dev.ricardorosa.BandDB.exceptions.IncompleteBodyException;
import dev.ricardorosa.BandDB.exceptions.NotFoundException;
import dev.ricardorosa.BandDB.repository.MusicianRepository;

@Service
public class MusicianService {
	
	private MusicianRepository repository;
	
	@Autowired
	public MusicianService(MusicianRepository repository) {
		this.repository = repository;
	}
	
	public List<Musician> findAll() {
		return repository.findAll();
	}
	
	public Musician findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new NotFoundException("musician", id));
	}
	
	public Musician save(Musician newMusician) {
		if (newMusician.getName() == null
			|| newMusician.getDoB() == null) {
			throw new IncompleteBodyException("musician", "'name' and 'DoB'");
		}
		
		Musician exists = repository.findByName(newMusician.getName());
		if (exists != null) {
			throw new AlreadyExistsException("musician", "name", exists.getName());
		}
		
		return repository.save(newMusician);
	}
	
	public Musician update(Long id, Musician updateMusician) {
		if (updateMusician.getName() == null
				|| updateMusician.getDoB() == null) {
				throw new IncompleteBodyException("musician", "'name' and 'DoB'");
			}
		
		Musician foundMusician = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("musician", id));
		foundMusician.setName(updateMusician.getName());
		foundMusician.setDoB(updateMusician.getDoB());
		
		return repository.save(foundMusician);
	}
	
	public void delete(Long id) {
		Musician foundMusician = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("musician", id));
		
		repository.delete(foundMusician);
	}

}
