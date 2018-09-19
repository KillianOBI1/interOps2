package com.ex2.model;

import java.util.Date;

public class Moto extends Reparation {
	
	public boolean isSideCar;
	
	public Moto(boolean isSideCar, Date arrivalDate, Date modifDate) {
		super();
		this.isSideCar = isSideCar;
		this.arrivalDate = arrivalDate;
		this.modifDate = modifDate;
	}

	@Override
	public String generateXML() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean isSideCar() {
		return this.isSideCar;
	}
	
	public void setSideCar(boolean isSideCar) {
		this.isSideCar = isSideCar;
	}

}
