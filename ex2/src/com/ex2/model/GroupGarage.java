package com.ex2.model;

import java.util.ArrayList;
import java.util.List;

public class GroupGarage {
	
	protected List<Garage> garages;
	
	public GroupGarage() {
		this.garages = new ArrayList<Garage>();
	}
	
	public void generateXML() {
		//TODO todo
	}
	
	public void addGarage(Garage garage) {
		this.garages.add(garage);
	}
	
	
}
