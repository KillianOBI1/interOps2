package com.ex2.model;

import java.util.Date;

public abstract class Reparation {
	
	protected Date arrivalDate;
	protected Date modifDate;
	
	public abstract String generateXML();

}
