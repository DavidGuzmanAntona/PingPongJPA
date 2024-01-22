package liga;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import entidades.Competicion;
import entidades.Equipo;
import entidades.Jornada;
import entidades.Jugador;
import entidades.Partido;
import entidades.Patrocinador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SimulacionMain {
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static void main(String[] args) {
		
		
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = factory.createEntityManager();
		
	//Crear Competicion
		
		Competicion competicion1 = new Competicion("Liga Veteranos Tenis de Mesa", LocalDate.parse("01/02/1980", FORMATTER), 4, 5);
		entityManager.persist(competicion1);	
		entityManager.getTransaction().begin();
		
	//Crear Equipos
		Equipo equipo1 = new Equipo("Pacos", "Madrid", 28039, "p1", "t1");
		Equipo equipo2 = new Equipo("Lemures", "Barcelona", 28360, "p1", "t1");
		Equipo equipo3 = new Equipo("Navidades", "Sevilla", 3639, "p1", "t1");
		Equipo equipo4 = new Equipo("Amigos", "Cadiz", 29360, "p2", "t1");
		Equipo equipo5 = new Equipo("Locos", "Badajoz", 23139, "p2", "t1");

		entityManager.persist(equipo1);
		entityManager.persist(equipo2);
		entityManager.persist(equipo3);
		entityManager.persist(equipo4);
		entityManager.persist(equipo5);
		
	//Asignar competicion a equipos
		equipo1.setCompeticion(competicion1);	
		equipo2.setCompeticion(competicion1);
		equipo3.setCompeticion(competicion1);	
		equipo4.setCompeticion(competicion1);
		equipo5.setCompeticion(competicion1);

	// Crear jugadores y asignarlos a los equipos 	
		
		equipo1.setJugadores(List.of(
				new Jugador(12345, "David", "Español", LocalDate.parse("01/09/2012", FORMATTER)),
				new Jugador(12355, "Dulce2", "Español", LocalDate.parse("01/09/2010", FORMATTER)),
				new Jugador(12365, "David3", "Español", LocalDate.parse("01/09/2009", FORMATTER)),
				new Jugador(12375, "David4", "Español", LocalDate.parse("01/09/2008", FORMATTER)),
				new Jugador(12385, "David5", "Español", LocalDate.parse("01/09/2007", FORMATTER))
				));		
		equipo2.setJugadores(List.of(
				new Jugador(12395, "David6", "Español", LocalDate.parse("01/09/2012", FORMATTER)),
				new Jugador(12396, "Dulce7", "Español", LocalDate.parse("01/09/2010", FORMATTER)),
				new Jugador(12397, "David8", "Español", LocalDate.parse("01/09/2009", FORMATTER)),
				new Jugador(12398, "David9", "Español", LocalDate.parse("01/09/2008", FORMATTER)),
				new Jugador(12399, "David10", "Español", LocalDate.parse("01/09/2007", FORMATTER))
				));
		equipo3.setJugadores(List.of(
				new Jugador(12395, "David6", "Español", LocalDate.parse("01/09/2012", FORMATTER)),
				new Jugador(12396, "Dulce7", "Español", LocalDate.parse("01/09/2010", FORMATTER)),
				new Jugador(12397, "David8", "Español", LocalDate.parse("01/09/2009", FORMATTER)),
				new Jugador(12398, "David9", "Español", LocalDate.parse("01/09/2008", FORMATTER)),
				new Jugador(12399, "David10", "Español", LocalDate.parse("01/09/2007", FORMATTER))
				));
		equipo4.setJugadores(List.of(
				new Jugador(12395, "David6", "Español", LocalDate.parse("01/09/2012", FORMATTER)),
				new Jugador(12396, "Dulce7", "Español", LocalDate.parse("01/09/2010", FORMATTER)),
				new Jugador(12397, "David8", "Español", LocalDate.parse("01/09/2009", FORMATTER)),
				new Jugador(12398, "David9", "Español", LocalDate.parse("01/09/2008", FORMATTER)),
				new Jugador(12399, "David10", "Español", LocalDate.parse("01/09/2007", FORMATTER))
				));
		equipo5.setJugadores(List.of(
				new Jugador(12395, "David6", "Español", LocalDate.parse("01/09/2012", FORMATTER)),
				new Jugador(12396, "Dulce7", "Español", LocalDate.parse("01/09/2010", FORMATTER)),
				new Jugador(12397, "David8", "Español", LocalDate.parse("01/09/2009", FORMATTER)),
				new Jugador(12398, "David9", "Español", LocalDate.parse("01/09/2008", FORMATTER)),
				new Jugador(12399, "David10", "Español", LocalDate.parse("01/09/2007", FORMATTER))
				));
		
	//Crear Patrocinadores
		
		Patrocinador Patrocinador1 = new Patrocinador("CocaCola", 2000);
		Patrocinador Patrocinador2 = new Patrocinador("PriscoMovile", 600);
		Patrocinador Patrocinador3 = new Patrocinador("L'escala Empúries", 1200);
		Patrocinador Patrocinador4 = new Patrocinador("Anguriñas", 3000);
		Patrocinador Patrocinador5 = new Patrocinador("Burguer King", 3100);
		
		entityManager.persist(Patrocinador1);
		entityManager.persist(Patrocinador2);
		entityManager.persist(Patrocinador3);
		entityManager.persist(Patrocinador4);
		entityManager.persist(Patrocinador5);
				
		List<Patrocinador> patrocinio1 = List.of(Patrocinador1, Patrocinador2);
		List<Patrocinador> patrocinio2 = List.of(Patrocinador3);
		List<Patrocinador> patrocinio3 = List.of(Patrocinador3,Patrocinador1 );
		List<Patrocinador> patrocinio4 = List.of(Patrocinador4, Patrocinador2);
		List<Patrocinador> patrocinio5 = List.of(Patrocinador4, Patrocinador5);
		
		equipo1.setPatrocinador(patrocinio1);
		equipo2.setPatrocinador(patrocinio2);
		equipo3.setPatrocinador(patrocinio3);
		equipo4.setPatrocinador(patrocinio4);
		equipo5.setPatrocinador(patrocinio5);
		
		// Crear una jornada
        Jornada jornada1 = new Jornada("Primera Jornada");
        jornada1.setCompeticion(competicion1);
        entityManager.persist(jornada1);
        
     // Crear partidos para la jornada
        crearPartido(entityManager, jornada1, equipo1, equipo2);
        crearPartido(entityManager, jornada1, equipo3, equipo4);
        crearPartido(entityManager, jornada1, equipo2, equipo5);
        crearPartido(entityManager, jornada1, equipo4, equipo1);
        crearPartido(entityManager, jornada1, equipo5, equipo3);

		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
				
	}
	
	private static void crearPartido(EntityManager em, Jornada jornada, Equipo equipoLocal, Equipo equipoVisitante) {
        Partido partido = new Partido();
        partido.setEquipoLocal(equipoLocal);
        partido.setEquipoVisitante(equipoVisitante);
        partido.setJornada(jornada);
        partido.setResultado(equipoVisitante.getNombre());

        em.persist(partido);
    }

}
