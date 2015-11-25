package model;

import java.util.Date;

import javax.persistence.*;

@Entity 
@Table(name = "tblfestivos")
public class Festivos {
	
	@Id 
    @GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="idComunidadAutonoma")
	private ComunidadAutonoma idComunidadAutonoma;
	
	@ManyToOne
	@JoinColumn(name="idProvincia")
	private Provincia idProvincia;
	
	@ManyToOne
	@JoinColumn(name="idLocalidad")
	private Localidad idLocalidad;
	
	@ManyToOne
	@JoinColumn(name="idTipoFestivo")
	private TipoFestivo idTipoFestivo;
	
	private Date festivo;
	
	@Column(name="comentarioFestivo")
	private String comentarios;
	
	public Festivos() {
	}

	public Festivos(ComunidadAutonoma idCCAA, Provincia idProvincia,
			Localidad idMunicipio, TipoFestivo idTipoFestivo, Date festivo,
			String comentarios) {
		this.idComunidadAutonoma = idCCAA;
		this.idProvincia = idProvincia;
		this.idLocalidad = idMunicipio;
		this.idTipoFestivo = idTipoFestivo;
		this.festivo = festivo;
		this.comentarios = comentarios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ComunidadAutonoma getIdCCAA() {
		return idComunidadAutonoma;
	}

	public void setIdCCAA(ComunidadAutonoma idCCAA) {
		this.idComunidadAutonoma = idCCAA;
	}

	public Provincia getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Provincia idProvincia) {
		this.idProvincia = idProvincia;
	}

	public Localidad getIdMunicipio() {
		return idLocalidad;
	}

	public void setIdMunicipio(Localidad idMunicipio) {
		this.idLocalidad = idMunicipio;
	}

	public TipoFestivo getIdTipoFestivo() {
		return idTipoFestivo;
	}

	public void setIdTipoFestivo(TipoFestivo idTipoFestivo) {
		this.idTipoFestivo = idTipoFestivo;
	}

	public Date getFestivo() {
		return festivo;
	}

	public void setFestivo(Date festivo) {
		this.festivo = festivo;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
}
