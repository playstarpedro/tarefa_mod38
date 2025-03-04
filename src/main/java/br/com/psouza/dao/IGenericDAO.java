package br.com.psouza.dao;

import br.com.psouza.domain.Persistent;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface IGenericDAO <T extends Persistent, E extends Serializable> {
    public T register(T entity);

    public void delete(T entity);

    public T update(T entity);

    public T consult(E id);

    public List<T> searchAll();
}
