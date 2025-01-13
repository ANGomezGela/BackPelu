package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "kolore_historialak")
public class Kolore_historialak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Clave primaria autogenerada

    @ManyToOne
    @JoinColumn(name = "id_bezeroa", nullable = false)
    private Bezero_fitxak bezeroa; // Relación con la tabla `bezero_fitxak`

    @ManyToOne
    @JoinColumn(name = "id_produktua", nullable = false)
    private Produktuak produktua; // Relación con la tabla `produktuak`

    @Column(name = "data", nullable = false)
    private LocalDate data; // Fecha del historial

    @Column(name = "kantitatea")
    private Integer kantitatea; // Cantidad utilizada

    @Column(name = "bolumena", length = 100)
    private String bolumena; // Volumen del producto (opcional)

    @Column(name = "oharrak", length = 250)
    private String oharrak; // Observaciones (opcional)

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; // Fecha de creación del registro

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; // Fecha de última actualización del registro

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; // Fecha de eliminación lógica del registro

    // Constructor vacío obligatorio para JPA
    public Kolore_historialak() {
    }

    // Constructor completo
    public Kolore_historialak(Bezero_fitxak bezeroa, Produktuak produktua, LocalDate data,
                             Integer kantitatea, String bolumena, String oharrak,
                             LocalDateTime sortzeData, LocalDateTime eguneratzeData, LocalDateTime ezabatzeData) {
        this.bezeroa = bezeroa;
        this.produktua = produktua;
        this.data = data;
        this.kantitatea = kantitatea;
        this.bolumena = bolumena;
        this.oharrak = oharrak;
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

    public Bezero_fitxak getBezeroa() {
        return bezeroa;
    }

    public void setBezeroa(Bezero_fitxak bezeroa) {
        this.bezeroa = bezeroa;
    }

    public Produktuak getProduktua() {
        return produktua;
    }

    public void setProduktua(Produktuak produktua) {
        this.produktua = produktua;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getKantitatea() {
        return kantitatea;
    }

    public void setKantitatea(Integer kantitatea) {
        this.kantitatea = kantitatea;
    }

    public String getBolumena() {
        return bolumena;
    }

    public void setBolumena(String bolumena) {
        this.bolumena = bolumena;
    }

    public String getOharrak() {
        return oharrak;
    }

    public void setOharrak(String oharrak) {
        this.oharrak = oharrak;
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
        return "KoloreHistorialak{" +
                "id=" + id +
                ", bezeroa=" + bezeroa +
                ", produktua=" + produktua +
                ", data=" + data +
                ", kantitatea=" + kantitatea +
                ", bolumena='" + bolumena + '\'' +
                ", oharrak='" + oharrak + '\'' +
                ", sortzeData=" + sortzeData +
                ", eguneratzeData=" + eguneratzeData +
                ", ezabatzeData=" + ezabatzeData +
                '}';
    }
}
