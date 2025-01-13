package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "ordutegiak")
public class Ordutegiak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Clave primaria autogenerada

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

    // Constructor vacío obligatorio para JPA
    public Ordutegiak() {
    }

    // Constructor completo
    public Ordutegiak(Taldeak taldeak, Integer eguna, LocalDate hasieraData, LocalDate amaieraData,
                      LocalTime hasieraOrdua, LocalTime amaieraOrdua, LocalDateTime sortzeData,
                      LocalDateTime eguneratzeData, LocalDateTime ezabatzeData) {
        this.taldeak = taldeak;
        this.eguna = eguna;
        this.hasieraData = hasieraData;
        this.amaieraData = amaieraData;
        this.hasieraOrdua = hasieraOrdua;
        this.amaieraOrdua = amaieraOrdua;
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

    public Taldeak getTaldeak() {
        return taldeak;
    }

    public void setTaldeak(Taldeak taldeak) {
        this.taldeak = taldeak;
    }

    public Integer getEguna() {
        return eguna;
    }

    public void setEguna(Integer eguna) {
        this.eguna = eguna;
    }

    public LocalDate getHasieraData() {
        return hasieraData;
    }

    public void setHasieraData(LocalDate hasieraData) {
        this.hasieraData = hasieraData;
    }

    public LocalDate getAmaieraData() {
        return amaieraData;
    }

    public void setAmaieraData(LocalDate amaieraData) {
        this.amaieraData = amaieraData;
    }

    public LocalTime getHasieraOrdua() {
        return hasieraOrdua;
    }

    public void setHasieraOrdua(LocalTime hasieraOrdua) {
        this.hasieraOrdua = hasieraOrdua;
    }

    public LocalTime getAmaieraOrdua() {
        return amaieraOrdua;
    }

    public void setAmaieraOrdua(LocalTime amaieraOrdua) {
        this.amaieraOrdua = amaieraOrdua;
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
        return "Ordutegiak{" +
                "id=" + id +
                ", taldeak=" + taldeak +
                ", eguna=" + eguna +
                ", hasieraData=" + hasieraData +
                ", amaieraData=" + amaieraData +
                ", hasieraOrdua=" + hasieraOrdua +
                ", amaieraOrdua=" + amaieraOrdua +
                ", sortzeData=" + sortzeData +
                ", eguneratzeData=" + eguneratzeData +
                ", ezabatzeData=" + ezabatzeData +
                '}';
    }
}
