package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "taldeak")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
@Getter
@Setter
public class Taldeak {

    @Id
    @Column(name = "kodea", length = 5, nullable = false)
    private String kodea; 

    @Column(name = "izena", length = 100, nullable = false)
    private String izena; 

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; 

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; 

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; 
}
