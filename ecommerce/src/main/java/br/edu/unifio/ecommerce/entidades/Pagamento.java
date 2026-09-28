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
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pagamento {
<<<<<<< HEAD

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal valor;

    private LocalDateTime data;

    private String status;

    private String tipo;

=======
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
>>>>>>> 3857bc991376e27f3aa83e82b47f73d59cedcebe
    @OneToOne
    private Pedido pedido;
}