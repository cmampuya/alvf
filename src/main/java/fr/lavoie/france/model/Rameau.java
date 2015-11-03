/**
 * 
 */
package fr.lavoie.france.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author chrmampu
 *
 */
@Entity
@Table(name="Rameau")
@XmlRootElement(name="Rameau")
public class Rameau /*extends Entites*/ {


	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	@Column(name="nom")
	private String nom;
	@Column(name="coordonnateur")
	private Long coordonnateur;
	@Column(name="assistant")
	private Long assistant;
	@Column(name="siege")
	private Long siege;
	@Column(name="secteur")
	private Long idsecteur;
	@Column(name="createdOn")
	private Date createdon;
	@Transient
	private Adresse adresses;
	
	//@XmlElement(name="adresse")
	public Adresse getAdresses() {
		return adresses;
	}
	public void setAdresses(Adresse adresses) {
		this.adresses = adresses;
	}
	@XmlElement(name="createdon")
	public Date getCreatedon() {
		return createdon;
	}
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}
	@XmlElement(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@XmlElement(name="nom")
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@XmlElement(name="coordonnateur")
	public Long getCoordonnateur() {
		return coordonnateur;
	}
	public void setCoordonnateur(Long coordonnateur) {
		this.coordonnateur = coordonnateur;
	}
	@XmlElement(name="assistant")
	public Long getAssistant() {
		return assistant;
	}
	public void setAssistant(Long assistant) {
		this.assistant = assistant;
	}
	@XmlElement(name="siege")
	public Long getSiege() {
		return siege;
	}
	public void setSiege(Long siege) {
		this.siege = siege;
	}
	@XmlElement(name="secteur")
	public Long getIdrameau() {
		return idsecteur;
	}
	public void setIdrameau(Long idsecteur) {
		this.idsecteur = idsecteur;
	}
}
