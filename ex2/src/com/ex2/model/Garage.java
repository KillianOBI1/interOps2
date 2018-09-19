package com.ex2.model;

import java.util.ArrayList;
import java.util.List;

public class Garage {
	protected String name;
	protected String adress;
	protected List<Reparation> reparations;
	
	public Garage(String name, String adress) {
		this.name = name;
		this.adress = adress;
		this.reparations = new ArrayList<Reparation>();
	}
	
	public String generateXML() {
		//TODO aight
		return "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public List<Reparation> getReparations() {
		return this.reparations;
	}
	
	public void putReparation(Reparation reparation) {
		this.reparations.add(reparation);
	}
}
