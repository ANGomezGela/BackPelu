package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "produktu_mugimenduak")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
@Getter
@Setter
public class Produktu_mugimenduak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    @ManyToOne
    @JoinColumn(name = "id_produktua", nullable = false)
    private Produktuak produktua;

    @ManyToOne
    @JoinColumn(name = "id_langilea", nullable = false)
    private Langileak langilea; 

    @Column(name = "data", nullable = false)
    private LocalDateTime data; 

    @Column(name = "kopurua", nullable = false)
    private Integer kopurua; 

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; 

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; 

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; 
}
