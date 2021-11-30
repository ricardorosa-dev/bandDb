package dev.ricardorosa.BandDB.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonFormat(pattern = "dd-MM-yyyy")
	@JsonProperty("DoB")
	@Column(name = "date_of_birth")
	private LocalDate DoB;
	
	@ManyToMany
	@JoinTable(
			name = "musician_instruments",
			joinColumns = @JoinColumn(name = "musician_id"),
			inverseJoinColumns = @JoinColumn(name = "instrument_id")
	)	
	private List<Instrument> instruments = new ArrayList<>();
	
	@OneToMany(mappedBy = "musician")
	private List<BandMusician> bands;
	
	public void addInstrument(Instrument instrument) {
		this.instruments.add(instrument);
	}

}
