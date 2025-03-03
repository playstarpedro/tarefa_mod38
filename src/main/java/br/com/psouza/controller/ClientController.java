package br.com.psouza.controller;

import br.com.psouza.dao.ClientDAO;
import br.com.psouza.domain.Client;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientController {

    @Inject
    private ClientDAO clientDAO;

    public void registrarCliente(Client client) {
        clientDAO.register(client);
    }
}
