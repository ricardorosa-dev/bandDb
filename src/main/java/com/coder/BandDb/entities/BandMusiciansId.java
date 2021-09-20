package com.coder.BandDb.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BandMusiciansId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Band band;
	
	@ManyToOne
	private Musician musician;
}
