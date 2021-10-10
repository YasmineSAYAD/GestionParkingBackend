package com.formation.parking.dao.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown=true) pour les attributs qu'on utilise pas dans le fichier json
@JsonIgnoreProperties(ignoreUnknown=true)
public class RecordEntity {
	
@JsonProperty(value="fields")	
private FieldsEntity fields;

public FieldsEntity getFields() {
	return fields;
}

public void setFields(FieldsEntity fields) {
	this.fields = fields;
}

}
