/**
 * 
 */
package fr.lavoie.france.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author chrmampu
 *
 */
public class Entites {

	private int id;
	private String nom;
	private String coordonnateur;
	private String assistant;
	private String siege;
	
	public Entites(){
		
	}
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCoordonnateur() {
		return coordonnateur;
	}
	public void setCoordonnateur(String coordonnateur) {
		this.coordonnateur = coordonnateur;
	}
	public String getAssistant() {
		return assistant;
	}
	public void setAssistant(String assistant) {
		this.assistant = assistant;
	}
	public String getSiege() {
		return siege;
	}
	public void setSiege(String siege) {
		this.siege = siege;
	}
	
	
}
