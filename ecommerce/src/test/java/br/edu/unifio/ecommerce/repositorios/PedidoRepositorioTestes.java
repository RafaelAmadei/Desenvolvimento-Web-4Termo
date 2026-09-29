package br.edu.unifio.ecommerce.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.ecommerce.entidades.Categoria;
import br.edu.unifio.ecommerce.entidades.Produto;

@SpringBootTest
public class PedidoRepositorioTestes {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Test
    void buscarPorId() {

        Categoria categoria = new Categoria();
        categoria.setNome("Eletrônicos");
        categoria.setDescricao("Produtos eletrônicos");

        categoria = categoriaRepositorio.save(categoria);

        Produto produto = new Produto();
        produto.setNome("Notebook");
        produto.setDescricao("Notebook para estudos");
        produto.setEstoque((short) 10);
        produto.setPreco(new BigDecimal("3500.00"));
        produto.setCategoria(categoria);

        Produto salvo = produtoRepositorio.save(produto);

        Optional<Produto> resultado =
                produtoRepositorio.findById(salvo.getId());

        assertTrue(resultado.isPresent());

        Produto encontrado = resultado.get();

        assertEquals("Notebook", encontrado.getNome());
        assertEquals(new BigDecimal("3500.00"), encontrado.getPreco());
        assertEquals("Eletrônicos", encontrado.getCategoria().getNome());
    }

    @Test
    void listar() {

        Categoria categoria = new Categoria();
        categoria.setNome("Informática");
        categoria.setDescricao("Produtos de informática");

        categoria = categoriaRepositorio.save(categoria);

        Produto produto1 = new Produto();
        produto1.setNome("Teclado");
        produto1.setDescricao("Teclado USB");
        produto1.setEstoque((short) 20);
        produto1.setPreco(new BigDecimal("100.00"));
        produto1.setCategoria(categoria);

        Produto produto2 = new Produto();
        produto2.setNome("Mouse");
        produto2.setDescricao("Mouse USB");
        produto2.setEstoque((short) 15);
        produto2.setPreco(new BigDecimal("50.00"));
        produto2.setCategoria(categoria);

        produtoRepositorio.save(produto1);
        produtoRepositorio.save(produto2);

        List<Produto> produtos = produtoRepositorio.findAll();

        assertNotNull(produtos);

        assertTrue(produtos.stream()
                .anyMatch(p -> p.getNome().equals("Teclado")));

        assertTrue(produtos.stream()
                .anyMatch(p -> p.getNome().equals("Mouse")));
    }
}