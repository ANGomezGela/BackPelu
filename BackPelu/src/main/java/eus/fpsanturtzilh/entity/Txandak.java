package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "txandak")
public class Txandak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    @Column(name = "mota", length = 1, nullable = false)
    private String mota; 

    @Column(name = "data", nullable = false)
    private LocalDate data; // Fecha del turno

    @ManyToOne
    @JoinColumn(name = "id_langilea", nullable = false)
    private Langileak langilea; // Relación con la tabla `langileak`

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; 
    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; 

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; 
    
    // Constructor vacío obligatorio para JPA
    public Txandak() {
    }

    // Constructor completo
    public Txandak(String mota, LocalDate data, Langileak langilea, LocalDateTime sortzeData, LocalDateTime eguneratzeData, LocalDateTime ezabatzeData) {
        this.mota = mota;
        this.data = data;
        this.langilea = langilea;
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

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Langileak getLangilea() {
        return langilea;
    }

    public void setLangilea(Langileak langilea) {
        this.langilea = langilea;
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
        return "Txandak{" +
                "id=" + id +
                ", mota='" + mota + '\'' +
                ", data=" + data +
                ", langilea=" + langilea +
                ", sortzeData=" + sortzeData +
                ", eguneratzeData=" + eguneratzeData +
                ", ezabatzeData=" + ezabatzeData +
                '}';
    }
}
