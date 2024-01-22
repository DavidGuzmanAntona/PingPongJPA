package liga;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import entidades.Competicion;
import entidades.Equipo;
import entidades.Jugador;
import entidades.Patrocinador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SimulacionMain {
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static void main(String[] args) {
		
		Competicion competicion1 = new Competicion("Liga Veteranos Tenis de Mesa", LocalDate.parse("01/02/1980", FORMATTER), 4, 5);
				
		Equipo equipo1 = new Equipo("Pacos", "Madrid", 28039, "p1", "t1");
		Equipo equipo2 = new Equipo("Lemures", "Madrid", 28360, "p1", "t1");
		
		Patrocinador Patrocinador1 = new Patrocinador("CocaCola", 2000);
		Patrocinador Patrocinador2 = new Patrocinador("PriscoMovile", 600);
		Patrocinador Patrocinador3 = new Patrocinador("L'escala Empúries", 1200);
		
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = factory.createEntityManager();
		
		
		equipo1.setCompeticion(competicion1);	
		equipo2.setCompeticion(competicion1);
		
		equipo1.setJugadores(List.of(
				new Jugador(12345, "David", "Español", LocalDate.parse("01/09/2012", FORMATTER)),
				new Jugador(12355, "Dulce", "Español", LocalDate.parse("01/09/2010", FORMATTER))
				));
		
		
		List<Patrocinador> patrocinio1 = List.of(Patrocinador1, Patrocinador2);
		List<Patrocinador> patrocinio2 = List.of(Patrocinador3);
		
		equipo1.setPatrocinador(patrocinio1);
		equipo2.setPatrocinador(patrocinio2);
		 
		entityManager.getTransaction().begin();
		entityManager.persist(Patrocinador1);
		entityManager.persist(Patrocinador2);
		entityManager.persist(Patrocinador3);
		entityManager.persist(competicion1);
		entityManager.persist(equipo1);
		entityManager.persist(equipo2);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
				
	}

}
