package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "tbllocalidades")
public class Localidad {
	
	@Id 
    @GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="idProvincia")
	private Provincia idProvincia;

	private String localidad;
	
	public Localidad() {
	}

	public Localidad(String municipio) {
		this.localidad = municipio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String municipio) {
		this.localidad = municipio;
	}

	public Provincia getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Provincia idProvincia) {
		this.idProvincia = idProvincia;
	}

}
