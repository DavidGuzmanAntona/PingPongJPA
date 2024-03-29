package entidades;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 * Entidad con las caracter�sticas del Jugador, anotaciones y relaciones
 * incluidas para JPA
 * 
 * @author DavidGuzm�n
 * @version 1.0
 * @since 2024-02-03
 */

@Entity
@Table(name = "Player")
@NamedQuery(name = "Jugador.findNuevosFichajes", query = "SELECT j FROM Jugador j WHERE j.nuevoJugadorEnCompeticion = true")

public class Jugador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdPlayer")
	private int idDeportista;

	@Column(name = "License")
	private int licencia;

	@Column(name = "Name")
	private String nombre;

	@Column(name = "Nationality")
	private String nacionalidad;

	@Column(name = "BirthDate")
	private LocalDate edad;

	@Column(name = "NewPlayer24")
	private boolean nuevoFichaje;

	@Column(name = "NewPlayerInCompetition")
	private boolean nuevoJugadorEnCompeticion;

//Relaciones

	@ManyToOne
	@JoinColumn(name = "ID_EQUIPO")
	private Equipo equipo;

//Constructores

	public Jugador() {
		super();
	}

	public Jugador(int licencia, String nombre, String nacionalidad, LocalDate edad, boolean nuevoFichaje,
			boolean nuevoJugadorEnCompeticion) {
		super();
		this.licencia = licencia;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.edad = edad;
		this.nuevoFichaje = nuevoFichaje;
		this.nuevoJugadorEnCompeticion = nuevoJugadorEnCompeticion;
	}

	// Getters y Setters

	public int getLicencia() {
		return licencia;
	}

	public void setLicencia(int licencia) {
		this.licencia = licencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public LocalDate getEdad() {
		return edad;
	}

	public void setEdad(LocalDate edad) {
		this.edad = edad;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public int getIdDeportista() {
		return idDeportista;
	}

	public boolean isNuevoFichaje() {
		return nuevoFichaje;
	}

	public void setNuevoFichaje(boolean nuevoFichaje) {
		this.nuevoFichaje = nuevoFichaje;
	}

	public boolean isNuevoJugadorEnCompeticion() {
		return nuevoJugadorEnCompeticion;
	}

	public void setNuevoJugadorEnCompeticion(boolean nuevoJugadorEnCompeticion) {
		this.nuevoJugadorEnCompeticion = nuevoJugadorEnCompeticion;
	}

//To String	
	@Override
	public String toString() {
		return "Jugador [idDeportista=" + idDeportista + ", licencia=" + licencia + ", nombre=" + nombre
				+ ", nacionalidad=" + nacionalidad + ", edad=" + edad + "]";
	}

}