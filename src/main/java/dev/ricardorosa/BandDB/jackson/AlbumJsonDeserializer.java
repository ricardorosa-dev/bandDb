package dev.ricardorosa.BandDB.jackson;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import dev.ricardorosa.BandDB.entity.Album;
import dev.ricardorosa.BandDB.entity.Band;
import dev.ricardorosa.BandDB.repository.BandRepository;

public class AlbumJsonDeserializer extends JsonDeserializer<Album>{
	
	private final BandRepository bandRepository;
	
	@Autowired
	public AlbumJsonDeserializer(BandRepository bandRepository) {
		this.bandRepository = bandRepository;
	}

	@Override
	public Album deserialize(JsonParser p, DeserializationContext ctxt) 
			throws IOException, JacksonException {
		
		ObjectCodec codec = p.getCodec();
		JsonNode root = codec.readTree(p);
		
		Album album = new Album();
		album.setName(root.get("name").asText());
		album.setReleased(root.get("released").asInt());
		
		String bandName = root.get("band").asText();
		Band incomingBand = bandRepository.findByName(bandName);
		album.setBand(incomingBand);
		
		return album;
	}

}
