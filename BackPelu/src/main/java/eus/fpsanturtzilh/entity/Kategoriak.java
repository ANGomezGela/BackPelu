package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "kategoriak")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
@Getter
@Setter
public class Kategoriak {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    @Column(name = "izena", length = 100, nullable = false)
    private String izena; 

    @Column(name = "mota", length = 100, nullable = false)
    private String mota; 

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData;

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; 

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; 
}
