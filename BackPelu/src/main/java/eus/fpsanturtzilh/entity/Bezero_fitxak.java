package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bezero_fitxak")
public class Bezero_fitxak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Clave primaria autogenerada

    @Column(name = "izena", length = 100, nullable = false)
    private String izena; // Nombre del cliente

    @Column(name = "abizena", length = 200, nullable = false)
    private String abizena; // Apellido del cliente

    @Column(name = "telefonoa", length = 9)
    private String telefonoa; // Teléfono del cliente (opcional)

    @Column(name = "azal_sentikorra", length = 1, nullable = false)
    private String azalSentikorra; // Si la piel es sensible ('B' o 'E')

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; // Fecha de creación del cliente

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; // Fecha de última actualización del cliente

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; // Fecha de eliminación lógica del cliente

    // Constructor vacío obligatorio para JPA
    public Bezero_fitxak() {
    }

    // Constructor completo
    public Bezero_fitxak(String izena, String abizena, String telefonoa, String azalSentikorra,
                        LocalDateTime sortzeData, LocalDateTime eguneratzeData, LocalDateTime ezabatzeData) {
        this.izena = izena;
        this.abizena = abizena;
        this.telefonoa = telefonoa;
        this.azalSentikorra = azalSentikorra;
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

    public String getAbizena() {
        return abizena;
    }

    public void setAbizena(String abizena) {
        this.abizena = abizena;
    }

    public String getTelefonoa() {
        return telefonoa;
    }

    public void setTelefonoa(String telefonoa) {
        this.telefonoa = telefonoa;
    }

    public String getAzalSentikorra() {
        return azalSentikorra;
    }

    public void setAzalSentikorra(String azalSentikorra) {
        this.azalSentikorra = azalSentikorra;
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
        return "BezeroFitxak{" +
                "id=" + id +
                ", izena='" + izena + '\'' +
                ", abizena='" + abizena + '\'' +
                ", telefonoa='" + telefonoa + '\'' +
                ", azalSentikorra='" + azalSentikorra + '\'' +
                ", sortzeData=" + sortzeData +
                ", eguneratzeData=" + eguneratzeData +
                ", ezabatzeData=" + ezabatzeData +
                '}';
    }
}
