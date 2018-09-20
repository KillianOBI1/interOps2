package com.ex2.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.ex2.sax.GaragesHandler;

class TestSAX {

  @Test
  void test() {
    File file = new File("ressources/groupGarage.xml");
    try {
      SAXParserFactory factory = SAXParserFactory.newInstance(); 
      factory.setNamespaceAware(true); 
      SAXParser parser = factory.newSAXParser();  
      DefaultHandler handler = new GaragesHandler(); 
      parser.parse(file, handler); 
    } catch (ParserConfigurationException | SAXException | IOException pce) {
      pce.printStackTrace();
    } 
  }

}
