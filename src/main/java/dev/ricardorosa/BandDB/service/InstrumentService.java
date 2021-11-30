package dev.ricardorosa.BandDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ricardorosa.BandDB.entity.Album;
import dev.ricardorosa.BandDB.entity.Instrument;
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
				.orElseThrow(RuntimeException::new);
	}
	
	public Instrument save(Instrument newInstrument) {
		return repository.save(newInstrument);
	}
	
	public Instrument update(Long id, Instrument updateInstrument) {
		Instrument foundInstrument = repository.findById(id)
				.orElseThrow(RuntimeException::new);
		foundInstrument.setName(updateInstrument.getName());
		foundInstrument.setCategory(updateInstrument.getCategory());
		
		return repository.save(foundInstrument);
	}
	
	public void delete(Long id) {
		Instrument foundInstrument = repository.findById(id)
				.orElseThrow(RuntimeException::new);
		
		repository.delete(foundInstrument);
	}

}
