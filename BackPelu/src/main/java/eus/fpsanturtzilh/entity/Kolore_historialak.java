package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "kolore_historialak")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
@Getter
@Setter
public class Kolore_historialak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    @ManyToOne
    @JoinColumn(name = "id_bezeroa", nullable = false)
    private Bezero_fitxak bezeroa; 

    @ManyToOne
    @JoinColumn(name = "id_produktua", nullable = false)
    private Produktuak produktua; 

    @Column(name = "data", nullable = false)
    private LocalDate data; 

    @Column(name = "kantitatea")
    private Integer kantitatea; 

    @Column(name = "bolumena", length = 100)
    private String bolumena; 

    @Column(name = "oharrak", length = 250)
    private String oharrak; 

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; 

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; 

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; // Fecha de eliminación lógica del registro

}
