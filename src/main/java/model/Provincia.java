package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "tblprovincias")
public class Provincia {
	
	@Id 
    @GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="idComunidadAutonoma")
	private ComunidadAutonoma idComunidadAutonoma;

	private String provincia;
	
	public Provincia() {
	}

	public Provincia(String provincia) {
		this.setProvincia(provincia);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public ComunidadAutonoma getIdComunidadAutonoma() {
		return idComunidadAutonoma;
	}

	public void setIdComunidadAutonoma(ComunidadAutonoma idComunidadAutonoma) {
		this.idComunidadAutonoma = idComunidadAutonoma;
	}
	
	

}
