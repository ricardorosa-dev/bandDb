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

import dev.ricardorosa.BandDB.entity.Musician;
import dev.ricardorosa.BandDB.service.MusicianService;

@RestController
@RequestMapping("/musician")
public class MusicianController {
	
	private MusicianService service;
	
	@Autowired
	public MusicianController(MusicianService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Musician> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Musician findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Musician save(@RequestBody Musician newMusician) {
		return service.save(newMusician);
	}
	
	@PutMapping("/{id}")
	public Musician update(
			@PathVariable("id") Long id, 
			@RequestBody Musician updateMusician) {
		return service.update(id, updateMusician);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
