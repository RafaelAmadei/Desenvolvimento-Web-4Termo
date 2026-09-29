package br.edu.unifio.ecommerce.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.ecommerce.entidades.Cliente;
import br.edu.unifio.ecommerce.entidades.Pagamento;
import br.edu.unifio.ecommerce.entidades.Pedido;

@SpringBootTest
public class PagamentoRepositorioTestes {

    @Autowired
    private PagamentoRepositorio pagamentoRepositorio;

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Test
    void buscarPorId() {

        Cliente cliente = new Cliente();
        cliente.setNome("Marcos Lima");
        cliente.setEmail("marcos@email.com");
        cliente.setTelefone("14933333333");

        cliente = clienteRepositorio.save(cliente);

        Pedido pedido = new Pedido();
        pedido.setData(LocalDateTime.now());
        pedido.setStatus("PENDENTE");
        pedido.setValorTotal(new BigDecimal("500.00"));
        pedido.setCliente(cliente);

        pedido = pedidoRepositorio.save(pedido);

        Pagamento pagamento = new Pagamento();
        pagamento.setValor(new BigDecimal("500.00"));
        pagamento.setData(LocalDateTime.now());
        pagamento.setStatus("APROVADO");
        pagamento.setTipo("PIX");
        pagamento.setPedido(pedido);

        Pagamento salvo = pagamentoRepositorio.save(pagamento);

        Optional<Pagamento> resultado =
                pagamentoRepositorio.findById(salvo.getId());

        assertTrue(resultado.isPresent());

        Pagamento encontrado = resultado.get();

        assertEquals(new BigDecimal("500.00"), encontrado.getValor());
        assertEquals("APROVADO", encontrado.getStatus());
        assertEquals("PIX", encontrado.getTipo());
        assertEquals(pedido.getId(), encontrado.getPedido().getId());
    }

    @Test
    void listar() {

        Cliente cliente = new Cliente();
        cliente.setNome("Fernanda Costa");
        cliente.setEmail("fernanda@email.com");
        cliente.setTelefone("14922222222");

        cliente = clienteRepositorio.save(cliente);

        Pedido pedido1 = new Pedido();
        pedido1.setData(LocalDateTime.now());
        pedido1.setStatus("PENDENTE");
        pedido1.setValorTotal(new BigDecimal("100.00"));
        pedido1.setCliente(cliente);

        pedido1 = pedidoRepositorio.save(pedido1);

        Pagamento pagamento1 = new Pagamento();
        pagamento1.setValor(new BigDecimal("100.00"));
        pagamento1.setData(LocalDateTime.now());
        pagamento1.setStatus("APROVADO");
        pagamento1.setTipo("PIX");
        pagamento1.setPedido(pedido1);

        Pagamento pagamento2 = new Pagamento();
        pagamento2.setValor(new BigDecimal("200.00"));
        pagamento2.setData(LocalDateTime.now());
        pagamento2.setStatus("PENDENTE");
        pagamento2.setTipo("CARTAO");
        
        Cliente cliente2 = new Cliente();
        cliente2.setNome("Roberto Silva");
        cliente2.setEmail("roberto@email.com");
        cliente2.setTelefone("14911111111");

        cliente2 = clienteRepositorio.save(cliente2);

        Pedido pedido2 = new Pedido();
        pedido2.setData(LocalDateTime.now());
        pedido2.setStatus("PENDENTE");
        pedido2.setValorTotal(new BigDecimal("200.00"));
        pedido2.setCliente(cliente2);

        pedido2 = pedidoRepositorio.save(pedido2);

        pagamento2.setPedido(pedido2);

        pagamentoRepositorio.save(pagamento1);
        pagamentoRepositorio.save(pagamento2);

        List<Pagamento> pagamentos = pagamentoRepositorio.findAll();

        assertNotNull(pagamentos);

        assertTrue(pagamentos.stream()
                .anyMatch(p -> p.getStatus().equals("APROVADO")));

        assertTrue(pagamentos.stream()
                .anyMatch(p -> p.getTipo().equals("CARTAO")));
    }
}