package br.com.psouza.domain;

import java.io.Serializable;

public interface Persistent<ID extends Serializable> {

    public Long getId();

    public void setId(Long id);
}
