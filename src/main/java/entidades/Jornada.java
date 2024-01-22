package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Team")
public class Jornada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdPlayday")

	private Long id;
	@Column(name = "PlaydayName")
	private String nombreJornada;

//Relaciones
	@ManyToOne
	@JoinColumn(name = "ID_COMPETICION")
	private Competicion competicion;


	//  @OneToMany(mappedBy = "jornada") private List<Partido> partidos;
	 

	public Jornada() {
		super();
	}

	public Jornada(String nombre) {
		super();
		this.nombreJornada = nombre;
	}

	public String getNombre() {
		return nombreJornada;
	}

	public void setNombre(String nombre) {
		this.nombreJornada = nombre;
	}

	public Competicion getCompeticion() {
		return competicion;
	}

	public void setCompeticion(Competicion competicion) {
		this.competicion = competicion;
	}
	
	

}
