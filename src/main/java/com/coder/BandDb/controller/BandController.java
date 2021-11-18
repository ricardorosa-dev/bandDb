package com.coder.BandDb.controller;

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

import com.coder.BandDb.entities.Album;
import com.coder.BandDb.entities.Band;
import com.coder.BandDb.service.AlbumService;
import com.coder.BandDb.service.BandService;

@RestController
@RequestMapping("/band")
public class BandController {
	
	private BandService service;
	
	@Autowired
	public BandController(BandService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Band> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Band findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Band save(@RequestBody Band newBand) {
		return service.save(newBand);
	}
	
	@PutMapping("/{id}")
	public Band update(@PathVariable("id") Long id, @RequestBody Band updateBand) {
		return service.update(id, updateBand);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
