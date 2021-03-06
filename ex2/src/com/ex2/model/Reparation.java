package com.ex2.model;

import java.util.Date;

public abstract class Reparation {
	protected int id;
	protected Date arrivalDate;
	protected Date modifDate;
	
	public abstract String generateXML();
	public abstract int getId();
	public abstract Date getArrivalDate();
	public abstract Date getModifDate();
	public abstract void setId(int id);
	public abstract void setArrivalDate(Date arrivalDate);
	public abstract void setModifDate(Date modifDate);

}
