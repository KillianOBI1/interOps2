package com.ex2;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import com.ex2.TreeView.TreeViewController;
import com.ex2.TreeView.impl.TreeViewControllerImpl;
import com.ex2.model.Garage;
import com.ex2.model.GroupGarage;
import com.ex2.model.Moto;
import com.ex2.model.Voiture;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp  {

	public static void main(String[] args) {
	  GroupGarage groupGarage = createData();
    TreeViewController treeViewController = new TreeViewControllerImpl();
    treeViewController.init();
    treeViewController.registerData(groupGarage);
	}
	
	public static GroupGarage createData() {
    GroupGarage groupGarage = new GroupGarage();
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
    groupGarage.addGarage(garage);
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
    groupGarage.addGarage(garage);
    return groupGarage;
  }
}
