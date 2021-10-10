package com.formation.parking.dao.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown=true) pour les attributs qu'on utilise pas dans le fichier json
@JsonIgnoreProperties(ignoreUnknown=true)
public class FieldsEntity {
	@JsonProperty(value="idobj")
	private String idobj;
	@JsonProperty(value="grp_nom")
	private String grp_nom;
	@JsonProperty(value="grp_disponible")
	private int grp_disponible;
	@JsonProperty(value="grp_exploitation")
	private int grp_exploitation;
	@JsonProperty(value="grp_statut")
	private String  grp_statut;
	@JsonProperty(value="grp_horodatage")
	private String grp_horodatage;
	
	public String getIdobj() {
		return idobj;
	}
	public void setIdobj(String idobj) {
		this.idobj = idobj;
	}
	public String getGrp_nom() {
		return grp_nom;
	}
	public void setGrp_nom(String grp_nom) {
		this.grp_nom = grp_nom;
	}
	public int getGrp_disponible() {
		return grp_disponible;
	}
	public void setGrp_disponible(int grp_disponible) {
		this.grp_disponible = grp_disponible;
	}
	public int getGrp_exploitation() {
		return grp_exploitation;
	}
	public void setGrp_exploitation(int grp_exploitation) {
		this.grp_exploitation = grp_exploitation;
	}
	public String  getGrp_statut() {
		return grp_statut;
	}
	public void setGrp_statut(String  grp_statut) {
		this.grp_statut = grp_statut;
	}
	public String getGrp_horodatage() {
		return grp_horodatage;
	}
	public void setGrp_horodatage(String grp_horodatage) {
		this.grp_horodatage = grp_horodatage;
	}
	
}
