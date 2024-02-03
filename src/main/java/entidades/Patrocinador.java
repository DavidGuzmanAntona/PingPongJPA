package entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Entidad con las características del patrocinador, anotaciones y relaciones
 * incluidas para JPA
 * 
 * @author DavidGuzmán
 * @version 1.0
 * @since 2024-02-03
 */
@Entity
@Table(name = "Sponsor")
public class Patrocinador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdSponsor")
	private Long idPatrocinador;

	@Column(name = "SponsorName")
	private String nombrePatrocinador;

	@Column(name = "MoneySeason")
	private int dineroPatrocinio;

//Relaciones

	@ManyToMany(mappedBy = "patrocinador")
	private List<Equipo> equiposPatrocinados;

//Constructores	
	public Patrocinador() {
	}

	public Patrocinador(String nombrePatrocinador, int dineroPatrocinio) {
		super();
		this.nombrePatrocinador = nombrePatrocinador;
		this.dineroPatrocinio = dineroPatrocinio;
	}

	public Long getIdPatrocinador() {
		return idPatrocinador;
	}

	public void setIdPatrocinador(Long idPatrocinador) {
		this.idPatrocinador = idPatrocinador;
	}

	public String getNombrePatrocinador() {
		return nombrePatrocinador;
	}

	public void setNombrePatrocinador(String nombrePatrocinador) {
		this.nombrePatrocinador = nombrePatrocinador;
	}

	public int getDineroPatrocinio() {
		return dineroPatrocinio;
	}

	public void setDineroPatrocinio(int dineroPatrocinio) {
		this.dineroPatrocinio = dineroPatrocinio;
	}

	public List<Equipo> getEquiposPatrocinados() {
		return equiposPatrocinados;
	}

	public void setEquiposPatrocinados(List<Equipo> equiposPatrocinados) {
		this.equiposPatrocinados = equiposPatrocinados;
	}

}