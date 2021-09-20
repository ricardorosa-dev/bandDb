package com.coder.BandDb.entities;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.coder.BandDb.repository.AlbumRepository;
import com.coder.BandDb.repository.BandMusicianRepository;
import com.coder.BandDb.repository.BandRepository;
import com.coder.BandDb.repository.InstrumentRepository;
import com.coder.BandDb.repository.MusicianRepository;
import com.coder.BandDb.repository.WebsiteRepository;

@Component
public class Config implements CommandLineRunner{
	
	private BandRepository bandRepository;
	private WebsiteRepository websiteRepository;
	private AlbumRepository albumRepository;
	private MusicianRepository musicianRepository;
	private InstrumentRepository instrumentRepository;
	private BandMusicianRepository bandMusicianRepository;
	
	public Config(
			BandRepository bandRepository, 
			WebsiteRepository websiteRepository,
			AlbumRepository albumRepository,
			MusicianRepository musicianRepository,
			InstrumentRepository instrumentRepository,
			BandMusicianRepository bandMusicianRepository
	) {
		this.bandRepository = bandRepository;
		this.websiteRepository = websiteRepository;
		this.albumRepository = albumRepository;
		this.musicianRepository = musicianRepository;
		this.instrumentRepository = instrumentRepository;
		this.bandMusicianRepository = bandMusicianRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Band tool = new Band("Tool", "Rock", 1990);
		Band aerosmith = new Band("Aerosmith", "Rock", 1970);
		
		Website toolWebsite = new Website("http://www.toolband.com", 9000, true);
		websiteRepository.save(toolWebsite);
		
		tool.setWebsite(toolWebsite);
		
		Instrument vocals = new Instrument("vocals", "air");
		Instrument drums = new Instrument("drums", "percussion");
		Instrument keyboard = new Instrument("keyboard", "keys");
		instrumentRepository.save(vocals);
		instrumentRepository.save(drums);
		instrumentRepository.save(keyboard);
		
		
		Musician toolVocals = new Musician("Maynard Keenan", 1964);
		toolVocals.addInstrument(vocals);
		toolVocals.addInstrument(keyboard);
		Musician toolDrums = new Musician("Danny Carey", 1961);
		toolDrums.addInstrument(drums);
		musicianRepository.save(toolVocals);
		musicianRepository.save(toolDrums);
		
		bandRepository.save(aerosmith);
		bandRepository.save(tool);
		
		BandMusiciansId id1 = new BandMusiciansId(tool, toolVocals);
		BandMusician person1 = new BandMusician(id1, "vocals", 1990);
		bandMusicianRepository.save(person1);
		
		Album lateralus = new Album("Lateralus", 2001);
		Album undertow = new Album("Undertow", 1993);
		lateralus.setBand(tool);
		undertow.setBand(tool);
		albumRepository.save(lateralus);
		albumRepository.save(undertow);

	}
}
