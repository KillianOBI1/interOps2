package com.ex2.dom;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ex2.model.Garage;
import com.ex2.model.GroupGarage;
import com.ex2.model.Moto;
import com.ex2.model.Reparation;
import com.ex2.model.Voiture;

public class DomXmlTools {
  protected DocumentBuilder builder;
  File file;
  static String FILE_LOCATION = "ressources/DOMMadeGroupGarage.xml";
  
  
  public DomXmlTools() {
    this.file = new File(FILE_LOCATION);
  }
  
  public GroupGarage readXml() {
    final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    GroupGarage groupGarage;
    DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
    try {
      builder = factory.newDocumentBuilder();
      final Document document= builder.parse(file);
      document.getDocumentElement();
      groupGarage = new GroupGarage();
      NodeList garageList = document.getDocumentElement().getChildNodes();
      for(int i = 0 ; i < garageList.getLength(); i++) {
        if(garageList.item(i).getNodeType() == Node.ELEMENT_NODE) {
          Garage garage = new Garage();
          Element element = (Element) garageList.item(i);
          garage.setId(Integer.parseInt(element.getAttribute("id")));
          garage.setAdress(element.getAttribute("adress"));
          garage.setName(element.getAttribute("name"));
          NodeList reparationList = garageList.item(i).getChildNodes();
          for (int j = 0 ; j < reparationList.getLength(); j++) {
            if (reparationList.item(j).getNodeType() == Node.ELEMENT_NODE) {
              Element repElement = (Element) reparationList.item(j);
              if(repElement.getNodeName().equals("Moto")) {
                Moto moto = new Moto();
                moto.setId(Integer.parseInt(repElement.getAttribute("id")));
                moto.setArrivalDate(formatter.parse(repElement.getElementsByTagName("ArrivalDate").item(0).getTextContent()));
                moto.setModifDate(formatter.parse(repElement.getElementsByTagName("ModifDate").item(0).getTextContent()));
                if(repElement.getElementsByTagName("SideCar").item(0).getTextContent().equals("true")) {
                  moto.setSideCar(true);
                } else {
                  moto.setSideCar(false);
                }
                garage.putReparation(moto);
              } else {
                Voiture voiture = new Voiture();
                voiture.setId(Integer.parseInt(repElement.getAttribute("id")));
                voiture.setArrivalDate(formatter.parse(repElement.getElementsByTagName("ArrivalDate").item(0).getTextContent()));
                voiture.setModifDate(formatter.parse(repElement.getElementsByTagName("ModifDate").item(0).getTextContent()));
                voiture.setLastCheckDate(formatter.parse(repElement.getElementsByTagName("LastCheckDate").item(0).getTextContent()));
                garage.putReparation(voiture);
              }
            }
          }
          groupGarage.addGarage(garage);
        }
      }
      return groupGarage;
    } catch (ParserConfigurationException | SAXException | IOException | DOMException | ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }
 
  
  public void exportXML(GroupGarage groupGarage) {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db;
    DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
      try {
        db = dbf.newDocumentBuilder();
        DOMImplementation domImpl = db.getDOMImplementation();
        Document document = domImpl.createDocument(null, "GroupGarage", null);
        for(int i = 0 ; i < groupGarage.getGarages().size(); i++) {
          Element garage = document.createElement("Garage");
          garage.setAttribute("adress", groupGarage.getGarages().get(i).getAdress());
          garage.setAttribute("name", groupGarage.getGarages().get(i).getName());
          garage.setAttribute("id", ""+groupGarage.getGarages().get(i).getId());
          for(int j = 0 ; j < groupGarage.getGarages().get(i).getReparations().size(); j++) {
            Element reparation;
            Element arrivalDateElement = document.createElement("ArrivalDate");
            Element lastModifElementElement = document.createElement("ModifDate");
            Element thirdElement;
            if(groupGarage.getGarages().get(i).getReparations().get(j).getClass().getSimpleName().equals("Voiture")) {
              reparation = document.createElement("Voiture");
              thirdElement = document.createElement("LastCheckDate");
              thirdElement.setTextContent(formatter.format(((Voiture)groupGarage.getGarages().get(i).getReparations().get(j)).getLastCheckDate()));
            } else {
              reparation = document.createElement("Moto");
              thirdElement = document.createElement("SideCar");
              thirdElement.setTextContent(((Moto)groupGarage.getGarages().get(i).getReparations().get(j)).isSideCar+"");
            }
            arrivalDateElement.setTextContent(formatter.format(groupGarage.getGarages().get(i).getReparations().get(j).getArrivalDate()));
            lastModifElementElement.setTextContent(formatter.format(groupGarage.getGarages().get(i).getReparations().get(j).getModifDate()));
            reparation.setAttribute("id", groupGarage.getGarages().get(i).getReparations().get(j).getId()+"");
            reparation.appendChild(arrivalDateElement);
            reparation.appendChild(lastModifElementElement);
            reparation.appendChild(thirdElement);
            garage.appendChild(reparation);
          }
          document.getDocumentElement().appendChild(garage);
        }
        //OUTPUT
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult f = new StreamResult(new File(FILE_LOCATION));
        transformer.transform(source, f);
        // Ecrire sur la sortie standard
//        StreamResult c = new StreamResult(System.out);
//        transformer.transform(source, c);
      } catch (ParserConfigurationException | TransformerException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
       
  }
  
}
