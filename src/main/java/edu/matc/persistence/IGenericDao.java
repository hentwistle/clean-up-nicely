package edu.matc.persistence;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IGenericDao<T> {
    public T get(Class<T> cl, Integer id);
    public T save(T object);
    public void update(T object);
    public void delete(T object);
    public List<T> query(String hsql, Map<String, Object> params);
}