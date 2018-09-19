package com.ex2.model;

import java.util.Date;

public class Voiture extends Reparation {
	protected Date lastCheckDate;
	
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
		String nodeCar = "\t\t<Voiture id=\""+this.id+"\">\n";
		nodeCar += "\t\t\t<ArrivalDate>"+this.arrivalDate+"</ArrivalDate>\n";
		nodeCar += "\t\t\t<ModifDate>"+this.modifDate+"</ModifDate>\n";	
		nodeCar += "\t\t\t<LastCheckDate>"+this.lastCheckDate+"</LastCheckDate>\n";
		nodeCar += "\t\t</Voiture>\n";		
		return nodeCar;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public Date getArrivalDate() {
		return this.arrivalDate;
	}

	@Override
	public Date getModifDate() {
		return this.modifDate;
	}
	
}
