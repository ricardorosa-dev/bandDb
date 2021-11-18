package com.coder.BandDb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	@Column(name = "visits_per_month")
	private int visitsPerMonth;
	@Column(name = "online_store")
	private boolean onlineStore;

	public Website(String url, int visitsPerMonth, boolean onlineStore) {
		super();
		this.url = url;
		this.visitsPerMonth = visitsPerMonth;
		this.onlineStore = onlineStore;
	}

}
