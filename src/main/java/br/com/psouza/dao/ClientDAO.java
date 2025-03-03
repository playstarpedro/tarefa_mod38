package br.com.psouza.dao;

import br.com.psouza.domain.Client;

public class ClientDAO extends GenericDAO<Client, Long>{
    public ClientDAO(Class<Client> persistentClass, String persistenceUnitName) {
        super(persistentClass, persistenceUnitName);
    }
}
