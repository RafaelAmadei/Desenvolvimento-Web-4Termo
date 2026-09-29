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
import br.edu.unifio.ecommerce.entidades.ItemPedido;
import br.edu.unifio.ecommerce.entidades.Pedido;

@SpringBootTest
public class ItemPedidoRepositorioTestes {

    @Autowired
    private ItemPedidoRepositorio itemPedidoRepositorio;

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Test
    void buscarPorId() {

        Cliente cliente = new Cliente();
        cliente.setNome("Pedro Santos");
        cliente.setEmail("pedro@email.com");
        cliente.setTelefone("14955555555");

        cliente = clienteRepositorio.save(cliente);

        Pedido pedido = new Pedido();
        pedido.setData(LocalDateTime.now());
        pedido.setStatus("PENDENTE");
        pedido.setValorTotal(new BigDecimal("300.00"));
        pedido.setCliente(cliente);

        pedido = pedidoRepositorio.save(pedido);

        ItemPedido item = new ItemPedido();
        item.setQuantidade(2);
        item.setValorUnitario(new BigDecimal("150.00"));
        item.setPedido(pedido);

        ItemPedido salvo = itemPedidoRepositorio.save(item);

        Optional<ItemPedido> resultado =
                itemPedidoRepositorio.findById(salvo.getId());

        assertTrue(resultado.isPresent());

        ItemPedido encontrado = resultado.get();

        assertEquals(2, encontrado.getQuantidade());
        assertEquals(new BigDecimal("150.00"), encontrado.getValorUnitario());
        assertEquals(pedido.getId(), encontrado.getPedido().getId());
    }

    @Test
    void listar() {

        Cliente cliente = new Cliente();
        cliente.setNome("Lucas Almeida");
        cliente.setEmail("lucas@email.com");
        cliente.setTelefone("14944444444");

        cliente = clienteRepositorio.save(cliente);

        Pedido pedido = new Pedido();
        pedido.setData(LocalDateTime.now());
        pedido.setStatus("PENDENTE");
        pedido.setValorTotal(new BigDecimal("200.00"));
        pedido.setCliente(cliente);

        pedido = pedidoRepositorio.save(pedido);

        ItemPedido item1 = new ItemPedido();
        item1.setQuantidade(2);
        item1.setValorUnitario(new BigDecimal("50.00"));
        item1.setPedido(pedido);

        ItemPedido item2 = new ItemPedido();
        item2.setQuantidade(3);
        item2.setValorUnitario(new BigDecimal("100.00"));
        item2.setPedido(pedido);

        itemPedidoRepositorio.save(item1);
        itemPedidoRepositorio.save(item2);

        List<ItemPedido> itens = itemPedidoRepositorio.findAll();

        assertNotNull(itens);

        assertTrue(itens.stream()
                .anyMatch(i -> i.getQuantidade().equals(2)));

        assertTrue(itens.stream()
                .anyMatch(i -> i.getQuantidade().equals(3)));
    }
}