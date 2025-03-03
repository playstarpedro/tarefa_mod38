package br.com.psouza.dao;

import br.com.psouza.domain.Client;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClientDAO extends GenericDAO<Client, Long>{
    public ClientDAO() {
        super(Client.class);
    }
}
