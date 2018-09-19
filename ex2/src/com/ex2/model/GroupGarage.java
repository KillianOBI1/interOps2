package com.ex2.model;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupGarage {
	
	protected List<Garage> garages;
	
	protected final static String HEAD = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n<Gestionnaire>\n";
	
	public GroupGarage() {
		this.garages = new ArrayList<Garage>();
	}
	
	public boolean generateXML() {
		String nodeGroupGarage = "";
		nodeGroupGarage += HEAD;
		nodeGroupGarage += "<GroupGarage>\n";
		for(Garage garage : this.garages) {
			nodeGroupGarage += garage.generateXML();
		}
		nodeGroupGarage += "</GroupGarage>";
		Writer writer;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ressources/groupGarage.xml"), "utf-8"));
			writer.write(nodeGroupGarage);
			writer.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public void addGarage(Garage garage) {
		this.garages.add(garage);
	}
	
	
}
