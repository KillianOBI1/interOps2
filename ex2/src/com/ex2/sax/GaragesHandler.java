package com.ex2.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.ex2.model.Garage;
import com.ex2.model.GroupGarage;

public class GaragesHandler extends DefaultHandler {
  
  GroupGarage groupGarage;
	
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
	  //TODO Appel�e � chaque d�but d'�l�ment
	  switch(localName) {
	  case "GroupGarage":
	    break;
	  case "Garage":
	    groupGarage.addGarage(new Garage(Integer.parseInt(attributs.getValue("id")),attributs.getValue("name"),attributs.getValue("adress")));
	  case "Voiture":
	  case "Moto":
	  }
	}
	
	public void endElement(String nameSpaceURI, String localName, String rawName) throws SAXException{
	  //TODO Appel�e � chaque fin d'�l�ment
	}
	
	public void characters(char[] ch, int start, int end) throws SAXException{
	  // TODO Appel�e � chaque fois qu'un contenu est lu entre deux balises
	}

}
