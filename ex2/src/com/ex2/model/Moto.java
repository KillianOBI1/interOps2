package com.ex2.model;

import java.util.Date;

public class Moto extends Reparation {
	
	public boolean isSideCar;
	
	public Moto(int id, boolean isSideCar, Date arrivalDate, Date modifDate) {
		super();
		this.id = id;
		this.isSideCar = isSideCar;
		this.arrivalDate = arrivalDate;
		this.modifDate = modifDate;
	}

	@Override
	public String generateXML() {
		String nodeMoto = "";
		nodeMoto += "\t\t<Moto id=\""+this.id+"\">\n";
		nodeMoto += "\t\t\t<ArrivalDate>"+this.arrivalDate+"</ArrivalDate>\n";
		nodeMoto += "\t\t\t<ModifDate>"+this.modifDate+"</ModifDate>\n";
		nodeMoto += "\t\t\t<SideCar>"+this.isSideCar+"</SideCar>\n";
		nodeMoto += "\t\t</Moto>\n";
		return nodeMoto;
	}
	
	public boolean isSideCar() {
		return this.isSideCar;
	}
	
	public void setSideCar(boolean isSideCar) {
		this.isSideCar = isSideCar;
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
