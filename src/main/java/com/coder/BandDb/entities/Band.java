package com.coder.BandDb.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Band {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String genre;
	private int year;
	
	@OneToOne
	@JoinColumn(
			name = "website_id",
			referencedColumnName = "id"
	)
	private Website website;
	
	@OneToMany(mappedBy = "band")
	private List<Album> albuns;
	
	@OneToMany(mappedBy = "id.band" )
	private List<BandMusician> musicians;
	
	public void addMusician(BandMusician musician) {
		this.musicians.add(musician);
	}

	public Band(String name, String genre, int year) {
		super();
		this.name = name;
		this.genre = genre;
		this.year = year;
	}
}
