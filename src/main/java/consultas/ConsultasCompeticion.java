package consultas;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import entidades.Competicion;
import entidades.Equipo;
import entidades.Jugador;
import entidades.Patrocinador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import liga.SimulacionMain;

public class ConsultasCompeticion {

	public static void consulta1() {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		Query query = entityManager.createNativeQuery("SELECT * FROM competition WHERE IdCompetition = :competicionId",
				Competicion.class);
		query.setParameter("competicionId", 1);
		Competicion competicion = (Competicion) query.getSingleResult();
		System.out.println(
				"## 1. Utiliza una consulta nativa(NativeQuery) para obtener las características de la competición. ##");
		System.out.println(competicion.toString());
		System.out.println("##################### FIN Consulta 1 #################################");

	}

	public static void consulta2() {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		Query query = entityManager.createQuery("SELECT e FROM Equipo e WHERE e.competicion.id = :competicionId",
				Equipo.class);
		query.setParameter("competicionId", 1);
		List<Equipo> equipos = query.getResultList();
		System.out.println("## 2. Consulta y recupera todos los equipos participantes en la competición.. ##");
		for (Equipo equipo : equipos) {
			System.out.println("Nombre Equipo: " + equipo.getNombre());
		}
		System.out.println("##################### FIN Consulta 2 #################################");
	}

	public static void consulta3(String nombreEquipo) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		Query query = entityManager.createQuery("SELECT j FROM Jugador j WHERE j.equipo.nombre = :nombreE",
				Jugador.class);
		query.setParameter("nombreE", nombreEquipo);
		List<Jugador> jugadores = query.getResultList();
		System.out.println("## 3. Obtén la lista de todos los deportistas de un equipo específico. ##");
		System.out.println("Los jugadores del equipo: " + nombreEquipo);
		for (Jugador jugador : jugadores) {
			System.out.println("Nombre: " + jugador.getNombre());
		}
		System.out.println("##################### FIN Consulta 3 #################################");
	}

	public static void consulta4(String nombreEquipo) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		Query query = entityManager.createQuery(
				"SELECT p FROM Patrocinador p JOIN p.equiposPatrocinados e WHERE e.nombre = :nombreE",
				Patrocinador.class);
		query.setParameter("nombreE", nombreEquipo);
		List<Patrocinador> patrocinadores = query.getResultList();
		System.out.println("## 4. Identifica y lista todos los patrocinadores asociados a un equipo concreto. ##");
		System.out.println("Patrocinadores del equipo " + nombreEquipo);
		for (Patrocinador patrocinador : patrocinadores) {
			System.out.println("- " + patrocinador.getNombrePatrocinador());
		}
		System.out.println("##################### FIN Consulta 4 #################################");
	}

	public static void consulta5(String nombreEquipo) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		Query query = entityManager.createQuery(
				"SELECT j, p FROM Jugador j JOIN j.equipo e JOIN e.patrocinador p WHERE e.nombre = :nombreE");
		query.setParameter("nombreE", nombreEquipo);
		List<Object[]> resultados = query.getResultList();
		System.out.println(
				"## 5. Genera una lista de deportistas y patrocinadores vinculados a un equipo específico. ##");
		System.out.println("Deportistas y patrocinadores asociados al equipo " + nombreEquipo);
		for (Object[] resultado : resultados) {
			Jugador jugador = (Jugador) resultado[0];
			Patrocinador patrocinador = (Patrocinador) resultado[1];
			System.out.println(
					"- Deportista: " + jugador.getNombre() + ", Patrocinador: " + patrocinador.getNombrePatrocinador());
		}
		System.out.println("##################### FIN Consulta 5 #################################");
	}

	public static void consulta6(String nombreEquipo) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		Query query = entityManager.createQuery("SELECT j FROM Jugador j WHERE j.equipo.nombre = :equipoNombre",
				Jugador.class);
		query.setParameter("equipoNombre", nombreEquipo);
		List<Jugador> jugadores = query.getResultList();

		int totalEdad = 0;
		for (Jugador jugador : jugadores) {
			LocalDate fechaNacimiento = jugador.getEdad();
			LocalDate fechaActual = LocalDate.now();
			int edad = Period.between(fechaNacimiento, fechaActual).getYears();
			totalEdad += edad;
		}
		double edadPromedio = (double) totalEdad / jugadores.size();
		System.out.println("## 6. Calcula y presenta la edad promedio de los deportistas de un equipo determinado. ##");
		System.out.println("Edad media de los jugadores del quipo: " + nombreEquipo + "= " + edadPromedio + " años");
		System.out.println("##################### FIN Consulta 6 #################################");
	}

	public static void consulta7() {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		Query query = entityManager.createQuery(
				"SELECT d.nacionalidad, COUNT(d) FROM Jugador d WHERE FUNCTION('DATEDIFF', CURRENT_DATE(), d.edad) / 365 > 23 GROUP BY d.nacionalidad");
		List<Object[]> resultados = query.getResultList();
		System.out.println(
				"## 7. Cuenta cuantos deportistas tienen más de veintitrés años en la competición agrupados por nacionalidad. ##");
		for (Object[] resultado : resultados) {
			String nacionalidad = (String) resultado[0];
			long cantidadDeportistas = (long) resultado[1];
			System.out.println("Nacionalidad: " + nacionalidad + ", Cantidad: " + cantidadDeportistas);
		}
		System.out.println("##################### FIN Consulta 7 #################################");
	}

	public static void consulta8() {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		Query query = entityManager.createQuery("SELECT e FROM Equipo e ORDER BY e.puntosLiga DESC", Equipo.class);
		List<Equipo> equipos = query.getResultList();
		System.out.println("## 8. Visualiza la clasificación al inicio, a mitad de temporada y al final de esta. ##");
		System.out.println("Al final de la liga, la clasificacion es:");
		for (Equipo equipo : equipos) {
			System.out.println("- Equipo: " + equipo.getNombre() + ", Puntos de liga: " + equipo.getPuntosLiga());
		}
		System.out.println("##################### FIN Consulta 8 #################################");
	}

	public static void consulta9() {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		Query queryMasPuntos = entityManager.createQuery("SELECT e FROM Equipo e ORDER BY e.puntosLiga DESC",
				Equipo.class);
		queryMasPuntos.setMaxResults(3);
		List<Equipo> equiposMasPuntos = queryMasPuntos.getResultList();

		Query queryMenosPuntos = entityManager.createQuery("SELECT e FROM Equipo e ORDER BY e.puntosLiga ASC",
				Equipo.class);
		queryMenosPuntos.setMaxResults(3);
		List<Equipo> equiposMenosPuntos = queryMenosPuntos.getResultList();

		System.out.println("## 9. Determina y muestra los tres equipos con más puntos y los tres con menos. ##");

		System.out.println("Tres equipos con más puntos:");
		for (Equipo equipo : equiposMasPuntos) {
			System.out.println("Nombre: " + equipo.getNombre() + ", Puntos: " + equipo.getPuntosLiga());
		}

		System.out.println("\nTres equipos con menos puntos:");
		for (Equipo equipo : equiposMenosPuntos) {
			System.out.println("Nombre: " + equipo.getNombre() + ", Puntos: " + equipo.getPuntosLiga());
		}

		System.out.println("##################### FIN Consulta 9 #################################");
	}

	public static void consulta10() {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		Query query = entityManager.createNamedQuery("Jugador.findNuevosFichajes", Jugador.class);
		List<Jugador> nuevosFichajes = query.getResultList();
		System.out.println("## 10. Muestra las nuevas incorporaciones a la competición(utiliza una NamedQuery). ##");
		System.out.println();
		for (Jugador jugador : nuevosFichajes) {
			System.out.println("Nombre: " + jugador.getNombre());
		}
		System.out.println("##################### FIN Consulta 10 #################################");
	}

	public static void consulta11() {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();

		Query query = entityManager.createQuery("SELECT j FROM Jugador j WHERE j.nuevoFichaje = :nuevo", Jugador.class);
		query.setParameter("nuevo", true);
		List<Jugador> nuevosCompeticion = query.getResultList();
		System.out.println("## 10. Enumera todos los fichajes realizados entre los diferentes equipos. ##");
		for (Jugador jugador : nuevosCompeticion) {
			System.out.println("Nombre: " + jugador.getNombre());		
		}
		System.out.println("##################### FIN Consulta 11 #################################");
	}

	public static void consulta12() {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		Query query = entityManager.createQuery("SELECT COUNT(j) FROM Jugador j");
		Long totalDeportistas = (Long) query.getSingleResult();
		System.out.println("## 12. Realiza un recuento del total de deportistas que participan en la competición. ##");
		System.out.println("Total de deportistas que participan en la competición: " + totalDeportistas);
		System.out.println("##################### FIN Consulta 12 #################################");
	}

	public static void consulta13(String equipo1, String equipo2) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		String jpql = "SELECT p FROM Patrocinador p " + "JOIN p.equiposPatrocinados e " + "WHERE e.nombre = :nombre1 "
				+ "AND EXISTS (SELECT 1 FROM Patrocinador p2 " + "JOIN p2.equiposPatrocinados e2 "
				+ "WHERE e2.nombre = :nombre2 " + "AND p2 = p)";
		Query query = entityManager.createQuery(jpql, Patrocinador.class);
		query.setParameter("nombre1", equipo1);
		query.setParameter("nombre2", equipo2);
		List<Patrocinador> patrocinadoresComunes = query.getResultList();
		System.out.println("## 13. Dado dos equipos muestra sus patrocinadores comunes. ##");
		System.out.println("Patrocinadores comunes entre los equipos " + equipo1 + " y " + equipo2 + ":");
		for (Patrocinador patrocinador : patrocinadoresComunes) {
			System.out.println("- " + patrocinador.getNombrePatrocinador());
		}
		System.out.println("##################### FIN Consulta 13 #################################");

	}

	public static void consulta14() {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();

		Query query = entityManager.createQuery("SELECT j FROM Jugador j WHERE j.nuevoJugadorEnCompeticion = :nuevo", Jugador.class);
		query.setParameter("nuevo", true);
		List<Jugador> nuevosCompeticion = query.getResultList();
		for (Jugador jugador : nuevosCompeticion) {
			System.out.println("Nombre: " + jugador.getNombre());
		}
		System.out.println("## 14. Utiliza CriteriaQuery para poder filtrar por todos los atributos de los deportistas, edad, nombre, equipo, etc ordenados por un criterio. Lanza tres ejemplos distintos con diferentes atributos, uno debe incluir todos los atributos y el resto solo una parte de ellos. ##");
		
		
		System.out.println("##################### FIN Consulta 14 #################################");
	}
}
