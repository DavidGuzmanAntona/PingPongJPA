package daoImplementacion;

import java.util.List;

import dao.DAOGenerico;
import entidades.Equipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EquipoImplementacionDAO implements DAOGenerico<Equipo> {

	@Override
	public void insertar(Equipo equipo) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(equipo);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

	@Override
	public void update(Equipo equipo) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(equipo);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

	@Override
	public void delete(int idEquipo) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		Equipo equipoDelete= entityManager.find(Equipo.class, idEquipo);
		entityManager.getTransaction().begin();
		entityManager.remove(equipoDelete);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

	@Override
	public Equipo findById(long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		Equipo e = entityManager.find(Equipo.class, id);
		return e;
	}

	@Override
	public List<Equipo> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		TypedQuery<Equipo> query = entityManager.createQuery("SELECT j FROM Equipo j", Equipo.class);
        return query.getResultList();
	}



}

