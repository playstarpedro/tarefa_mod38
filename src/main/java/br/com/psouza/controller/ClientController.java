package br.com.psouza.controller;

import jakarta.inject.Named;
import jakarta.inject.Inject;
import br.com.psouza.dao.ClientDAO;
import br.com.psouza.domain.Client;
import jakarta.faces.view.ViewScoped;

import java.io.Serializable;

@Named
@ViewScoped
public class ClientController extends GenericController<Client, ClientDAO, Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private ClientDAO clientDAO;

    @Override
    protected Client createNewEntity() {
        return new Client();
    }

}
