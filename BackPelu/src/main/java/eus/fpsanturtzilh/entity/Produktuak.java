package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "produktuak")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
@Getter
@Setter
public class Produktuak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    @Column(name = "izena", length = 100, nullable = false)
    private String izena; 

    @Column(name = "deskribapena", length = 250)
    private String deskribapena; 

    @ManyToOne
    @JoinColumn(name = "id_kategoria", nullable = false)
    private Kategoriak kategoriak; 

    @Column(name = "marka", length = 50, nullable = false)
    private String marka; 

    @Column(name = "stock", nullable = false)
    private Integer stock; 

    @Column(name = "stock_alerta", nullable = false)
    private Integer stockAlerta; 

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; 

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; 

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; 
}
