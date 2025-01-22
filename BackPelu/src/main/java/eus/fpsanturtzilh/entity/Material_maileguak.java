package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "material_maileguak")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class Material_maileguak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    @ManyToOne
    @JoinColumn(name = "id_materiala", nullable = false)
    private Materialak materialak;

    @ManyToOne
    @JoinColumn(name = "id_langilea", nullable = false)
    private Langileak langilea; 

    @Column(name = "hasiera_data", nullable = false)
    private LocalDateTime hasieraData; 

    @Column(name = "amaiera_data")
    private LocalDateTime amaieraData; 

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; 

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; 

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; 
}
