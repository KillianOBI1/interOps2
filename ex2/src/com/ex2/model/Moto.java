package com.ex2.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	
	public Moto() {
    super();
  }

	@Override
	public String generateXML() {
	  DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		String nodeMoto = "";
		nodeMoto += "\t\t<Moto id=\""+this.id+"\">\n";
		nodeMoto += "\t\t\t<ArrivalDate>"+formatter.format(this.arrivalDate)+"</ArrivalDate>\n";
		nodeMoto += "\t\t\t<ModifDate>"+formatter.format(this.modifDate)+"</ModifDate>\n";
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

  @Override
  public void setId(int id) {
    this.id = id;
  }

  @Override
  public void setArrivalDate(Date arrivalDate) {
    this.arrivalDate = arrivalDate;
  }

  @Override
  public void setModifDate(Date modifDate) {
    this.modifDate = modifDate;
  }

}
