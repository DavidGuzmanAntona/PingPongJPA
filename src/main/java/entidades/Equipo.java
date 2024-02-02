package entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Team")
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdClub")
	private int idClub;

	@Column(name = "TeamName")
	private String nombre;

	@Column(name = "City")
	private String poblacion;

	@Column(name = "PostalCode")
	private int codigoPostal;

	@Column(name = "BallType")
	private String pelota;

	@Column(name = "TableType")
	private String mesa;

	@Column(name = "TotalMatches")
	private int partidosJugados;

	@Column(name = "matchWins")
	private int partidosGanados = 0;

	@Column(name = "matchLose")
	private int partidosPerdidos = 0;

	@Column(name = "matchDraw")
	private int partidosEmpatados = 0;

	@Column(name = "TotalPoints")
	private int puntosLiga= 0;

//Relaciones
	@OneToOne(mappedBy = "equipo", cascade = CascadeType.ALL)
	private Estadio estadio;

	@OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
	private List<Jugador> jugadores = new ArrayList<Jugador>();

	@ManyToOne
	@JoinColumn(name = "competicion_id")
	private Competicion competicion;

	@ManyToMany
	@JoinTable(name = "team_sponsor", joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name = "sponsor_id"))
	private List<Patrocinador> patrocinador = new ArrayList<Patrocinador>();

//Constructores
	public Equipo() {
	}

	public Equipo(String nombre, String poblacion, int codigoPostal, String pelota, String mesa, Estadio estadio) {
		super();
		this.nombre = nombre;
		this.poblacion = poblacion;
		this.codigoPostal = codigoPostal;
		this.pelota = pelota;
		this.mesa = mesa;
		this.estadio = estadio;
	}

// Getters y Setters	

	public int getIdClub() {
		return idClub;
	}

	public void setIdClub(int idClub) {
		this.idClub = idClub;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getPelota() {
		return pelota;
	}

	public void setPelota(String pelota) {
		this.pelota = pelota;
	}

	public String getMesa() {
		return mesa;
	}

	public void setMesa(String mesa) {
		this.mesa = mesa;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;

		for (Jugador jugador : jugadores) {
			jugador.setEquipo(this);
		}
	}

	public Competicion getCompeticion() {
		return competicion;
	}

	public void setCompeticion(Competicion competicion) {
		this.competicion = competicion;
	}

	public List<Patrocinador> getPatrocinador() {
		return patrocinador;
	}

	public void setPatrocinador(List<Patrocinador> patrocinador) {
		this.patrocinador = patrocinador;
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}
	
	public int getPartidosJugados() {
		return partidosJugados;
	}

	public void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}

	public int getPartidosGanados() {
		return partidosGanados;
	}

	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}

	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}

	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}

	public int getPartidosEmpatados() {
		return partidosEmpatados;
	}

	public void setPartidosEmpatados(int partidosEmpatados) {
		this.partidosEmpatados = partidosEmpatados;
	}

	public int getPuntosLiga() {
		return puntosLiga;
	}

	public void setPuntosLiga(int puntosLiga) {
		this.puntosLiga = puntosLiga;
	}
	

//To String
	@Override
	public String toString() {
		return "Equipo [idClub=" + idClub + ", nombre=" + nombre + ", poblacion=" + poblacion + ", codigoPostal="
				+ codigoPostal + ", pelota=" + pelota + ", mesa=" + mesa + ", partidosJugados=" + partidosJugados
				+ ", partidosGanados=" + partidosGanados + ", partidosPerdidos=" + partidosPerdidos
				+ ", partidosEmpatados=" + partidosEmpatados + ", puntosLiga=" + puntosLiga + "]";
	}

//metodos de clase
	public void sumarVictoria() {
		partidosGanados++;

	}

	public void sumarEmpate() {
		partidosEmpatados++;

	}

	public void sumarDerrota() {
		partidosPerdidos++;

	}

	public void sumarPartidos() {
		partidosJugados++;
		
	}

	public void sumarPuntos(int puntos) {
		puntosLiga+=puntos;
		
	}



}