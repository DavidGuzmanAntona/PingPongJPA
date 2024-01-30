package liga;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import daoImplementacion.EquipoImplementacionDAO;
import daoImplementacion.JugadorImplementacionDAO;
import entidades.Equipo;
import entidades.Jugador;


public class SimulacionMain {

	private static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static void main(String[] args) {
		
		EquipoImplementacionDAO eIDAO = new EquipoImplementacionDAO();
		JugadorImplementacionDAO jIDAO = new JugadorImplementacionDAO();
		
		
		// Cargar Datos en la BD
		CargarDatos.cargarDatosBD();
		

		// Simulacion Jornada
		
	/*	
		List<Equipo> listaEquipos = eIDAO.findAll();
		System.out.println(listaEquipos.toString());
		SimulacionPartidos.simularJornada(listaEquipos);
	*/	
		
	/*
		//Fichajes		
		Equipo equipo1= eIDAO.findById(1);
		Equipo equipo2= eIDAO.findById(2);
		Jugador Jugador1= jIDAO.findById(1);
		Jugador Jugador2= jIDAO.findById(1);
		
		FichajesTemporada.intercambioJugadores(equipo1, equipo2, Jugador1, Jugador2);
		
		
		Jugador jugadorEliminar= jIDAO.findById(13);
		FichajesTemporada.eliminaJugador(jugadorEliminar);
		
		
		Jugador nuevoJugador = new Jugador(19107, "LUCIA LOPEZ CUENCA",  "ESPAÑOLA", LocalDate.parse("01/09/2010", FORMATTER), true);		
		Equipo equipo= eIDAO.findById(3);
		nuevoJugador.setEquipo(equipo);
		FichajesTemporada.ficharJugador(equipo, nuevoJugador);
		*/
		
	}

}
