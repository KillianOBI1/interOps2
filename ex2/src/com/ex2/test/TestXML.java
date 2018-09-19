package com.ex2.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.ex2.model.Garage;
import com.ex2.model.GroupGarage;
import com.ex2.model.Moto;
import com.ex2.model.Voiture;

class TestXML {
	
	@Parameter(0)
	  public GroupGarage groupGarage;

	  // creates the test data
	  @Parameters
	  public static GroupGarage data() {
		  GroupGarage g = new GroupGarage();
		  //FirstGarage
		  Garage garage = new Garage(0, "Dédé Garage", "20 av le gorgeu");
		  Calendar calendar = Calendar.getInstance();
		  //Car
		  
		  calendar.set(2018, 05, 01, 0, 0, 0);
		  Date dCheck = calendar.getTime();
		  calendar.set(2018, 05, 05, 0, 0, 0);
		  Date dArrival = calendar.getTime();
		  calendar.set(2018, 05, 07, 0, 0, 0);
		  Date dModif = calendar.getTime();
		  garage.putReparation(new Voiture(0,dCheck , dArrival, dModif));
		  //Moto none sideCar
		  
		  calendar.set(2018, 06, 05, 0, 0, 0);
		  dArrival = calendar.getTime();
		  calendar.set(2018, 06, 07, 0, 0, 0);
		  dModif = calendar.getTime();
		  garage.putReparation(new Moto(0, false, dArrival, dModif));
		  //Moto none sideCar
		  
		  calendar.set(2018, 07, 05, 0, 0, 0);
		  dArrival = calendar.getTime();
		  calendar.set(2018, 07, 07, 0, 0, 0);
		  dModif = calendar.getTime();
		  garage.putReparation(new Moto(1, true, dArrival, dModif));
		  g.addGarage(garage);
		  //Second garage
		  garage = new Garage(1, "José Garage", "10 av le gorgeu");
		  //Car
		  
		  calendar.set(2018, 05, 01, 0, 0, 0);
		  dCheck = calendar.getTime();
		  calendar.set(2018, 05, 05, 0, 0, 0);
		  dArrival = calendar.getTime();
		  calendar.set(2018, 05, 07, 0, 0, 0);
		  dModif = calendar.getTime();
		  garage.putReparation(new Voiture(0,dCheck , dArrival, dModif));
		  //Moto none sideCar
		  
		  calendar.set(2018, 06, 01, 0, 0, 0);
		  dCheck = calendar.getTime();
		  calendar.set(2018, 06, 05, 0, 0, 0);
		  dArrival = calendar.getTime();
		  calendar.set(2018, 06, 07, 0, 0, 0);
		  dModif = calendar.getTime();
		  garage.putReparation(new Voiture(1,dCheck , dArrival, dModif));
		  //Moto none sideCar
		  
		  calendar.set(2018, 07, 05, 0, 0, 0);
		  dArrival = calendar.getTime();
		  calendar.set(2018, 07, 07, 0, 0, 0);
		  dModif = calendar.getTime();
		  garage.putReparation(new Moto(0, true, dArrival, dModif));
		  g.addGarage(garage);
	      return g;
	  }

	@Test
	void test() {
		groupGarage = data();
		assertTrue(groupGarage.generateXML());
	}

}
