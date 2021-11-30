package dev.ricardorosa.BandDB.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@OneToOne(mappedBy = "band")
	private Website website;
	
	@OneToMany(mappedBy = "band")
	private List<Album> albuns;
	
	@OneToMany(mappedBy = "band")
	private List<BandMusician> musicians;

}
