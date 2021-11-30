package dev.ricardorosa.BandDB.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BandMusician {
	
	@EmbeddedId
	private BandMusiciansId id = new BandMusiciansId();
	
	@ManyToOne
	@MapsId("bandId")
	@JoinColumn(name = "band_id")
	private Band band;
	
	@ManyToOne
	@MapsId("musicianId")
	@JoinColumn(name = "musician_id")
	private Musician musician;
	
	private String role;
	private int joined;
}