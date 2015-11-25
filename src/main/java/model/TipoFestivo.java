package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity 
@Table(name = "tbltipofestivo")
public class TipoFestivo {
	
	@Id 
    @GeneratedValue
	private Integer id;
	
	private String tipoFestivo;

	public TipoFestivo() {
	}

	public TipoFestivo(String tipoFestivo) {
		this.tipoFestivo = tipoFestivo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoFestivo() {
		return tipoFestivo;
	}

	public void setTipoFestivo(String tipoFestivo) {
		this.tipoFestivo = tipoFestivo;
	}

}
