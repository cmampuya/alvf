/**
 * 
 */
package fr.lavoie.france.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author chrmampu
 *
 */
@XmlRootElement(name="Disciple")
@Entity
@Table(name="Disciple")
public class Disciple implements Serializable{

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="phone")
	private Integer phone;
	
	@Column(name="birthday")
	private Date birthday;
	
	@Column(name="createdon")
	private Date createdon;
	
	@Column(name="secteur")
	private Long secteur;
	
	@Column(name="rameau")
	private Long rameau;
	
	@Column(name="communion")
	private Long communion;
	
	@Column(name="fonction")
	private String fonction;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="statut")
	private String statut;
	
	@Column(name="adresse")
	private Long adresse;
	
	@Column(name="etat_civil")
	private String etat_civil;
	
	@XmlElement(name="etat_civil")
	public String getEtat_civil() {
		return etat_civil;
	}
	public void setEtat_civil(String etat_civil) {
		this.etat_civil = etat_civil;
	}
	/*@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false, nullable=false)*/
	@Transient
	private Adresse adresses;
	
	//@XmlElement(name="adresse")
	public Adresse getAdresses() {
		return adresses;
	}
	public void setAdresses(Adresse adresses) {
		this.adresses = adresses;
	}
	
	@XmlElement(name="adresse")
	public Long getAdresse() {
		return adresse;
	}
	public void setAdresse(Long adresse) {
		this.adresse = adresse;
	}
	
	@XmlElement(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@XmlElement(name="firstname")
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@XmlElement(name="firstname")
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@XmlElement(name="phone")
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	@XmlElement(name="birthday")
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@XmlElement(name="createdon")
	public Date getCreatedon() {
		return createdon;
	}
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}
	@XmlElement(name="secteur")
	public Long getSecteur() {
		return secteur;
	}
	public void setSecteur(Long secteur) {
		this.secteur = secteur;
	}
	@XmlElement(name="rameau")
	public Long getRameau() {
		return rameau;
	}
	public void setRameau(Long rameau) {
		this.rameau = rameau;
	}
	@XmlElement(name="communion")
	public Long getCommunion() {
		return communion;
	}
	public void setCommunion(Long communion) {
		this.communion = communion;
	}
	@XmlElement(name="fonction")
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	@XmlElement(name="mail")
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@XmlElement(name="statut")
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	
}
