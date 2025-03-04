package br.com.psouza.controller;

import java.util.List;

public interface IController<T> {
    public String addElement();

    public T getElement();

    public void setElement(T t);

    public List<T> getElements();

    public void setElements(List<T> elements);

    public String deleteElement(T t);
}