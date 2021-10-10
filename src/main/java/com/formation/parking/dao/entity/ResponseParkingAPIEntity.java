package com.formation.parking.dao.entity;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown=true) pour les attributs qu'on utilise pas dans le fichier json
@JsonIgnoreProperties(ignoreUnknown=true)
public class ResponseParkingAPIEntity {
	@JsonProperty(value = "records")
	private List<RecordEntity> records;

	public List<RecordEntity> getRecords() {
		return records;
	}

	public void setRecords(List<RecordEntity> records) {
		this.records = records;
	}

}
