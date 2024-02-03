package daoImplementacion;

import java.util.List;

import dao.DAOGenerico;
import entidades.Competicion;
import entidades.Jugador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import liga.SimulacionMain;
import dao.DAOGenerico;
import entidades.Competicion;
import entidades.Jugador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/**
 * Esta clase implementa el DAO genérico para la entidad de Competicion
 * realizando especificamente un CRUD mediante métodos reutilizables
 * 
 * @author DavidGuzmán
 * @version 1.0
 * @since 2024-02-03
 */
public class CompeticionImplementacionDAO implements DAOGenerico<Competicion> {

	@Override
	public void insertar(Competicion competicionInsetar) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(competicionInsetar);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public void update(Competicion competicion) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(competicion);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public void delete(int idCompeticion) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		Competicion competicionDelete = entityManager.find(Competicion.class, idCompeticion);
		entityManager.getTransaction().begin();
		entityManager.remove(competicionDelete);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public Competicion findById(long idCompeticion) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		Competicion comp = entityManager.find(Competicion.class, idCompeticion);
		return comp;

	}

	@Override
	public List<Competicion> findAll() {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		TypedQuery<Competicion> query = entityManager.createQuery("SELECT j FROM Competicion j", Competicion.class);
		return query.getResultList();
	}

}
