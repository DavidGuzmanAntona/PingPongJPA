package liga;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import daoImplementacion.EquipoImplementacionDAO;
import daoImplementacion.JugadorImplementacionDAO;
import entidades.Equipo;
import entidades.Jugador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FichajesTemporada {

	private static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("competicion");
	static EntityManager entityManager = factory.createEntityManager();

	static EquipoImplementacionDAO equipoIDAO = new EquipoImplementacionDAO();
	static JugadorImplementacionDAO jugadorIDAO = new JugadorImplementacionDAO();
	
	
	static void intercambiox2(EquipoImplementacionDAO eIDAO, JugadorImplementacionDAO jIDAO) {
		Equipo equipo1 = eIDAO.findById(1);
		Equipo equipo2 = eIDAO.findById(2);
		Jugador jugador1 = jIDAO.findById(1);
		jugador1.setNuevoFichaje(true);
		Jugador jugador2 = jIDAO.findById(6);
		jugador2.setNuevoFichaje(true);
		FichajesTemporada.intercambioJugadores(equipo1, equipo2, jugador1, jugador2);

		Equipo equipo5 = eIDAO.findById(5);
		Equipo equipo6 = eIDAO.findById(6);
		Jugador jugador3 = jIDAO.findById(21);
		jugador3.setNuevoFichaje(true);
		Jugador jugador4 = jIDAO.findById(26);
		jugador4.setNuevoFichaje(true);
		FichajesTemporada.intercambioJugadores(equipo5, equipo6, jugador3, jugador4);
	}
	
	
	static void eliminarx2(JugadorImplementacionDAO jIDAO) {
		Jugador jugadorEliminar = jIDAO.findById(13);
		FichajesTemporada.eliminaJugador(jugadorEliminar);
		
		Jugador jugadorEliminar2 = jIDAO.findById(23);
		FichajesTemporada.eliminaJugador(jugadorEliminar2);
	}
	
	
	
	static void nuevoFichajex2(EquipoImplementacionDAO eIDAO) {
		Jugador nuevoJugador = new Jugador(19107, "LUCIA LOPEZ CUENCA", "ESPAÑOLA",
				LocalDate.parse("01/09/2007", FORMATTER), true);
		Equipo equipoNuevoJugador = eIDAO.findById(3);
		nuevoJugador.setEquipo(equipoNuevoJugador);
		FichajesTemporada.ficharJugador(equipoNuevoJugador, nuevoJugador);

		Jugador nuevoJugador2 = new Jugador(39244, "MARI GRACE BALDWIN", "INGLESA",
				LocalDate.parse("05/06/1998", FORMATTER), true);
		Equipo equipoNuevoJugador2 = eIDAO.findById(4);
		nuevoJugador2.setEquipo(equipoNuevoJugador2);
		FichajesTemporada.ficharJugador(equipoNuevoJugador2, nuevoJugador2);
	}
	
	
	Jugador nuevoJugador = new Jugador(19107, "LUCIA LOPEZ CUENCA",  "ESPAÑOLA", LocalDate.parse("01/09/2010", FORMATTER), true);
	
	public static void ficharJugador(Equipo equipo, Jugador jugadorNuevo) {
	    equipo.getJugadores().add(jugadorNuevo);
	    equipoIDAO.update(equipo);
	}
	
	List <Equipo> equiposEnCompeticion= equipoIDAO.findAll();	
	List<Jugador> jugadoresCompeticion= jugadorIDAO.findAll();
	

	
	public static void intercambioJugadores(Equipo equipo1, Equipo equipo2, Jugador jugador1, Jugador jugador2) {	
		
		

	//Cambio de equipo del jugador
	jugador1.setNuevoFichaje(true);
	jugador1.setEquipo(equipo2);
	jugadorIDAO.update(jugador1);
	
	jugador2.setNuevoFichaje(true);
	jugador2.setEquipo(equipo1);
	jugadorIDAO.update(jugador2);
	
	//Cambio de equipo del jugador
	jugador1.setNuevoFichaje(true);
	jugador1.setEquipo(equipo2);
	jugadorIDAO.update(jugador1);
	
	jugador2.setNuevoFichaje(true);
	jugador2.setEquipo(equipo1);
	jugadorIDAO.update(jugador2);
	
	}
	

	public static void eliminaJugador(Jugador jugador) {
		int identificador= jugador.getIdDeportista();
		jugadorIDAO.delete(identificador);
		
			
		
	}

}
