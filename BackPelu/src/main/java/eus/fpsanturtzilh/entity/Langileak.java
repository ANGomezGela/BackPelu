package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "langileak")
public class Langileak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    @Column(name = "izena", length = 30, nullable = false)
    private String izena; 

    @Column(name = "abizenak", length = 100, nullable = false)
    private String abizenak;

    @ManyToOne
    @JoinColumn(name = "kodea", nullable = false)
    private Taldeak taldeak; 

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; 

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; 

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; 

    public Langileak() {
    }

    // Constructor completo
    public Langileak(String izena, String abizenak, Taldeak taldeak, LocalDateTime sortzeData, LocalDateTime eguneratzeData, LocalDateTime ezabatzeData) {
        this.izena = izena;
        this.abizenak = abizenak;
        this.taldeak = taldeak;
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

    public String getAbizenak() {
        return abizenak;
    }

    public void setAbizenak(String abizenak) {
        this.abizenak = abizenak;
    }

    public Taldeak getTaldeak() {
        return taldeak;
    }

    public void setTaldeak(Taldeak taldeak) {
        this.taldeak = taldeak;
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
        return "Langileak{" +
                "id=" + id +
                ", izena='" + izena + '\'' +
                ", abizenak='" + abizenak + '\'' +
                ", taldeak=" + taldeak +
                ", sortzeData=" + sortzeData +
                ", eguneratzeData=" + eguneratzeData +
                ", ezabatzeData=" + ezabatzeData +
                '}';
    }
}
