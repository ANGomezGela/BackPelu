package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "ordutegiak")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
@Getter
@Setter
public class Ordutegiak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    @ManyToOne
    @JoinColumn(name = "kodea", nullable = false)
    private Taldeak taldeak; 

    @Column(name = "eguna", nullable = false)
    private Integer eguna; 

    @Column(name = "hasiera_data", nullable = false)
    private LocalDate hasieraData; 

    @Column(name = "amaiera_data", nullable = false)
    private LocalDate amaieraData; 

    @Column(name = "hasiera_ordua", nullable = false)
    private LocalTime hasieraOrdua; 

    @Column(name = "amaiera_ordua", nullable = false)
    private LocalTime amaieraOrdua; 

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; 

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; 

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; 
}
