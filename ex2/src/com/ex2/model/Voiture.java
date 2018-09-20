package com.ex2.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	
	 public Voiture() {
	    super();
	  }
	
	public Date getLastCheckDate() {
		return lastCheckDate;
	}
	
	public void setLastCheckDate(Date lastCheckDate) {
		this.lastCheckDate = lastCheckDate;
	}

	@Override
	public String generateXML() {
	  DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		String nodeCar = "\t\t<Voiture id=\""+this.id+"\">\n";
		nodeCar += "\t\t\t<ArrivalDate>"+formatter.format(this.arrivalDate)+"</ArrivalDate>\n";
		nodeCar += "\t\t\t<ModifDate>"+formatter.format(this.modifDate)+"</ModifDate>\n";	
		nodeCar += "\t\t\t<LastCheckDate>"+formatter.format(this.lastCheckDate)+"</LastCheckDate>\n";
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
