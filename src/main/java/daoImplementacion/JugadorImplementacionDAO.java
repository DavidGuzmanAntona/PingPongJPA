package daoImplementacion;

import java.util.List;

import dao.DAOGenerico;
import entidades.Equipo;
import entidades.Jugador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import liga.SimulacionMain;

/**
 * Esta clase implementa el DAO genérico para la entidad de Jugador
 * realizando especificamente un CRUD mediante métodos reutilizables
 * 
 * @author DavidGuzmán
 * @version 1.0
 * @since 2024-02-03
 */
public class JugadorImplementacionDAO implements DAOGenerico<Jugador> {

	@Override
	public void insertar(Jugador jugador) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(jugador);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public void update(Jugador jugador) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(jugador);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public void delete(int idJugador) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		Jugador jugadorDelete = entityManager.find(Jugador.class, idJugador);
		entityManager.getTransaction().begin();
		entityManager.remove(jugadorDelete);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public Jugador findById(long id) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		Jugador e = entityManager.find(Jugador.class, id);
		return e;
	}

	@Override
	public List<Jugador> findAll() {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		TypedQuery<Jugador> query = entityManager.createQuery("SELECT j FROM Jugador j", Jugador.class);
		return query.getResultList();
	}

	public void updateEquipo(int idJugador, Equipo equipo) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		Jugador jugadorUpdate = entityManager.find(Jugador.class, idJugador);
		jugadorUpdate.setEquipo(equipo);
		entityManager.getTransaction().begin();
		entityManager.merge(jugadorUpdate);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

}
