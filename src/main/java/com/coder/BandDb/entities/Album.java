package com.coder.BandDb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int released;
	
	@ManyToOne
	@JoinColumn(
			name = "band_id",
			referencedColumnName = "id"
	)
	private Band band;

	public Album(String name, int released) {
		super();
		this.name = name;
		this.released = released;
	}
	
	

}
