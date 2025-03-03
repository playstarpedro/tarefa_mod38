package br.com.psouza.controller;

import br.com.psouza.domain.Client;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class ClienteController extends GenericController<Client> implements Serializable {

    @Override
    protected Client createNewEntity() {
        return new Client(); // Cria uma nova instância de Client
    }

    @Override
    public String addElement() {
        // Salva o cliente no banco de dados
        this.genericDAO.register(this.getElement());
        // Limpa o formulário
        this.setElement(createNewEntity());
        // Redireciona para a lista de clientes
        return "client-list.xhtml?faces-redirect=true";
    }
}