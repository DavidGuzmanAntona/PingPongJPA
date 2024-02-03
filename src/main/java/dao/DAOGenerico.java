package dao;

import java.util.List;

/**
 * DAO gen�rico utilizado para ser implementado con los m�todos CRUD
 * 
 * @author DavidGuzm�n
 * @version 1.0
 * @since 2024-02-03
 */

public interface DAOGenerico<T> {

	void insertar(T entity);

	void update(T entity);

	void delete(int id);

	T findById(long id);

	List<T> findAll();

}
