package br.edu.unifio.ecommerce.entidades;
<<<<<<< HEAD

=======
>>>>>>> 3857bc991376e27f3aa83e82b47f73d59cedcebe
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
public class Pedido {
<<<<<<< HEAD

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime data;

    private String status;

    private BigDecimal valorTotal;

=======
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
>>>>>>> 3857bc991376e27f3aa83e82b47f73d59cedcebe
    @ManyToOne
    private Cliente cliente;
}