package com.ex2.model;

import java.util.ArrayList;
import java.util.List;

public class Garage {
	protected int id;
	protected String name;
	protected String adress;
	protected List<Reparation> reparations;
	
	public Garage(int id,String name, String adress) {
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.reparations = new ArrayList<Reparation>();
	}
	
	public Garage() {
    this.reparations = new ArrayList<Reparation>();
  }
	
	public String generateXML() {
		String nodeGarage = "\t<Garage id=\""+this.id+"\" name=\""+this.name+"\" adress=\""+this.adress+"\">\n";
		for(Reparation reparation : this.reparations) {
			nodeGarage += reparation.generateXML();
		}
		nodeGarage += "\t</Garage>\n";
		return nodeGarage;
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
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

  @Override
  public String toString() {
    return "Garage [id=" + id + ", name=" + name + ", adress=" + adress +"]";
  }
}
