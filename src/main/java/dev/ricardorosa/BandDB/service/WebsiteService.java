package dev.ricardorosa.BandDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ricardorosa.BandDB.entity.Musician;
import dev.ricardorosa.BandDB.entity.Website;
import dev.ricardorosa.BandDB.exceptions.AlreadyExistsException;
import dev.ricardorosa.BandDB.exceptions.IncompleteBodyException;
import dev.ricardorosa.BandDB.exceptions.NotFoundException;
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
				.orElseThrow(() -> new NotFoundException("website", id));
	}
	
	// Se não tiver visitsPerMonth, ele vai setar como 0
	// Se não tiver onlineStore, ele vai setar como false
	public Website save(Website newWebsite) {
		if (newWebsite.getUrl() == null) {
			throw new IncompleteBodyException(
					"website", 
					"'url'.\nIf no number of visitsPerMonth "
					+ "or onlineStore are set, "
					+ "they will be set to the default value "
					+ "(0 and false, respectively) "
					+ "for these ");
		}
		
		Website exists = repository.findByUrl(newWebsite.getUrl());
		if (exists != null) {
			throw new AlreadyExistsException("website", "url", exists.getUrl());
		}
		
		return repository.save(newWebsite);
	}
	
	public Website update(Long id, Website updateWebsite) {
		if (updateWebsite.getUrl() == null) {
			throw new IncompleteBodyException(
					"website", 
					"'url'. If no number of visitsPerMonth "
					+ "or onlineStore are set, "
					+ "they will be set to default "
					+ "(0 and false, respectively).");
		}
		
		Website foundWebsite = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("website", id));
		foundWebsite.setUrl(updateWebsite.getUrl());
		foundWebsite.setVisitsPerMonth(updateWebsite.getVisitsPerMonth());
		foundWebsite.setOnlineStore(updateWebsite.isOnlineStore());
		
		return repository.save(foundWebsite);
	}
	
	public void delete(Long id) {
		Website foundWebsite = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("website", id));
		
		repository.delete(foundWebsite);
	}

}
