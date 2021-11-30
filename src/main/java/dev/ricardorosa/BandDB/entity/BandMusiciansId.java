package dev.ricardorosa.BandDB.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BandMusiciansId implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name = "band_id")
	private Long bandId;
	
	@Column(name = "musician_id")
	private Long musicianId;
}
