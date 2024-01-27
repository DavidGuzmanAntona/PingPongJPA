package entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Jornada")
public class Jornada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idJornada")
	private int idJornada;

	@Column(name = "JName")
	private String nombreJornada;

	public Jornada() {
		super();
	}

	public Jornada(String nombreJornada) {
		super();
		this.nombreJornada = nombreJornada;

	}

	// Relaciones
	@ManyToOne
	@JoinColumn(name = "ID_COMPETICION")
	private Competicion competicion;

//getters Setters
	public String getNombreJornada() {
		return nombreJornada;
	}

	public void setNombreJornada(String nombreJornada) {
		this.nombreJornada = nombreJornada;
	}

	public Competicion getCompeticion() {
		return competicion;
	}

	public void setCompeticion(Competicion competicion) {
		this.competicion = competicion;
	}

	public int getIdJornada() {
		return idJornada;
	}

}
