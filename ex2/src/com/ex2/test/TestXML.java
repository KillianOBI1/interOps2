package com.ex2.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
	void testExport() {
		groupGarage = data();
		assertTrue(groupGarage.generateXML());
	}
	@Test
	void testData() {
		groupGarage = data();
		File f = new File("ressources/groupGarage.xml");
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;

		try {
			builder = factory.newDocumentBuilder();
			final Document document= builder.parse(f);
			assertTrue(document.getDocumentElement().getNodeName().equals(groupGarage.getClass().getSimpleName()));

			NodeList nList = document.getDocumentElement().getChildNodes();
			List<Element> listGarage = new ArrayList<Element>();
			for(int i = 0 ; i < nList.getLength(); i++) {
				if(nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nList.item(i);
					listGarage.add(element);
				}
			}
			assertTrue(listGarage.size() == groupGarage.getGarages().size());
			for(int i = 0 ; i < listGarage.size(); i++) {
				assertTrue(listGarage.get(i).getAttribute("id").equals(groupGarage.getGarages().get(i).getId()+""));
			}
			for(int i = 0 ; i < listGarage.size() ; i++) {
				List<Element> listReparation = new ArrayList<Element>();
				for(int j = 0; j < listGarage.get(i).getChildNodes().getLength();j++) {
					if(listGarage.get(i).getChildNodes().item(j).getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) listGarage.get(i).getChildNodes().item(j);
						listReparation.add(element);
					}
				}
				assertTrue(groupGarage.getGarages().get(i).getReparations().size() == listReparation.size());
				 DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
				for(int j = 0; j < listReparation.size() ; j++) {
					assertTrue(listReparation.get(j).getAttribute("id").equals(groupGarage.getGarages().get(i).getReparations().get(j).getId()+""));
					assertTrue(((Element) listReparation.get(j).getChildNodes()).getElementsByTagName("ArrivalDate").item(0).getTextContent().equals(formatter.format(groupGarage.getGarages().get(i).getReparations().get(j).getArrivalDate())));
					assertTrue(((Element) listReparation.get(j).getChildNodes()).getElementsByTagName("ModifDate").item(0).getTextContent().equals(formatter.format(groupGarage.getGarages().get(i).getReparations().get(j).getModifDate())));
					if(((Element) listReparation.get(j).getChildNodes()).getNodeName().equals("Voiture")) {
						assertTrue(((Element) listReparation.get(j).getChildNodes()).getElementsByTagName("LastCheckDate").item(0).getTextContent().equals(formatter.format(((Voiture) groupGarage.getGarages().get(i).getReparations().get(j)).getLastCheckDate())));
					} else {
						assertTrue(((Element) listReparation.get(j).getChildNodes()).getElementsByTagName("SideCar").item(0).getTextContent().equals(((Moto) groupGarage.getGarages().get(i).getReparations().get(j)).isSideCar()+""));
					}
				}
			}
	            
	      } catch (ParserConfigurationException | SAXException | IOException e) {
	    	  // TODO Auto-generated catch block
	    	  e.printStackTrace();
	      }
	        
	}

}
