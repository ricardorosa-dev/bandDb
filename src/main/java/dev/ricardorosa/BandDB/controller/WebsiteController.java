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

import dev.ricardorosa.BandDB.entity.Website;
import dev.ricardorosa.BandDB.service.WebsiteService;

@RestController
@RequestMapping("/website")
public class WebsiteController {
	
	private WebsiteService service;
	
	@Autowired
	public WebsiteController(WebsiteService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Website> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Website findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Website save(@RequestBody Website newWebsite) {
		return service.save(newWebsite);
	}
	
	@PutMapping("/{id}")
	public Website update(
			@PathVariable("id") Long id, 
			@RequestBody Website updateWebsite) {
		return service.update(id, updateWebsite);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
