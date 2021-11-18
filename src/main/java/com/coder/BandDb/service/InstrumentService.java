package com.coder.BandDb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.BandDb.entities.Album;
import com.coder.BandDb.entities.Band;
import com.coder.BandDb.entities.Instrument;
import com.coder.BandDb.repository.AlbumRepository;
import com.coder.BandDb.repository.BandRepository;
import com.coder.BandDb.repository.InstrumentRepository;

@Service
public class InstrumentService {
	
	private InstrumentRepository repository;
	
	@Autowired
	public InstrumentService(InstrumentRepository repository) {
		this.repository = repository;
	}
	
	public List<Instrument> findAll() {
		return repository.findAll();
	}
	
	public Instrument findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException());
	}
	
	public Instrument save(Instrument instrument) {
		if (instrument.getName() == null
			|| instrument.getCategory() == null) {
			throw new RuntimeException();
		}
		return repository.save(instrument);
	}
	
	public Instrument update(Long id, Instrument updateInstrument) {
		if (updateInstrument.getName() == null
			|| updateInstrument.getCategory() == null) {
			throw new RuntimeException();
		}
		
		Optional<Instrument> instrument = repository.findById(id);
		
		if (instrument.isPresent()) {
			instrument.get().setName(updateInstrument.getName());
			instrument.get().setCategory(updateInstrument.getCategory());
			
			repository.save(instrument.get());
			
			return instrument.get();
		}
		
		throw new RuntimeException();
	}
	
	public void delete(Long id) {
		Instrument instrument = repository.findById(id)
				.orElseThrow(() -> new RuntimeException());
		
		repository.delete(instrument);
	}

}
