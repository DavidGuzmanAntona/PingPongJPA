package daoImplementacion;

import java.util.List;

import dao.DAOGenerico;
import entidades.Competicion;
import entidades.Jugador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class CompeticionImplementacionDAO implements DAOGenerico <Competicion> {


	@Override
	public void insertar(Competicion competicionInsetar) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(competicionInsetar);
		entityManager.getTransaction().commit();

		
	}
	@Override
	public void update(int idCompeticion, String nombre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		Competicion competicionUpdate = entityManager.find(Competicion.class, idCompeticion);
		competicionUpdate.setNombre(nombre);
		entityManager.getTransaction().begin();
		entityManager.merge(competicionUpdate);
		entityManager.getTransaction().commit();

		
	}

	@Override
	public void delete(int idCompeticion) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		Competicion competicionDelete= entityManager.find(Competicion.class, idCompeticion);
		entityManager.getTransaction().begin();
		entityManager.remove(competicionDelete);
		entityManager.getTransaction().commit();

		
	}

	@Override
	public Competicion findById(long idCompeticion) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		Competicion comp = entityManager.find(Competicion.class, idCompeticion);
		return comp;
	}
	@Override
	public List<Competicion> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		TypedQuery<Competicion> query = entityManager.createQuery("SELECT j FROM Competicion j", Competicion.class);
        return query.getResultList();
	}



}
