package br.com.psouza.controller;

import br.com.psouza.dao.GenericDAO;
import br.com.psouza.domain.Persistent;

import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public abstract class GenericController<T extends Persistent> implements IController<T>, Serializable {

    @Inject
    protected GenericDAO genericDAO;

    private T element;
    private Collection elements;

    protected abstract T createNewEntity();

    @Override
    public String addElement() {
        genericDAO.register(this.getElement());
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
    public Collection getElements() {
        if (elements == null) {
            elements = genericDAO.searchAll();
        }
        return elements;
    }

    @Override
    public void setElements(List<T> elements) {
        this.elements = elements;
    }

    @Override
    public String deleteElement(T element) {
        genericDAO.delete(element);
        elements = genericDAO.searchAll();
        return "client-list.xhtml?faces-redirect=true";
    }

    @Override
    public String editElement(T element) {
        this.setElement(element);
        return "client-edit.xhtml?faces-redirect=true&id=" + element.getId();
    }
}