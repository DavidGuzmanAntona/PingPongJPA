package entidades;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Player")

public class Jugador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdPlayer")
	private Long idDeportista;

	@Column(name = "License")
	private int licencia;

	@Column(name = "Name")
	private String nombre;

	@Column(name = "Nationality")
	private String nacionalidad;

	@Column(name = "BirthDate")
	private LocalDate edad;
	
	@Column(name= "NewPlayer24")
	private boolean nuevoFichaje;

//Relaciones

	@ManyToOne
	@JoinColumn(name = "ID_EQUIPO")
	private Equipo equipo;

	public Jugador() {
		super();
	}
	
	public Jugador(int licencia, String nombre, String nacionalidad, LocalDate edad, boolean nuevoFichaje) {
		super();
		this.licencia = licencia;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.edad = edad;
		this.nuevoFichaje = nuevoFichaje;
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

	public Long getIdDeportista() {
		return idDeportista;
	}
	
	public boolean isNuevoFichaje() {
		return nuevoFichaje;
	}

	public void setNuevoFichaje(boolean nuevoFichaje) {
		this.nuevoFichaje = nuevoFichaje;
	}

	
	
//To String	
	@Override
	public String toString() {
		return "Jugador [idDeportista=" + idDeportista + ", licencia=" + licencia + ", nombre=" + nombre
				+ ", nacionalidad=" + nacionalidad + ", edad=" + edad + "]";
	}


	

}