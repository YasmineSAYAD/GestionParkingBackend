package com.formation.parking.dao.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import com.formation.parking.dao.entity.ResponseParkingAPIEntity;

@Repository
public class ParkingAPIDAOImpl implements com.formation.parking.dao.ParkingAPIDAO {
private static final String URL_API_OPEN_DATA = "https://data.nantesmetropole.fr/api/records/1.0/search/?dataset=244400404_parkings-publics-nantes-disponibilites&q=&facet=grp_nom&facet=grp_statut";
@Autowired
private RestTemplate restTemplate;
	@Override
	public ResponseParkingAPIEntity getListeParkings() {
		return restTemplate.getForEntity(URL_API_OPEN_DATA, ResponseParkingAPIEntity.class).getBody();
	}
}