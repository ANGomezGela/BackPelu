package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "zerbitzuak")
public class Zerbitzuak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Clave primaria autogenerada

    @Column(name = "izena", length = 100, nullable = false)
    private String izena; // Nombre del servicio

    @ManyToOne
    @JoinColumn(name = "id_kategoria", nullable = false)
    private Kategoriak kategoriak; // Relación con la tabla `kategoriak`

    @Column(name = "etxeko_prezioa", nullable = false)
    private BigDecimal etxekoPrezioa; // Precio para servicios en casa

    @Column(name = "kanpoko_prezioa", nullable = false)
    private BigDecimal kanpokoPrezioa; // Precio para servicios externos

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; // Fecha de creación del servicio

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; // Fecha de última actualización del servicio

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; // Fecha de eliminación lógica del servicio

    // Constructor vacío obligatorio para JPA
    public Zerbitzuak() {
    }

    // Constructor completo
    public Zerbitzuak(String izena, Kategoriak kategoriak, BigDecimal etxekoPrezioa,
                      BigDecimal kanpokoPrezioa, LocalDateTime sortzeData,
                      LocalDateTime eguneratzeData, LocalDateTime ezabatzeData) {
        this.izena = izena;
        this.kategoriak = kategoriak;
        this.etxekoPrezioa = etxekoPrezioa;
        this.kanpokoPrezioa = kanpokoPrezioa;
        this.sortzeData = sortzeData;
        this.eguneratzeData = eguneratzeData;
        this.ezabatzeData = ezabatzeData;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public Kategoriak getKategoriak() {
        return kategoriak;
    }

    public void setKategoriak(Kategoriak kategoriak) {
        this.kategoriak = kategoriak;
    }

    public BigDecimal getEtxekoPrezioa() {
        return etxekoPrezioa;
    }

    public void setEtxekoPrezioa(BigDecimal etxekoPrezioa) {
        this.etxekoPrezioa = etxekoPrezioa;
    }

    public BigDecimal getKanpokoPrezioa() {
        return kanpokoPrezioa;
    }

    public void setKanpokoPrezioa(BigDecimal kanpokoPrezioa) {
        this.kanpokoPrezioa = kanpokoPrezioa;
    }

    public LocalDateTime getSortzeData() {
        return sortzeData;
    }

    public void setSortzeData(LocalDateTime sortzeData) {
        this.sortzeData = sortzeData;
    }

    public LocalDateTime getEguneratzeData() {
        return eguneratzeData;
    }

    public void setEguneratzeData(LocalDateTime eguneratzeData) {
        this.eguneratzeData = eguneratzeData;
    }

    public LocalDateTime getEzabatzeData() {
        return ezabatzeData;
    }

    public void setEzabatzeData(LocalDateTime ezabatzeData) {
        this.ezabatzeData = ezabatzeData;
    }

    @Override
    public String toString() {
        return "Zerbitzuak{" +
                "id=" + id +
                ", izena='" + izena + '\'' +
                ", kategoriak=" + kategoriak +
                ", etxekoPrezioa=" + etxekoPrezioa +
                ", kanpokoPrezioa=" + kanpokoPrezioa +
                ", sortzeData=" + sortzeData +
                ", eguneratzeData=" + eguneratzeData +
                ", ezabatzeData=" + ezabatzeData +
                '}';
    }
}
