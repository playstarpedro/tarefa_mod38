package br.com.psouza.controller;

import java.util.Collection;
import java.util.List;

public interface IController<T> {
    public String addElement();

    public T getElement();

    public void setElement(T t);

    public Collection getElements();

    public void setElements(List<T> elements);

    public String deleteElement(T t);

    public String editElement(T t);
}