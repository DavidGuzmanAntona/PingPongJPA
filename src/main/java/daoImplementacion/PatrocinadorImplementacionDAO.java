package daoImplementacion;

import java.util.List;

import dao.DAOGenerico;
import entidades.Jugador;
import entidades.Patrocinador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import liga.SimulacionMain;

/**
 * Esta clase implementa el DAO genérico para la entidad de Patrocinador
 * realizando especificamente un CRUD mediante métodos reutilizables
 * 
 * @author DavidGuzmán
 * @version 1.0
 * @since 2024-02-03
 */
public class PatrocinadorImplementacionDAO implements DAOGenerico<Patrocinador> {

	@Override
	public void insertar(Patrocinador patrocinadorInsertar) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(patrocinadorInsertar);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public void update(Patrocinador patrocinador) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(patrocinador);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public void delete(int idPatrocinador) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		Patrocinador patrocinadorDelete = entityManager.find(Patrocinador.class, idPatrocinador);
		entityManager.getTransaction().begin();
		entityManager.remove(patrocinadorDelete);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public Patrocinador findById(long idPatrocinador) {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		Patrocinador e = entityManager.find(Patrocinador.class, idPatrocinador);
		return e;
	}

	@Override
	public List<Patrocinador> findAll() {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		TypedQuery<Patrocinador> query = entityManager.createQuery("SELECT j FROM Patrocinador j", Patrocinador.class);
		return query.getResultList();
	}

}
