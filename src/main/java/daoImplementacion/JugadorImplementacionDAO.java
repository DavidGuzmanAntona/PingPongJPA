package daoImplementacion;

import java.util.List;

import dao.DAOGenerico;
import entidades.Jugador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class JugadorImplementacionDAO implements DAOGenerico<Jugador>{

	@Override
	public void insertar(Jugador jugador) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(jugador);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

	@Override
	public void update(int idJugador, String nombre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		Jugador jugadorUpdate = entityManager.find(Jugador.class, idJugador);
		jugadorUpdate.setNombre(nombre);
		entityManager.getTransaction().begin();
		entityManager.merge(jugadorUpdate);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public void delete(int idJugador) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		Jugador jugadorDelete= entityManager.find(Jugador.class, idJugador);
		entityManager.getTransaction().begin();
		entityManager.remove(jugadorDelete);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

	@Override
	public Jugador findById(long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		Jugador e = entityManager.find(Jugador.class, id);
		return e;
	}

	@Override
	public List<Jugador> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		TypedQuery<Jugador> query = entityManager.createQuery("SELECT j FROM Jugador j", Jugador.class);
        return query.getResultList();
	}

}
