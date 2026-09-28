package br.edu.unifio.ecommerce.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.ecommerce.entidades.Categoria;

@SpringBootTest 
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoriaRepositorioTestes {

    @Autowired 
    private CategoriaRepositorio categoriaRepositorio;

    @Test 
    public void deveBuscarUmaCategoriaPorId() {
        Categoria categoria = categoriaRepositorio
                .findById(Short.parseShort("2"))
                .orElseThrow();


    assertEquals("Eletrónica", categoria.getNome());
    }
}
