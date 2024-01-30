package liga;

import java.util.List;
import java.util.Random;

import daoImplementacion.EquipoImplementacionDAO;
import entidades.Equipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class SimulacionPartidos {

	public static void simularJornada(List<Equipo> equiposLiga) {

		System.out.println("Iniciando simulacion de Jornada:");

		Random random = new Random();

		for (int i = 0; i < equiposLiga.size(); i++) {
			for (int j = i + 1; j < equiposLiga.size(); j++) {
				Equipo equipoLocal = equiposLiga.get(i);
				Equipo equipoVisitante = equiposLiga.get(j);
				int equipoLocRes = random.nextInt(6);
				int equipoVisRes = random.nextInt(6);

				if (equipoLocRes > equipoVisRes) {
					equipoLocal.sumarVictoria();
					equipoVisitante.sumarDerrota();
					equipoLocal.sumarPuntos(3);

					System.out.println("El equipo: " + equipoLocal.getNombre() + "Gana el partido contra: "
							+ equipoVisitante.getNombre());
				}
				if (equipoLocRes < equipoVisRes) {
					equipoVisitante.sumarVictoria();
					System.out.println("El equipo: " + equipoVisitante.getNombre() + "Gana el partido contra: "
							+ equipoLocal.getNombre());
				}
				if (equipoLocRes == equipoVisRes)
					equipoVisitante.sumarEmpate();
				equipoLocal.sumarPuntos(1);
				equipoVisitante.sumarPuntos(1);
				equipoLocal.sumarEmpate();
				System.out.println("El equipo: " + equipoLocal.getNombre() + "Empata el partido contra: "
						+ equipoVisitante.getNombre());

				equipoLocal.sumarPartidos();
				equipoVisitante.sumarPartidos();

			}

		}
		updateDBResultados(equiposLiga);
	}

	private static void updateDBResultados(List<Equipo> equipos) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
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
