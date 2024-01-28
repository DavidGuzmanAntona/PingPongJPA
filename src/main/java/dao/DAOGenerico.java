package dao;

import java.util.List;


public interface DAOGenerico<T> {

		
    void insertar(T entity);
    void update(int id, String nombre);
    void delete(int id);
    T findById(long id);
    List<T> findAll();

}
