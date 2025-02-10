package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "zerbitzuak")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class Zerbitzuak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(name = "izena", length = 100, nullable = false)
    private String izena; 

    @ManyToOne
    @JoinColumn(name = "id_kategoria", nullable = false)
    private Kategoriak kategoriak; 

    @Column(name = "etxeko_prezioa", nullable = false)
    private BigDecimal etxekoPrezioa; 

    @Column(name = "kanpoko_prezioa", nullable = false)
    private BigDecimal kanpokoPrezioa; 

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; 

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; 

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; 
}
