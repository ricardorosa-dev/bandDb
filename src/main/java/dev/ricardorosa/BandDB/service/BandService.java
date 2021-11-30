package dev.ricardorosa.BandDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ricardorosa.BandDB.entity.Album;
import dev.ricardorosa.BandDB.entity.Band;
import dev.ricardorosa.BandDB.exceptions.AlreadyExistsException;
import dev.ricardorosa.BandDB.exceptions.IncompleteBodyException;
import dev.ricardorosa.BandDB.exceptions.NotFoundException;
import dev.ricardorosa.BandDB.repository.AlbumRepository;
import dev.ricardorosa.BandDB.repository.BandRepository;

@Service
public class BandService {
	
	private BandRepository repository;
	
	@Autowired
	public BandService(BandRepository repository) {
		this.repository = repository;
	}
	
	public List<Band> findAll() {
		return repository.findAll();
	}
	
	public Band findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new NotFoundException("band", id));
	}
	
	public Band save(Band newBand) {
		if (newBand.getName() == null
			|| newBand.getGenre() == null
			|| newBand.getYear() == 0) {
			throw new IncompleteBodyException("band", "'name', 'genre' and 'year'");
		}
		
		Band exists = repository.findByName(newBand.getName());
		if (exists != null) {
			throw new AlreadyExistsException("band", "name", exists.getName());
		}
		
		return repository.save(newBand);
	}
	
	public Band update(Long id, Band updateBand) {
		if (updateBand.getName() == null
			|| updateBand.getGenre() == null
			|| updateBand.getYear() == 0) {
			throw new IncompleteBodyException("band", "'name', 'genre' and 'year'");
		}
		
		Band foundBand = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("band", id));
		foundBand.setName(updateBand.getName());
		foundBand.setGenre(updateBand.getGenre());
		foundBand.setYear(updateBand.getYear());
		
		return repository.save(foundBand);
	}
	
	public void delete(Long id) {
		Band foundBand = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("band", id));
		
		repository.delete(foundBand);
	}

}
