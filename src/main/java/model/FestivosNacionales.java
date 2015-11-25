package model;

import java.util.Date;

import javax.persistence.*;

@Entity 
@Table(name = "tblfestivosnacionales")
public class FestivosNacionales {
	
	@Id 
    @GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="idTipoFestivo")
	private TipoFestivo idTipoFestivo;
		
	private Date festivo;
	
	@Column(name="comentarioFestivo")
	private String comentarios;
	
	public FestivosNacionales() {
	}

	public FestivosNacionales(TipoFestivo idTipoFestivo, Date festivo,
			String comentarios) {		
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
