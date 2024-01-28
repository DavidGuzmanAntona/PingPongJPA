package daoImplementacion;

import java.util.List;

import dao.DAOGenerico;
import dao.EquipoDAO;
import entidades.Equipo;
import entidades.Jugador;
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
	public void update(int idEquipo, String nombre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		Equipo equipoUpdate = entityManager.find(Equipo.class, idEquipo);
		equipoUpdate.setNombre(nombre);
		entityManager.getTransaction().begin();
		entityManager.merge(equipoUpdate);
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
