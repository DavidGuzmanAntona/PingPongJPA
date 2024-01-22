package daoImplementacion;

import dao.EquipoDAO;
import entidades.Equipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EquipoImplementacionDAO implements EquipoDAO {

	@Override
	public void insertarEquipo(Equipo equipo) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(equipo);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public Equipo mostrarEquipo(int id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		Equipo e = entityManager.find(Equipo.class, id);
		return e;
	}

	@Override
	public void updateEqupo(int idEquipo) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		Equipo equipoUpdate = entityManager.find(Equipo.class, idEquipo);
		equipoUpdate.setNombre("Los Halcones");
		entityManager.getTransaction().begin();
		entityManager.merge(equipoUpdate);
		entityManager.getTransaction().commit();
		entityManager.close();
 
	}

	@Override
	public void deleteEquipo(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		Equipo equipoDelete= entityManager.find(Equipo.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(equipoDelete);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

}
