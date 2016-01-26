package com.bascollaoussing.model;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name="currency")
@XmlAccessorType(XmlAccessType.FIELD)
public class Currency {
	private int ID;
	// The name of the currency (e.g. "Euro").
	private String name;
	// The name of the countries in which the currency is used (e.g. "EU" for Euro).
	private String country;
	// The year in which this currency was adopted for the first time (e.g. 1999 for Euro).
	private int yearAdopted;
	
	public Currency() {
		
	}
	
	public Currency(String name, String country, int yearAdopted, int id) {
		super();
		this.ID = id;
		this.name = name;
		this.country = country;
		this.yearAdopted = yearAdopted;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getYearAdopted() {
		return yearAdopted;
	}
	public void setYearAdopted(int yearAdopted) {
		this.yearAdopted = yearAdopted;
	}
}
