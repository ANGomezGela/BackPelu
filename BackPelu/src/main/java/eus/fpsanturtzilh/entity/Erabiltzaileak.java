package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "erabiltzaileak")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
@Getter
@Setter
public class Erabiltzaileak {

    @Id
    @Column(name = "username", length = 15, nullable = false)
    private String username; 

    @Column(name = "pasahitza", length = 100, nullable = false)
    private String pasahitza; 

    @Column(name = "rola", length = 2, nullable = false)
    private String rola; 

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; 

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; 

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData;
}
