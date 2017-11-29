package edu.matc.persistence;

import java.util.List;

public interface IGenericService<T> extends IGenericDao<T> {
    List<T> getAll();
    void deleteAll();
}