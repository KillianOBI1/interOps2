package com.ex2.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized.Parameters;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.ex2.model.Garage;
import com.ex2.model.GroupGarage;
import com.ex2.model.Moto;
import com.ex2.model.Voiture;
import com.ex2.sax.GaragesHandler;

class TestSAX {

  
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
    File file = new File("ressources/groupGarage.xml");
    try {
      SAXParserFactory factory = SAXParserFactory.newInstance(); 
      factory.setNamespaceAware(true); 
      SAXParser parser = factory.newSAXParser();
      GaragesHandler gHandler = new GaragesHandler();
      DefaultHandler handler =  gHandler;
      parser.parse(file, handler); 
      GroupGarage gg = data();
      
      assertTrue(gHandler.groupGarage.getGarages().size() == gg.getGarages().size());
      for(int i = 0 ; i < gg.getGarages().size(); i++) {
        assertTrue(gg.getGarages().get(i).toString().equals(gHandler.groupGarage.getGarages().get(i).toString()));
      }
      assertTrue(gg.generateXMLinString().equals(gHandler.groupGarage.generateXMLinString()));
      System.out.println(gHandler.groupGarage.generateXMLinString());
    } catch (ParserConfigurationException | SAXException | IOException pce) {
      pce.printStackTrace();
    } 
    
  }

}
