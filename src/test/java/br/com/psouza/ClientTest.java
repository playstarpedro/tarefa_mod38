package br.com.psouza;



import br.com.psouza.dao.ClientDAO;
import br.com.psouza.dao.IGenericDAO;
import br.com.psouza.domain.Client;
import br.com.psouza.domain.Persistent;
import org.junit.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Collection;

public class ClientTest {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "0079";
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("META-INF/persistence.xml"));


        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Conexão bem-sucedida! 🎉");
            } else {
                System.out.println("Falha na conexão.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private IGenericDAO clientDAO;

    public ClientTest() {
        this.clientDAO = new ClientDAO();
    }

    @After
    public void end() {
        Collection<Client> clients = clientDAO.searchAll();
        clients.forEach(client -> {
            try {
                clientDAO.delete(client);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void shouldRegisterAClient() {
        Client registeredClient = (Client) clientDAO.register(createClient("123123123123"));
        Client consultedClient = (Client) clientDAO.consult(registeredClient.getId());

        Assert.assertNotNull(consultedClient);
        Assert.assertEquals(consultedClient.getCpf(), registeredClient.getCpf());
    }

    @Test
    public void shouldUpdateAClient() {
        Client registeredClient = (Client) clientDAO.register(createClient("123123123123"));

        registeredClient.setCpf("99999999999");
        clientDAO.update(registeredClient);
        Client consultedClient = (Client) clientDAO.consult(registeredClient.getId());

        Assert.assertEquals(consultedClient.getCpf(), "99999999999");
        Assert.assertNotEquals(consultedClient.getCpf(), "123123123123");
    }

    @Test
    public void shouldSearchAllClients() {
        Client registeredClient1 = (Client) clientDAO.register(createClient("1234567890"));
        Client registeredClient2 = (Client) clientDAO.register(createClient("0987654321"));

        List<Client> clients = (List<Client>) clientDAO.searchAll();
        Assert.assertNotNull(clients);
        Assert.assertEquals(clients.get(0).getCpf(), registeredClient1.getCpf());
        Assert.assertEquals(clients.get(1).getCpf(), registeredClient2.getCpf());
    }

    @Test
    public void shouldConsultAClient() {
        Client client = (Client) clientDAO.register(createClient("123123123123"));

        Client consultedClient = (Client) clientDAO.consult(client.getId());
        Assert.assertNotNull(consultedClient);
        Assert.assertEquals(consultedClient.getCpf(), client.getCpf());
    }

    @Test
    public void shouldDeleteAClient() {
        Client client = (Client) clientDAO.register(createClient("123123123123"));

        Client registeredClient = (Client) clientDAO.consult(client.getId());
        clientDAO.delete(registeredClient);

        Persistent consultedClient = clientDAO.consult(registeredClient.getId());
        Assert.assertNull(consultedClient);
    }

    private Client createClient(String cpf) {
        return new Client(
                "Peter",
                cpf,
                "11966666666",
                "Test Street",
                501,
                "São Paulo",
                "SP"
        );
    }
}
