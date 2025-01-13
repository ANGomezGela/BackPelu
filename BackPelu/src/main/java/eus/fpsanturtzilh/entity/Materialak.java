package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "materialak")
public class Materialak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Clave primaria autogenerada

    @Column(name = "etiketa", length = 10, nullable = false)
    private String etiketa; // Etiqueta del material

    @Column(name = "izena", length = 100, nullable = false)
    private String izena; // Nombre del material

    @ManyToOne
    @JoinColumn(name = "id_kategoria", nullable = false)
    private Kategoriak kategoriak; // Relación con la tabla `kategoriak`

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; // Fecha de creación del material

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; // Fecha de última actualización del material

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; // Fecha de eliminación lógica del material

    // Constructor vacío obligatorio para JPA
    public Materialak() {
    }

    // Constructor completo
    public Materialak(String etiketa, String izena, Kategoriak kategoriak, LocalDateTime sortzeData, LocalDateTime eguneratzeData, LocalDateTime ezabatzeData) {
        this.etiketa = etiketa;
        this.izena = izena;
        this.kategoriak = kategoriak;
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

    public String getEtiketa() {
        return etiketa;
    }

    public void setEtiketa(String etiketa) {
        this.etiketa = etiketa;
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
        return "Materialak{" +
                "id=" + id +
                ", etiketa='" + etiketa + '\'' +
                ", izena='" + izena + '\'' +
                ", kategoriak=" + kategoriak +
                ", sortzeData=" + sortzeData +
                ", eguneratzeData=" + eguneratzeData +
                ", ezabatzeData=" + ezabatzeData +
                '}';
    }
}
