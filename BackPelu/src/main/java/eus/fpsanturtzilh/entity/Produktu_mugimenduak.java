package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "produktu_mugimenduak")
public class Produktu_mugimenduak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Clave primaria autogenerada

    @ManyToOne
    @JoinColumn(name = "id_produktua", nullable = false)
    private Produktuak produktua; // Relación con la tabla `produktuak`

    @ManyToOne
    @JoinColumn(name = "id_langilea", nullable = false)
    private Langileak langilea; // Relación con la tabla `langileak`

    @Column(name = "data", nullable = false)
    private LocalDateTime data; // Fecha y hora del movimiento

    @Column(name = "kopurua", nullable = false)
    private Integer kopurua; // Cantidad del movimiento

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; // Fecha de creación del registro

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; // Fecha de última actualización del registro

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; // Fecha de eliminación lógica del registro

    // Constructor vacío obligatorio para JPA
    public Produktu_mugimenduak() {
    }

    // Constructor completo
    public Produktu_mugimenduak(Produktuak produktua, Langileak langilea, LocalDateTime data,
                               Integer kopurua, LocalDateTime sortzeData, LocalDateTime eguneratzeData,
                               LocalDateTime ezabatzeData) {
        this.produktua = produktua;
        this.langilea = langilea;
        this.data = data;
        this.kopurua = kopurua;
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

    public Produktuak getProduktua() {
        return produktua;
    }

    public void setProduktua(Produktuak produktua) {
        this.produktua = produktua;
    }

    public Langileak getLangilea() {
        return langilea;
    }

    public void setLangilea(Langileak langilea) {
        this.langilea = langilea;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Integer getKopurua() {
        return kopurua;
    }

    public void setKopurua(Integer kopurua) {
        this.kopurua = kopurua;
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
        return "ProduktuMugimenduak{" +
                "id=" + id +
                ", produktua=" + produktua +
                ", langilea=" + langilea +
                ", data=" + data +
                ", kopurua=" + kopurua +
                ", sortzeData=" + sortzeData +
                ", eguneratzeData=" + eguneratzeData +
                ", ezabatzeData=" + ezabatzeData +
                '}';
    }
}
