package dao;

import java.util.List;


public interface DAOGenerico<T> {

		
    void insertar(T entity);
    void update(T entity);
    void delete(int id);
    T findById(long id);
    List<T> findAll();

}
