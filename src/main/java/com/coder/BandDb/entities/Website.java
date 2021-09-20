package com.coder.BandDb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Website {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String url;
	private int visitsPerMonth;
	private boolean onlineStore;
	
	@OneToOne(mappedBy = "website")
	private Band band;

	public Website(String url, int visitsPerMonth, boolean onlineStore) {
		super();
		this.url = url;
		this.visitsPerMonth = visitsPerMonth;
		this.onlineStore = onlineStore;
	}

}
