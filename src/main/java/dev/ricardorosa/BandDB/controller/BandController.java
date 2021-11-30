package dev.ricardorosa.BandDB.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import dev.ricardorosa.BandDB.dto.BandDTO;
import dev.ricardorosa.BandDB.entity.Album;
import dev.ricardorosa.BandDB.entity.Band;
import dev.ricardorosa.BandDB.entity.BandMusician;
import dev.ricardorosa.BandDB.service.BandService;

@RestController
@RequestMapping("/band")
public class BandController {
	
	private BandService service;
	
	@Autowired
	public BandController(BandService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<BandDTO> findAll() {
		return service.findAll().stream()
				.map(this::toBandDTO)
				.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public BandDTO findById(@PathVariable("id") Long id) {
		return this.toBandDTO(service.findById(id));
	}
	
	@PostMapping
	public Band save(@RequestBody Band newBand) {
		return service.save(newBand);
	}
	
	@PutMapping("/{id}")
	public BandDTO update(
			@PathVariable("id") Long id, 
			@RequestBody Band updateBand) {
		return this.toBandDTO(service.update(id, updateBand));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	private BandDTO toBandDTO(Band band) {
		List<String> albums = new ArrayList<>();
		if (band.getAlbuns() != null) {
			for (Album album : band.getAlbuns()) {
				albums.add(album.getName());
			}
		}
		
		Map<String, String> musicians = new HashMap<>();
		if (band.getMusicians() != null) {
			for (BandMusician musician : band.getMusicians()) {
				musicians.put(musician.getMusician().getName(), musician.getRole());
			}
		}
		
		BandDTO dto = new BandDTO();
		dto.setName(band.getName());
		dto.setGenre(band.getGenre());
		dto.setYear(band.getYear());
		if (band.getWebsite() != null) {
			dto.setWebsite(band.getWebsite().getUrl());
		}
		dto.setAlbums(albums);
		dto.setMusicians(musicians);
		
		return dto;
	}

}
