package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**Entidad con las características del Estadio, anotaciones y relaciones incluidas para JPA
 * @author DavidGuzmán
 * @version 1.0
 * @since 2024-02-03
 */


@Entity
@Table(name = "stadium")
public class Estadio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdStadium")
	private Long idEstadio;

	@Column(name = "name")
	private String nombre;

	@Column(name = "location")
	private String ubicacion;

	@Column(name = "capacity")
	private int capacidad;

//relaciones

	@OneToOne
	@JoinColumn(name = "equipo_id")
	private Equipo equipo;

//Constructores	
	public Estadio() {
		super();
	}

	public Estadio(String nombre, String ubicacion, int capacidad) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.capacidad = capacidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Long getIdEstadio() {
		return idEstadio;
	}

	@Override
	public String toString() {
		return "Estadio [idEstadio=" + idEstadio + ", nombre=" + nombre + ", ubicacion=" + ubicacion + ", capacidad="
				+ capacidad + "]";
	}
	
	
	

}
