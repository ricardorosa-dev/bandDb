package com.coder.BandDb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.BandDb.entities.Album;
import com.coder.BandDb.entities.Band;
import com.coder.BandDb.repository.AlbumRepository;
import com.coder.BandDb.repository.BandRepository;

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
		return repository.findById(id).orElseThrow(() -> new RuntimeException());
	}
	
	public Band save(Band band) {
		if (band.getName() == null
			|| band.getGenre() == null
			|| band.getYear() == 0) {
			throw new RuntimeException();
		}
		return repository.save(band);
	}
	
	public Band update(Long id, Band updateBand) {
		if (updateBand.getName() == null
				|| updateBand.getGenre() == null
				|| updateBand.getYear() == 0) {
				throw new RuntimeException();
			}
		
		Optional<Band> band = repository.findById(id);
		
		if (band.isPresent()) {
			band.get().setName(updateBand.getName());
			band.get().setGenre(updateBand.getGenre());
			band.get().setYear(updateBand.getYear());
			
			repository.save(band.get());
			
			return band.get();
		}
		
		throw new RuntimeException();
	}
	
	public void delete(Long id) {
		Band band = repository.findById(id)
				.orElseThrow(() -> new RuntimeException());
		
		repository.delete(band);
	}

}
