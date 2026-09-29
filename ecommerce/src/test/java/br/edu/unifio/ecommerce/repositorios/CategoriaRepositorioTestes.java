package br.edu.unifio.ecommerce.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.ecommerce.entidades.Categoria;

@SpringBootTest
public class CategoriaRepositorioTestes {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Test
    void buscarPorId() {

        Categoria categoria = new Categoria();
        categoria.setNome("Eletrônicos");
        categoria.setDescricao("Produtos eletrônicos");

        Categoria salva = categoriaRepositorio.save(categoria);

        Optional<Categoria> resultado =
                categoriaRepositorio.findById(salva.getId());

        assertTrue(resultado.isPresent());

        Categoria encontrada = resultado.get();

        assertEquals("Eletrônicos", encontrada.getNome());
        assertEquals("Produtos eletrônicos", encontrada.getDescricao());
    }

    @Test
    void listar() {

        Categoria categoria1 = new Categoria();
        categoria1.setNome("Eletrônicos");
        categoria1.setDescricao("Produtos eletrônicos");

        Categoria categoria2 = new Categoria();
        categoria2.setNome("Roupas");
        categoria2.setDescricao("Roupas e acessórios");

        categoriaRepositorio.save(categoria1);
        categoriaRepositorio.save(categoria2);

        List<Categoria> categorias = categoriaRepositorio.findAll();

        assertNotNull(categorias);

        assertTrue(categorias.stream()
                .anyMatch(c -> c.getNome().equals("Eletrônicos")));

        assertTrue(categorias.stream()
                .anyMatch(c -> c.getNome().equals("Roupas")));
    }
}