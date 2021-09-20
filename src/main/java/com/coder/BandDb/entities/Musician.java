package com.coder.BandDb.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Musician {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int DoB;
	
	@ManyToMany
	@JoinTable(
			name = "musician_instruments",
			joinColumns = @JoinColumn(name = "musician_id"),
			inverseJoinColumns = @JoinColumn(name = "instrument_id")
	)	
	private List<Instrument> instruments = new ArrayList<>();
	
	@OneToMany(mappedBy = "id.musician")
	private List<BandMusician> bands;
	
	public void addInstrument(Instrument instrument) {
		this.instruments.add(instrument);
	}

	public Musician(String name, int doB) {
		super();
		this.name = name;
		DoB = doB;
	}

}
