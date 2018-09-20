package com.ex2.sax;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.ex2.model.Garage;
import com.ex2.model.GroupGarage;
import com.ex2.model.Moto;
import com.ex2.model.Voiture;

public class GaragesHandler extends DefaultHandler {
  
  public GroupGarage groupGarage;
  int actualIdGarage;
  int indexReparation = 0;
  int element = -1;
  
  boolean isCar = false;
  
	public GaragesHandler() {
		super();
	}
	
	public void startDocument() throws SAXException{
	  groupGarage = new GroupGarage();
	}
	
	public void endDocument() throws SAXException{
	  System.out.println("done");
	}
	
	public void startElement(String namespaceUri, String localName, String rawName, Attributes attributs) throws SAXException{
	  //TODO Appelée à chaque début d'élément
	  switch(localName) {
	  case "GroupGarage":
	    break;
	  case "Garage":
	    this.actualIdGarage = Integer.parseInt(attributs.getValue("id"));
	    groupGarage.addGarage(new Garage(Integer.parseInt(attributs.getValue("id")),attributs.getValue("name"),attributs.getValue("adress")));
	    break;
	  case "Voiture":
	    isCar = true;
	    indexReparation++;
	    groupGarage.getGarages().get(this.actualIdGarage).putReparation(new Voiture(Integer.parseInt(attributs.getValue("id")), null, null, null));
	    break;
	  case "Moto":
	    isCar = false;
	    indexReparation++;
      groupGarage.getGarages().get(this.actualIdGarage).putReparation(new Moto(Integer.parseInt(attributs.getValue("id")), false,null,null));
      break;
	  case "ArrivalDate":
	    this.element = 0;
	    break;
	  case "ModifDate":
	    this.element = 1;
	    break;
	  case "SideCar":
	    this.element = 2;
	    break;
	  case "LastCheckDate":
	    this.element = 3;
	    break;
	  }
	}
	
	public void endElement(String nameSpaceURI, String localName, String rawName) throws SAXException{
	  switch(localName) {
	  case "Garage":
	    indexReparation = 0;
	    break;
	  }
	}

	public void characters(char[] ch, int start, int end) throws SAXException{
	  // TODO Appelée à chaque fois qu'un contenu est lu entre deux balises
	  DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
	  if(!new String(ch,start,end).endsWith("\n") || !new String(ch,start,end).endsWith("\t")) {
	    switch(element) {
	    case 0:
	      try {
	        Date date = formatter.parse(new String(ch,start,end));
	        this.groupGarage.getGarages().get(this.actualIdGarage).getReparations().get(this.indexReparation-1).setArrivalDate(date);
	      } catch (ParseException e) {
	        e.printStackTrace();
	      }
	      this.element = -1;
	      break;
	    case 1:
	      try {
	        Date date = formatter.parse(new String(ch,start,end));
	        this.groupGarage.getGarages().get(this.actualIdGarage).getReparations().get(this.indexReparation-1).setModifDate(date);
	      } catch (ParseException e) {
	        e.printStackTrace();
	      }
	      this.element = -1;
	      break;
	    case 2:
	      if(new String(ch,start,end).equals("true")) {
	        ((Moto) this.groupGarage.getGarages().get(this.actualIdGarage).getReparations().get(this.indexReparation-1)).setSideCar(true);
	      } else {
	        ((Moto) this.groupGarage.getGarages().get(this.actualIdGarage).getReparations().get(this.indexReparation-1)).setSideCar(false);
	      }
	      this.element = -1;
	      break;
	    case 3:
	      try {
	        Date date = formatter.parse(new String(ch,start,end));
	        ((Voiture) this.groupGarage.getGarages().get(this.actualIdGarage).getReparations().get(this.indexReparation-1)).setLastCheckDate(date);
	      } catch (ParseException e) {
	        e.printStackTrace();
	      }
	      this.element = -1;
	      break;
	    }
	  }
	}

}
