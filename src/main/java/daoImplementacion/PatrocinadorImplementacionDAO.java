package daoImplementacion;

import java.util.List;

import dao.DAOGenerico;
import entidades.Jugador;
import entidades.Patrocinador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class PatrocinadorImplementacionDAO implements DAOGenerico<Patrocinador> {

	@Override
	public void insertar(Patrocinador patrocinadorInsertar) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(patrocinadorInsertar);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public void update(Patrocinador patrocinador) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(patrocinador);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public void delete(int idPatrocinador) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		Patrocinador patrocinadorDelete = entityManager.find(Patrocinador.class, idPatrocinador);
		entityManager.getTransaction().begin();
		entityManager.remove(patrocinadorDelete);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public Patrocinador findById(long idPatrocinador) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		Patrocinador e = entityManager.find(Patrocinador.class, idPatrocinador);
		return e;
	}

	@Override
	public List<Patrocinador> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		TypedQuery<Patrocinador> query = entityManager.createQuery("SELECT j FROM Patrocinador j", Patrocinador.class);
        return query.getResultList();
	}

}

