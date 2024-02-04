package daoImplementacion;

import java.util.List;

import dao.DAOGenerico;
import entidades.Estadio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import liga.SimulacionMain;

public class EstadioImplementacionDAO implements DAOGenerico <Estadio>{

	@Override
	public void insertar(Estadio estadioInsertar) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(estadioInsertar);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

	@Override
	public void update(Estadio estadio) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(estadio);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

	@Override
	public void delete(int idEstadio) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		Estadio estadioDelete = entityManager.find(Estadio.class, idEstadio);
		entityManager.getTransaction().begin();
		entityManager.remove(estadioDelete);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

	@Override
	public Estadio findById(long idEstadio) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		Estadio estadio = entityManager.find(Estadio.class, idEstadio);
		return estadio;
	}

	@Override
	public List<Estadio> findAll() {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		TypedQuery<Estadio> query = entityManager.createQuery("SELECT j FROM Estadio j", Estadio.class);
		return query.getResultList();
	}


	

}
