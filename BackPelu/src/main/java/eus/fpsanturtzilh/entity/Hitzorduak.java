package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "hitzorduak")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
@Getter
@Setter
public class Hitzorduak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Clave primaria autogenerada

    @Column(name = "eserlekua", nullable = true)
    private Integer eserlekua; // Número de asiento

    @Column(name = "data", nullable = false)
    private LocalDate data; // Fecha del turno

    @Column(name = "hasiera_ordua", nullable=true)
    private LocalTime hasieraOrdua; // Hora de inicio

    @Column(name = "amaiera_ordua", nullable=true)
    private LocalTime amaieraOrdua; // Hora de fin

    @Column(name = "hasiera_ordua_erreala")
    private LocalTime hasieraOrduaErreala; // Hora de inicio real (opcional)

    @Column(name = "amaiera_ordua_erreala")
    private LocalTime amaieraOrduaErreala; // Hora de fin real (opcional)

    @Column(name = "izena", length = 100, nullable = false)
    private String izena; // Nombre de la persona

    @Column(name = "telefonoa", length = 9)
    private String telefonoa; // Teléfono de contacto

    @Column(name = "deskribapena", length = 250)
    private String deskribapena; // Descripción opcional

    @Column(name = "etxekoa", length = 1, nullable = true)
    private String etxekoa; // 'E' (Etxeko) o 'K' (Kanpoko)

    @Column(name = "prezio_totala")
    private BigDecimal prezioTotala; // Precio total del turno

    @ManyToOne
    @JoinColumn(name = "id_langilea")
    private Langileak langilea; // Relación con la tabla `langileak`

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; // Fecha de creación del turno

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; // Fecha de última actualización del turno

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; // Fecha de eliminación lógica del turno
}
