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

import dev.ricardorosa.BandDB.entity.Album;
import dev.ricardorosa.BandDB.service.AlbumService;

@RestController
@RequestMapping("album")
public class AlbumController {
	
	private AlbumService service;
	
	@Autowired
	public AlbumController(AlbumService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Album> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Album findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Album save(@RequestBody Album newAlbum) {
		return service.save(newAlbum);
	}
	
	@PutMapping("/{id}")
	public Album update(
			@PathVariable("id") Long id, 
			@RequestBody Album updateAlbum) {
		return service.update(id, updateAlbum);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
