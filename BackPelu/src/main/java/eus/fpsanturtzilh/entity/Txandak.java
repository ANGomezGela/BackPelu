package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "txandak")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class Txandak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    @Column(name = "mota", length = 1, nullable = false)
    private String mota; 

    @Column(name = "data", nullable = false)
    private LocalDate data; 

    @ManyToOne
    @JoinColumn(name = "id_langilea", nullable = false)
    private Langileak langilea; 

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; 

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; 

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; 
}
