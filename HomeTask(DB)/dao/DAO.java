package homeWork.hw8.dao;

import java.util.List;

/**
 * Standard DAO interface for all classes
 * @param <T> - class will create DAO
 * @author Jesus Raichuk
 */
public interface DAO<T> {
    //create
    void add (T t);

    //read
    List<T> getAll();

    T getById(int id);

    //update
    void update(T t);

    //delete
    void delete(T t);
}
