package daoImplementacion;

import java.util.List;

import dao.DAOGenerico;
import entidades.Equipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import liga.SimulacionMain;

/**
 * Esta clase implementa el DAO genérico para la entidad de Equipo
 * realizando especificamente un CRUD mediante métodos reutilizables
 * 
 * @author DavidGuzmán
 * @version 1.0
 * @since 2024-02-03
 */
public class EquipoImplementacionDAO implements DAOGenerico<Equipo> {

	@Override
	public void insertar(Equipo equipo) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(equipo);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public void update(Equipo equipo) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(equipo);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public void delete(int idEquipo) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		Equipo equipoDelete = entityManager.find(Equipo.class, idEquipo);
		entityManager.getTransaction().begin();
		entityManager.remove(equipoDelete);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public Equipo findById(long id) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		Equipo e = entityManager.find(Equipo.class, id);
		return e;
	}

	@Override
	public List<Equipo> findAll() {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		TypedQuery<Equipo> query = entityManager.createQuery("SELECT j FROM Equipo j", Equipo.class);
		return query.getResultList();
	}

}
