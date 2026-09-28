package br.edu.unifio.ecommerce.repositorios;

<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.assertEquals;

=======
>>>>>>> 3857bc991376e27f3aa83e82b47f73d59cedcebe
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

<<<<<<< HEAD
import br.edu.unifio.ecommerce.entidades.Categoria;

@SpringBootTest 
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoriaRepositorioTestes {

=======
@SpringBootTest 
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class CategoriaRepositorioTestes {
>>>>>>> 3857bc991376e27f3aa83e82b47f73d59cedcebe
    @Autowired 
    private CategoriaRepositorio categoriaRepositorio;

    @Test 
<<<<<<< HEAD
    public void deveBuscarUmaCategoriaPorId() {
        Categoria categoria = categoriaRepositorio
                .findById(Short.parseShort("2"))
                .orElseThrow();


    assertEquals("Eletrónica", categoria.getNome());
    }
}
=======
    public void deveBuscarUmaCategoriaPorId () {
      Categoria categoria = categoriaRepositorio.findById(Short.parseShort("2")).orElseThrow();    }

}
>>>>>>> 3857bc991376e27f3aa83e82b47f73d59cedcebe
