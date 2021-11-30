package dev.ricardorosa.BandDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ricardorosa.BandDB.entity.Instrument;
import dev.ricardorosa.BandDB.service.InstrumentService;

@RestController
@RequestMapping("/instrument")
public class InstrumentController {
	
	private InstrumentService service;
	
	@Autowired
	public InstrumentController(InstrumentService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Instrument> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Instrument findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Instrument save(@RequestBody Instrument newInstrument) {
		return service.save(newInstrument);
	}
	
	@PutMapping("/{id}")
	public Instrument update(
			@PathVariable("id") Long id, 
			@RequestBody Instrument updateInstrument) {
		return service.update(id, updateInstrument);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
