package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bezero_fitxak")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
@Getter
@Setter
public class Bezero_fitxak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    @Column(name = "izena", length = 100, nullable = false)
    private String izena; 

    @Column(name = "abizena", length = 200, nullable = false)
    private String abizena; 

    @Column(name = "telefonoa", length = 9)
    private String telefonoa; 

    @Column(name = "azal_sentikorra", length = 1, nullable = false)
    private String azalSentikorra; 

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; 

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; 

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData;
}
