package com.coder.BandDb.entities;

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
	
	private String role;
	private int joined;

}
