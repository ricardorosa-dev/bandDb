package dev.ricardorosa.BandDB.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ricardorosa.BandDB.dto.AlbumDTO;
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
	public List<AlbumDTO> findAll() {
		return service.findAll().stream()
				.map(this::toAlbumDTO)
				.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public AlbumDTO findById(@PathVariable("id") Long id) {
		return this.toAlbumDTO(service.findById(id));
	}
	
	@PostMapping
	public AlbumDTO save(@RequestBody Album newAlbum) {
		return this.toAlbumDTO(service.save(newAlbum));
	}
	
	@PutMapping("/{id}")
	public AlbumDTO update(
			@PathVariable("id") Long id, 
			@RequestBody Album updateAlbum) {
//		System.out.println(updateAlbum.getBand().getName());
		return this.toAlbumDTO(service.update(id, updateAlbum));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	private AlbumDTO toAlbumDTO(Album album) {
		AlbumDTO dto = new AlbumDTO();
		dto.setName(album.getName());
		dto.setReleased(album.getReleased());
		dto.setBand(album.getBand().getName());
		
		return dto;
	}

}
