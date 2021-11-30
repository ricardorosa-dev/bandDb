package dev.ricardorosa.BandDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ricardorosa.BandDB.entity.Album;
import dev.ricardorosa.BandDB.entity.Instrument;
import dev.ricardorosa.BandDB.exceptions.AlreadyExistsException;
import dev.ricardorosa.BandDB.exceptions.IncompleteBodyException;
import dev.ricardorosa.BandDB.exceptions.NotFoundException;
import dev.ricardorosa.BandDB.repository.AlbumRepository;
import dev.ricardorosa.BandDB.repository.InstrumentRepository;

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
		return repository.findById(id)
				.orElseThrow(() -> new NotFoundException("instrument", id));
	}
	
	public Instrument save(Instrument newInstrument) {
		if (newInstrument.getName() == null
			|| newInstrument.getCategory() == null) {
			throw new IncompleteBodyException("instrument", "'name' and 'category'");
		}
		
		Instrument exists = repository.findByName(newInstrument.getName());
		if (exists != null) {
			throw new AlreadyExistsException("instrument", "name", exists.getName());
		}
		
		return repository.save(newInstrument);
	}
	
	public Instrument update(Long id, Instrument updateInstrument) {
		if (updateInstrument.getName() == null
			|| updateInstrument.getCategory() == null) {
			throw new IncompleteBodyException("instrument", "'name' and 'category'");
		}
		
		Instrument foundInstrument = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("instrument", id));
		foundInstrument.setName(updateInstrument.getName());
		foundInstrument.setCategory(updateInstrument.getCategory());
		
		return repository.save(foundInstrument);
	}
	
	public void delete(Long id) {
		Instrument foundInstrument = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("instrument", id));
		
		repository.delete(foundInstrument);
	}

}
