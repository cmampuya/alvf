/**
 * 
 */
package fr.lavoie.france.model;

import java.util.Date;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author chrmampu
 *
 */
@XmlRootElement(name="annonce")
public class Annonce {

	@XmlElement(name="id")
	private int id;
	@XmlElement(name="titre")
	private String titre;
	@XmlElement(name="description")
	private String description;
	@XmlElement(name="entite")
	private String entite;
	@Column(name="createdOn")
	private Date createdon;
	
	@XmlElement(name="createdon")
	public Date getCreatedon() {
		return createdon;
	}
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEntite() {
		return entite;
	}
	public void setEntite(String entite) {
		this.entite = entite;
	}
	
	
}
