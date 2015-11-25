package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "tblcomunidadesautonomas")
public class ComunidadAutonoma {

	@Id 
    @GeneratedValue
	private Integer id;
	
	private String comunidadAutonoma;
	
	public ComunidadAutonoma() {
	}

	public ComunidadAutonoma(String comunidadAutonoma) {
		this.setComunidadAutonoma(comunidadAutonoma);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComunidadAutonoma() {
		return comunidadAutonoma;
	}

	public void setComunidadAutonoma(String comunidadAutonoma) {
		this.comunidadAutonoma = comunidadAutonoma;
	}
	
	
}
