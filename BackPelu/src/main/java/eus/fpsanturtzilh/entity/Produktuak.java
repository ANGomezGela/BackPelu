package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "produktuak")
public class Produktuak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Clave primaria autogenerada

    @Column(name = "izena", length = 100, nullable = false)
    private String izena; // Nombre del producto

    @Column(name = "deskribapena", length = 250)
    private String deskribapena; // Descripción opcional del producto

    @ManyToOne
    @JoinColumn(name = "id_kategoria", nullable = false)
    private Kategoriak kategoriak; // Relación con la tabla `kategoriak`

    @Column(name = "marka", length = 50, nullable = false)
    private String marka; // Marca del producto

    @Column(name = "stock", nullable = false)
    private Integer stock; // Cantidad disponible en inventario

    @Column(name = "stock_alerta", nullable = false)
    private Integer stockAlerta; // Cantidad mínima antes de emitir alerta

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; // Fecha de creación del producto

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; // Fecha de última actualización del producto

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; // Fecha de eliminación lógica del producto

    // Constructor vacío obligatorio para JPA
    public Produktuak() {
    }

    // Constructor completo
    public Produktuak(String izena, String deskribapena, Kategoriak kategoriak, String marka,
                      Integer stock, Integer stockAlerta, LocalDateTime sortzeData,
                      LocalDateTime eguneratzeData, LocalDateTime ezabatzeData) {
        this.izena = izena;
        this.deskribapena = deskribapena;
        this.kategoriak = kategoriak;
        this.marka = marka;
        this.stock = stock;
        this.stockAlerta = stockAlerta;
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

    public String getDeskribapena() {
        return deskribapena;
    }

    public void setDeskribapena(String deskribapena) {
        this.deskribapena = deskribapena;
    }

    public Kategoriak getKategoriak() {
        return kategoriak;
    }

    public void setKategoriak(Kategoriak kategoriak) {
        this.kategoriak = kategoriak;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStockAlerta() {
        return stockAlerta;
    }

    public void setStockAlerta(Integer stockAlerta) {
        this.stockAlerta = stockAlerta;
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
        return "Produktuak{" +
                "id=" + id +
                ", izena='" + izena + '\'' +
                ", deskribapena='" + deskribapena + '\'' +
                ", kategoriak=" + kategoriak +
                ", marka='" + marka + '\'' +
                ", stock=" + stock +
                ", stockAlerta=" + stockAlerta +
                ", sortzeData=" + sortzeData +
                ", eguneratzeData=" + eguneratzeData +
                ", ezabatzeData=" + ezabatzeData +
                '}';
    }
}
