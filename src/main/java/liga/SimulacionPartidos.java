package liga;

import java.util.List;
import java.util.Random;

import consultas.ConsultasCompeticion;
import daoImplementacion.EquipoImplementacionDAO;
import entidades.Equipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * Esta clase simula una jornada completa de la competicion de manera que los
 * Equipos se enfrentan entre ellos y obtienen una cantidad de puntos.
 * Persistimos los resultados a la BD y la actualizamos
 * 
 * @author DavidGuzmán
 * @version 1.0
 * @since 2024-02-03
 */
public class SimulacionPartidos {

	public static void simularJornada(List<Equipo> equiposLiga) {

		System.out.println("Iniciando simulacion de Jornada:");

		Random random = new Random();
		int contador = 0;

		for (int i = 0; i < equiposLiga.size(); i++) {

			for (int j = i + 1; j < equiposLiga.size(); j++) {
				Equipo equipoLocal = equiposLiga.get(i);
				Equipo equipoVisitante = equiposLiga.get(j);
				int equipoLocRes = random.nextInt(6);
				int equipoVisRes = (int) (Math.random() * 6);

				if (equipoLocRes > equipoVisRes) {
					equipoLocal.sumarVictoria();
					equipoVisitante.sumarDerrota();
					equipoLocal.sumarPuntos(3);

					System.out.println("El equipo: " + equipoLocal.getNombre() + "Gana el partido contra: "
							+ equipoVisitante.getNombre());
				}
				if (equipoLocRes < equipoVisRes) {
					equipoVisitante.sumarVictoria();
					equipoLocal.sumarDerrota();
					equipoVisitante.sumarPuntos(3);

					System.out.println("El equipo: " + equipoVisitante.getNombre() + "Gana el partido contra: "
							+ equipoLocal.getNombre());
				}
				if (equipoLocRes == equipoVisRes) {
					equipoVisitante.sumarEmpate();
					equipoLocal.sumarEmpate();
					equipoLocal.sumarPuntos(1);
					equipoVisitante.sumarPuntos(1);

					System.out.println("El equipo: " + equipoLocal.getNombre() + "Empata el partido contra: "
							+ equipoVisitante.getNombre());
				}
				equipoLocal.sumarPartidos();
				equipoVisitante.sumarPartidos();

			}
			contador++;
			if (contador == 1 || contador == 3) {
				updateDBResultados(equiposLiga);
				ConsultasCompeticion.consulta8();
			}
		}
		updateDBResultados(equiposLiga);
	}

	private static void updateDBResultados(List<Equipo> equipos) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			for (Equipo equipo : equipos) {
				entityManager.merge(equipo);
			}

			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			entityManager.close();
		}

	}

}
