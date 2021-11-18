package com.coder.BandDb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.BandDb.entities.Album;
import com.coder.BandDb.entities.Band;
import com.coder.BandDb.entities.Instrument;
import com.coder.BandDb.entities.Musician;
import com.coder.BandDb.entities.Website;
import com.coder.BandDb.repository.AlbumRepository;
import com.coder.BandDb.repository.BandRepository;
import com.coder.BandDb.repository.InstrumentRepository;
import com.coder.BandDb.repository.MusicianRepository;
import com.coder.BandDb.repository.WebsiteRepository;
import com.fasterxml.jackson.core.json.UTF8DataInputJsonParser;

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
		return repository.findById(id).orElseThrow(() -> new RuntimeException());
	}
	
	public Website save(Website website) {
		if (website.getUrl() == null
			|| website.getVisitsPerMonth() == 0) {
			throw new RuntimeException();
		}
		return repository.save(website);
	}
	
	public Website update(Long id, Website updateWebsite) {
		if (updateWebsite.getUrl() == null
			|| updateWebsite.getVisitsPerMonth() == 0) {
			throw new RuntimeException();
		}
		
		Optional<Website> website = repository.findById(id);
		
		if (website.isPresent()) {
			website.get().setUrl(updateWebsite.getUrl());
			website.get().setVisitsPerMonth(updateWebsite.getVisitsPerMonth());
			website.get().setOnlineStore(updateWebsite.isOnlineStore());
			
			repository.save(website.get());
			
			return website.get();
		}
		
		throw new RuntimeException();
	}
	
	public void delete(Long id) {
		Website website = repository.findById(id)
				.orElseThrow(() -> new RuntimeException());
		
		repository.delete(website);
	}

}
