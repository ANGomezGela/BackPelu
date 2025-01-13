package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "taldeak")
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

    // Constructor vacío obligatorio para JPA
    public Taldeak() {
    }

    // Constructor completo
    public Taldeak(String kodea, String izena, LocalDateTime sortzeData, LocalDateTime eguneratzeData, LocalDateTime ezabatzeData) {
        this.kodea = kodea;
        this.izena = izena;
        this.sortzeData = sortzeData;
        this.eguneratzeData = eguneratzeData;
        this.ezabatzeData = ezabatzeData;
    }

    // Getters y Setters
    public String getKodea() {
        return kodea;
    }

    public void setKodea(String kodea) {
        this.kodea = kodea;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
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
        return "Taldeak{" +
                "kodea='" + kodea + '\'' +
                ", izena='" + izena + '\'' +
                ", sortzeData=" + sortzeData +
                ", eguneratzeData=" + eguneratzeData +
                ", ezabatzeData=" + ezabatzeData +
                '}';
    }
}
