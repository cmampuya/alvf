/**
 * 
 */
package fr.lavoie.france.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author chrmampu
 *
 */
@Entity
@Table(name="Adresse")
@XmlRootElement(name="adresse")
public class Adresse {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	@Column(name="numero")
	private Long numero;
	@Column(name="rue")
	private String rue;
	@Column(name="ville")
	private String ville;
	@Column(name="code_postal")
	private int cp;
	@Column(name="complement")
	private String complement;
	@Column(name="pays")
	private String pays;
	
	@XmlElement(name="pays")
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	@XmlElement(name="id")
	public Long getAdresse_id() {
		return id;
	}
	public void setAdresse_id(Long id) {
		this.id = id;
	}
	@XmlElement(name="numero")
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	@XmlElement(name="rue")
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	@XmlElement(name="ville")
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	@XmlElement(name="cp")
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	@XmlElement(name="complement")
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	
	
}
