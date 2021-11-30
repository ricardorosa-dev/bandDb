package dev.ricardorosa.BandDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ricardorosa.BandDB.entity.Musician;
import dev.ricardorosa.BandDB.entity.Website;
import dev.ricardorosa.BandDB.repository.MusicianRepository;
import dev.ricardorosa.BandDB.repository.WebsiteRepository;

@Service
public class WebsiteService {
	
	private WebsiteRepository repository;
	
	@Autowired
	public WebsiteService(WebsiteRepository repository) {
		this.repository = repository;
	}
	
	public List<Website> findAll() {
		return repository.findAll();
	}
	
	public Website findById(Long id) {
		return repository.findById(id)
				.orElseThrow(RuntimeException::new);
	}
	
	public Website save(Website newWebsite) {
		return repository.save(newWebsite);
	}
	
	public Website update(Long id, Website updateWebsite) {
		Website foundWebsite = repository.findById(id)
				.orElseThrow(RuntimeException::new);
		foundWebsite.setUrl(updateWebsite.getUrl());
		foundWebsite.setVisitsPerMonth(updateWebsite.getVisitsPerMonth());
		foundWebsite.setOnlineStore(updateWebsite.isOnlineStore());
		
		return repository.save(foundWebsite);
	}
	
	public void delete(Long id) {
		Website foundWebsite = repository.findById(id)
				.orElseThrow(RuntimeException::new);
		
		repository.delete(foundWebsite);
	}

}
