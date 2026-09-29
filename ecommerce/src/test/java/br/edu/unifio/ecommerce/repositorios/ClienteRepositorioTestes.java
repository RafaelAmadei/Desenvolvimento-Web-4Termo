package br.edu.unifio.ecommerce.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.ecommerce.entidades.Cliente;

@SpringBootTest
public class ClienteRepositorioTestes {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Test
    void buscarPorId() {

        Cliente cliente = new Cliente();
        cliente.setNome("João Silva");
        cliente.setEmail("joao@email.com");
        cliente.setTelefone("14999999999");

        Cliente salvo = clienteRepositorio.save(cliente);

        Optional<Cliente> resultado =
                clienteRepositorio.findById(salvo.getId());

        assertTrue(resultado.isPresent());

        Cliente encontrado = resultado.get();

        assertEquals("João Silva", encontrado.getNome());
        assertEquals("joao@email.com", encontrado.getEmail());
    }

    @Test
    void listar() {

        Cliente cliente1 = new Cliente();
        cliente1.setNome("João Silva");
        cliente1.setEmail("joao@email.com");
        cliente1.setTelefone("14999999999");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Maria Souza");
        cliente2.setEmail("maria@email.com");
        cliente2.setTelefone("14988888888");

        clienteRepositorio.save(cliente1);
        clienteRepositorio.save(cliente2);

        List<Cliente> clientes = clienteRepositorio.findAll();

        assertNotNull(clientes);

        assertTrue(clientes.stream()
                .anyMatch(c -> c.getNome().equals("João Silva")));

        assertTrue(clientes.stream()
                .anyMatch(c -> c.getNome().equals("Maria Souza")));
    }
}