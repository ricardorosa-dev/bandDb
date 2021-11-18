package com.coder.BandDb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.BandDb.entities.Album;
import com.coder.BandDb.entities.Band;
import com.coder.BandDb.entities.Instrument;
import com.coder.BandDb.entities.Musician;
import com.coder.BandDb.repository.AlbumRepository;
import com.coder.BandDb.repository.BandRepository;
import com.coder.BandDb.repository.InstrumentRepository;
import com.coder.BandDb.repository.MusicianRepository;

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
		return repository.findById(id).orElseThrow(() -> new RuntimeException());
	}
	
	public Musician save(Musician musician) {
		if (musician.getName() == null
			|| musician.getDoB() == 0) {
			throw new RuntimeException();
		}
		return repository.save(musician);
	}
	
	public Musician update(Long id, Musician updateMusician) {
		if (updateMusician.getName() == null
			|| updateMusician.getDoB() == 0) {
			throw new RuntimeException();
		}
		
		Optional<Musician> musician = repository.findById(id);
		
		if (musician.isPresent()) {
			musician.get().setName(updateMusician.getName());
			musician.get().setDoB(updateMusician.getDoB());
			
			repository.save(musician.get());
			
			return musician.get();
		}
		
		throw new RuntimeException();
	}
	
	public void delete(Long id) {
		Musician musician = repository.findById(id)
				.orElseThrow(() -> new RuntimeException());
		
		repository.delete(musician);
	}

}
