package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "kategoriak")
public class Kategoriak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Clave primaria autogenerada

    @Column(name = "izena", length = 100, nullable = false)
    private String izena; // Nombre de la categoría

    @Column(name = "mota", length = 100, nullable = false)
    private String mota; // Tipo de la categoría (productos, servicios, materiales, etc.)

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; // Fecha de creación de la categoría

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; // Fecha de última actualización de la categoría

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; // Fecha de eliminación lógica de la categoría

    // Constructor vacío obligatorio para JPA
    public Kategoriak() {
    }

    // Constructor completo
    public Kategoriak(String izena, String mota, LocalDateTime sortzeData, LocalDateTime eguneratzeData, LocalDateTime ezabatzeData) {
        this.izena = izena;
        this.mota = mota;
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

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
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
        return "Kategoriak{" +
                "id=" + id +
                ", izena='" + izena + '\'' +
                ", mota='" + mota + '\'' +
                ", sortzeData=" + sortzeData +
                ", eguneratzeData=" + eguneratzeData +
                ", ezabatzeData=" + ezabatzeData +
                '}';
    }
}
