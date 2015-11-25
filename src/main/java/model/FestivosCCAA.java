package model;

import java.util.Date;

import javax.persistence.*;

@Entity 
@Table(name = "tblfestivosccaa")
public class FestivosCCAA {
	
	@Id 
    @GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="idComunidadAutonoma")
	private ComunidadAutonoma idComunidadAutonoma;
	
	@ManyToOne
	@JoinColumn(name="idTipoFestivo")
	private TipoFestivo idTipoFestivo;
	
	private Date festivo;
	
	@Column(name="comentarioFestivo")
	private String comentarios;
	
	public FestivosCCAA() {
	}

	public FestivosCCAA(ComunidadAutonoma idCCAA, TipoFestivo idTipoFestivo, Date festivo,
			String comentarios) {
		this.idComunidadAutonoma = idCCAA;
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
