package com.ex2.model;

import java.util.Date;

public class Voiture extends Reparation {
	public Date lastCheckDate;
	
	public Voiture(int id,Date lastCheckDate, Date arrivalDate, Date modifDate) {
		super();
		this.id = id;
		this.lastCheckDate = lastCheckDate;
		this.arrivalDate = arrivalDate;
		this.modifDate = modifDate;
	}
	
	public Date getLastCheckDate() {
		return lastCheckDate;
	}
	
	public void setLastCheckDate(Date lastCheckDate) {
		this.lastCheckDate = lastCheckDate;
	}

	@Override
	public String generateXML() {
		
		return null;
	}
	
}
