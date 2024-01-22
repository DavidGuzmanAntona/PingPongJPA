package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name= "Competition")
public class Competicion {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdCompetition")
	private Long idCompeticion;
	
	@Column(name = "CName")
	private String nombre;
	
	@Column(name = "CreationDate")
	private LocalDate fechaCreacion;
	
	@Column(name = "NumberOfDays")
	private int numeroJornadas;
	
	@Column(name = "NumberOfTeams")
	private int numeroEquiposParticipantes;
	
//Relaciones
	@OneToMany(mappedBy = "competicion")
	private List<Equipo> equipos;

	@OneToMany(mappedBy = "competicion", cascade = CascadeType.ALL)
    private List<Jornada> jornadas= new ArrayList<Jornada>();
	
//Constructores
public Competicion() {
	super();
}

public Competicion(String nombre, LocalDate fechaCreacion, int numeroJornadas, int numeroEquiposParticipantes) {
	super();
	this.nombre = nombre;
	this.fechaCreacion = fechaCreacion;
	this.numeroJornadas = numeroJornadas;
	this.numeroEquiposParticipantes = numeroEquiposParticipantes;
}

//Getters y Setters

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public LocalDate getFechaCreacion() {
	return fechaCreacion;
}

public void setFechaCreacion(LocalDate fechaCreacion) {
	this.fechaCreacion = fechaCreacion;
}

public int getNumeroJornadas() {
	return numeroJornadas;
}

public void setNumeroJornadas(int numeroJornadas) {
	this.numeroJornadas = numeroJornadas;
}

public int getNumeroEquiposParticipantes() {
	return numeroEquiposParticipantes;
}

public void setNumeroEquiposParticipantes(int numeroEquiposParticipantes) {
	this.numeroEquiposParticipantes = numeroEquiposParticipantes;
}

public List<Equipo> getEquipos() {
	return equipos;
}

public void setEquipos(List<Equipo> equipos) {
	this.equipos = equipos;
	
	for (Equipo equipo : equipos) {
		equipo.setCompeticion(this);
	}
	
}

public Long getIdCompeticion() {
	return idCompeticion;
}
public List<Jornada> getJornadas() {
	return jornadas;
}

public void setJornadas(List<Jornada> jornadas) {
	this.jornadas = jornadas;
}

//toString
@Override
public String toString() {
	return "Competicion [idCompeticion=" + idCompeticion + ", nombre=" + nombre + ", fechaCreacion=" + fechaCreacion
			+ ", numeroJornadas=" + numeroJornadas + ", numeroEquiposParticipantes=" + numeroEquiposParticipantes + "]";
}



	
	
}

