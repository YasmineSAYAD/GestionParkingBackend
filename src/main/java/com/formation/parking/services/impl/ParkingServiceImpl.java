package com.formation.parking.services.impl;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.parking.dao.ParkingAPIDAO;
import com.formation.parking.dao.entity.RecordEntity;
import com.formation.parking.dao.entity.ResponseParkingAPIEntity;
import com.formation.parking.models.Parking;
import com.formation.parking.services.ParkingService;

//@Service c'est pour dire que ParkingServiceImpl est un composant injectable dans une autre classe (ParkingController)
@Service
public class ParkingServiceImpl implements ParkingService {
	@Autowired
	public ParkingAPIDAO parkingAPIDAO;
	@Override
	public List<Parking> getListeParkings() {
		/*Parking parkingTest= new Parking();
		parkingTest.setNom("Parking de test");
		parkingTest.setNbPlacesTotal(300);
		parkingTest.setNbPlacesDispo(125);
		parkingTest.setStatut("ouvert");
		parkingTest.setHeureMaj("20h15");
		ArrayList<Parking>  liste =new ArrayList<Parking>();
	
		liste.add(parkingTest);
		return liste;*/
		ResponseParkingAPIEntity response=parkingAPIDAO.getListeParkings();
		return  transformEntityToModel(response);
	}
	private List<Parking> transformEntityToModel(ResponseParkingAPIEntity response) {
		List<Parking> resultat=new ArrayList<Parking>();
		for(RecordEntity record: response.getRecords()) {
			
			Parking parking=new Parking();
			parking.setIdentifiant(Integer.parseInt(record.getFields().getIdobj()));
			parking.setNom(record.getFields().getGrp_nom());
			parking.setNbPlacesDispo(record.getFields().getGrp_disponible());
			parking.setNbPlacesTotal(record.getFields().getGrp_exploitation());
			parking.setStatut(getLibelleStatut(record));
			parking.setHeureMaj(getHeureMaj(record));
			resultat.add(parking);
		}
		return resultat;
	}
	public String getHeureMaj(RecordEntity record) {
		OffsetDateTime dateMaj=OffsetDateTime.parse(record.getFields().getGrp_horodatage());
		OffsetDateTime dateMajwithoffsetPlus2= dateMaj.withOffsetSameInstant(ZoneOffset.of("+02:00")); //+2h de paris
		return dateMajwithoffsetPlus2.getHour()+ "h" + dateMajwithoffsetPlus2.getMinute();
	}
	public String getLibelleStatut(RecordEntity record) {
		switch(record.getFields().getGrp_statut()) {
		case "1": {return "Fermé";}
		case "2": {return "Reservé aux abonnés";}
		case "5": {return "Ouvert";}
		}
		return "Données non disponibles";
	}

}
