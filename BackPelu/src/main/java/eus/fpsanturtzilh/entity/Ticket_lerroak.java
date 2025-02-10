package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket_lerroak")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
@Getter
@Setter
public class Ticket_lerroak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @ManyToOne
    @JoinColumn(name = "id_hitzordua", nullable = false)
    private Hitzorduak hitzordua; 

    @ManyToOne
    @JoinColumn(name = "id_zerbitzua", nullable = false)
    private Zerbitzuak zerbitzua; 

    @Column(name = "prezioa", nullable = false)
    private BigDecimal prezioa; 

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; 

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; 

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; 
}
