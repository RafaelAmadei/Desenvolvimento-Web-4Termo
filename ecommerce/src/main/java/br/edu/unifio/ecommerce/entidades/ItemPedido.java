package br.edu.unifio.ecommerce.entidades;
<<<<<<< HEAD

=======
>>>>>>> 3857bc991376e27f3aa83e82b47f73d59cedcebe
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ItemPedido {
<<<<<<< HEAD

=======
    
>>>>>>> 3857bc991376e27f3aa83e82b47f73d59cedcebe
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

<<<<<<< HEAD
    private Integer quantidade;

    private BigDecimal valorUnitario;

=======
>>>>>>> 3857bc991376e27f3aa83e82b47f73d59cedcebe
    @ManyToOne
    private Pedido pedido;

    @ManyToOne
    private Produto produto;
}