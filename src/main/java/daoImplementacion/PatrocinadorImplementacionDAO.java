package daoImplementacion;

import dao.DAOGenerico;
import entidades.Patrocinador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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
	public void update(int idPatrocinador, String nombre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("competicion");
		EntityManager entityManager = emf.createEntityManager();
		Patrocinador patrocinadorUpdate = entityManager.find(Patrocinador.class, idPatrocinador);
		patrocinadorUpdate.setNombrePatrocinador(nombre);
		entityManager.getTransaction().begin();
		entityManager.merge(patrocinadorUpdate);
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

}