package com.formation.parking.controllers;
import  com.formation.parking.models.Parking;
import com.formation.parking.services.ParkingService;
import  java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//@RestController pour montrer à spring que cette classe est un composant injectable et instaciable et instanciée par spring
@RestController
public class ParkingController {
	/* @Autowired cherche un bean ParkingService s'il trouve pas il va initialiser un, sans autowird on ecrit 
	private ParkingService parkingService=new ParkingService();*/
	@Autowired
	private ParkingService parkingService;
	//recuperer la liste des parking
	//@RequestMapping faire le mapping entre l'uri serveur "/api/parkings" et la méthode java getListeParkings()
	@CrossOrigin("https://parking-nantes-app.herokuapp.com/")
	@RequestMapping(path="/api/parkings",method=RequestMethod.GET)
	public List<Parking> getListeParkings(){
		/*
		Parking parkingTest= new Parking();
		parkingTest.setNom("Parking de test");
		parkingTest.setNbPlacesTotal(300);
		parkingTest.setNbPlacesDispo(125);
		parkingTest.setStatut("OUVERT");
		parkingTest.setHeureMaj("20h15");
		ArrayList<Parking>  liste =new ArrayList<Parking>();
	
		liste.add(parkingTest);
		return liste;*/
		return parkingService.getListeParkings();
	}

}
