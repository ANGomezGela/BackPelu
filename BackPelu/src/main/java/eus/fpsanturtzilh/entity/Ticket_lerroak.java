package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket_lerroak")
public class Ticket_lerroak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Clave primaria autogenerada

    @ManyToOne
    @JoinColumn(name = "id_hitzordua", nullable = false)
    private Hitzorduak hitzordua; // Relación con la tabla `hitzorduak`

    @ManyToOne
    @JoinColumn(name = "id_zerbitzua", nullable = false)
    private Zerbitzuak zerbitzua; // Relación con la tabla `zerbitzuak`

    @Column(name = "prezioa", nullable = false)
    private BigDecimal prezioa; // Precio asociado a la línea del ticket

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; // Fecha de creación de la línea

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; // Fecha de última actualización de la línea

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; // Fecha de eliminación lógica de la línea

    // Constructor vacío obligatorio para JPA
    public Ticket_lerroak() {
    }

    // Constructor completo
    public Ticket_lerroak(Hitzorduak hitzordua, Zerbitzuak zerbitzua, BigDecimal prezioa,
                         LocalDateTime sortzeData, LocalDateTime eguneratzeData, LocalDateTime ezabatzeData) {
        this.hitzordua = hitzordua;
        this.zerbitzua = zerbitzua;
        this.prezioa = prezioa;
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

    public Hitzorduak getHitzordua() {
        return hitzordua;
    }

    public void setHitzordua(Hitzorduak hitzordua) {
        this.hitzordua = hitzordua;
    }

    public Zerbitzuak getZerbitzua() {
        return zerbitzua;
    }

    public void setZerbitzua(Zerbitzuak zerbitzua) {
        this.zerbitzua = zerbitzua;
    }

    public BigDecimal getPrezioa() {
        return prezioa;
    }

    public void setPrezioa(BigDecimal prezioa) {
        this.prezioa = prezioa;
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
        return "TicketLerroak{" +
                "id=" + id +
                ", hitzordua=" + hitzordua +
                ", zerbitzua=" + zerbitzua +
                ", prezioa=" + prezioa +
                ", sortzeData=" + sortzeData +
                ", eguneratzeData=" + eguneratzeData +
                ", ezabatzeData=" + ezabatzeData +
                '}';
    }
}
