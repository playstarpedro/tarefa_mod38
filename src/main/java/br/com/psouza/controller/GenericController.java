package br.com.psouza.controller;

import br.com.psouza.dao.GenericDAO;
import br.com.psouza.domain.Persistent;

import jakarta.inject.Named;
import jakarta.inject.Inject;
import jakarta.enterprise.context.RequestScoped;

import java.util.List;
import java.io.Serializable;

@Named
@RequestScoped
public abstract class GenericController<T extends Persistent<ID>, E extends GenericDAO<T, ID>, ID extends Serializable> implements IController<T> {
//TODO: make returned url's dynamic according to the Persist class passed!
    @Inject
    protected E dao;

    protected T element;
    protected List<T> elements = null;

    protected abstract T createNewEntity();

    @Override
    public String addElement() {
        dao.register(this.getElement());
        this.setElement(createNewEntity());
        return "client-list.xhtml?faces-redirect=true";
    }

    @Override
    public T getElement() {
        if (element == null) {
            element = createNewEntity();
        }
        return element;
    }

    @Override
    public void setElement(T element) {
        this.element = element;
    }

    @Override
    public List<T> getElements() {
        if (elements == null) {
            elements = dao.searchAll();
        }
        return elements;
    }

    @Override
    public void setElements(List<T> elements) {
        this.elements = elements;
    }

    @Override
    public String deleteElement(T element) {
        dao.delete(element);
        elements = dao.searchAll();
        return "client-list.xhtml?faces-redirect=true";
    }

    // I HATE RODRIGO PIRES
}