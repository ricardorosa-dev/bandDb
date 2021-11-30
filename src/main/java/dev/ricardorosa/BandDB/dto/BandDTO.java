package dev.ricardorosa.BandDB.dto;

import java.util.List;
import java.util.Map;

import dev.ricardorosa.BandDB.entity.Album;
import dev.ricardorosa.BandDB.entity.BandMusician;
import dev.ricardorosa.BandDB.entity.Musician;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BandDTO {
	
	private String name;
	private String genre;
	private int year;
	private String website;
	private List<String> albums;
	private Map<String, String> musicians;

}
