package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "hitzorduak")
public class Hitzorduak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Clave primaria autogenerada

    @Column(name = "eserlekua", nullable = true)
    private Integer eserlekua; // Número de asiento

    @Column(name = "data", nullable = false)
    private LocalDate data; // Fecha del turno

    @Column(name = "hasiera_ordua", nullable=true)
    private LocalTime hasieraOrdua; // Hora de inicio

    @Column(name = "amaiera_ordua", nullable=true)
    private LocalTime amaieraOrdua; // Hora de fin

    @Column(name = "hasiera_ordua_erreala")
    private LocalTime hasieraOrduaErreala; // Hora de inicio real (opcional)

    @Column(name = "amaiera_ordua_erreala")
    private LocalTime amaieraOrduaErreala; // Hora de fin real (opcional)

    @Column(name = "izena", length = 100, nullable = false)
    private String izena; // Nombre de la persona

    @Column(name = "telefonoa", length = 9)
    private String telefonoa; // Teléfono de contacto

    @Column(name = "deskribapena", length = 250)
    private String deskribapena; // Descripción opcional

    @Column(name = "etxekoa", length = 1, nullable = true)
    private String etxekoa; // 'E' (Etxeko) o 'K' (Kanpoko)

    @Column(name = "prezio_totala")
    private BigDecimal prezioTotala; // Precio total del turno

    @ManyToOne
    @JoinColumn(name = "id_langilea")
    private Langileak langilea; // Relación con la tabla `langileak`

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; // Fecha de creación del turno

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; // Fecha de última actualización del turno

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; // Fecha de eliminación lógica del turno

    // Constructor vacío obligatorio para JPA
    public Hitzorduak() {
    }

    // Constructor completo
    public Hitzorduak(Integer eserlekua, LocalDate data, LocalTime hasieraOrdua, LocalTime amaieraOrdua,
                      LocalTime hasieraOrduaErreala, LocalTime amaieraOrduaErreala, String izena,
                      String telefonoa, String deskribapena, String etxekoa, BigDecimal prezioTotala,
                      Langileak langilea, LocalDateTime sortzeData, LocalDateTime eguneratzeData, LocalDateTime ezabatzeData) {
        this.eserlekua = eserlekua;
        this.data = data;
        this.hasieraOrdua = hasieraOrdua;
        this.amaieraOrdua = amaieraOrdua;
        this.hasieraOrduaErreala = hasieraOrduaErreala;
        this.amaieraOrduaErreala = amaieraOrduaErreala;
        this.izena = izena;
        this.telefonoa = telefonoa;
        this.deskribapena = deskribapena;
        this.etxekoa = etxekoa;
        this.prezioTotala = prezioTotala;
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

    public Integer getEserlekua() {
        return eserlekua;
    }

    public void setEserlekua(Integer eserlekua) {
        this.eserlekua = eserlekua;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHasieraOrdua() {
        return hasieraOrdua;
    }

    public void setHasieraOrdua(LocalTime hasieraOrdua) {
        this.hasieraOrdua = hasieraOrdua;
    }

    public LocalTime getAmaieraOrdua() {
        return amaieraOrdua;
    }

    public void setAmaieraOrdua(LocalTime amaieraOrdua) {
        this.amaieraOrdua = amaieraOrdua;
    }

    public LocalTime getHasieraOrduaErreala() {
        return hasieraOrduaErreala;
    }

    public void setHasieraOrduaErreala(LocalTime hasieraOrduaErreala) {
        this.hasieraOrduaErreala = hasieraOrduaErreala;
    }

    public LocalTime getAmaieraOrduaErreala() {
        return amaieraOrduaErreala;
    }

    public void setAmaieraOrduaErreala(LocalTime amaieraOrduaErreala) {
        this.amaieraOrduaErreala = amaieraOrduaErreala;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getTelefonoa() {
        return telefonoa;
    }

    public void setTelefonoa(String telefonoa) {
        this.telefonoa = telefonoa;
    }

    public String getDeskribapena() {
        return deskribapena;
    }

    public void setDeskribapena(String deskribapena) {
        this.deskribapena = deskribapena;
    }

    public String getEtxekoa() {
        return etxekoa;
    }

    public void setEtxekoa(String etxekoa) {
        this.etxekoa = etxekoa;
    }

    public BigDecimal getPrezioTotala() {
        return prezioTotala;
    }

    public void setPrezioTotala(BigDecimal prezioTotala) {
        this.prezioTotala = prezioTotala;
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
        return "Hitzorduak{" +
                "id=" + id +
                ", eserlekua=" + eserlekua +
                ", data=" + data +
                ", hasieraOrdua=" + hasieraOrdua +
                ", amaieraOrdua=" + amaieraOrdua +
                ", hasieraOrduaErreala=" + hasieraOrduaErreala +
                ", amaieraOrduaErreala=" + amaieraOrduaErreala +
                ", izena='" + izena + '\'' +
                ", telefonoa='" + telefonoa + '\'' +
                ", deskribapena='" + deskribapena + '\'' +
                ", etxekoa='" + etxekoa + '\'' +
                ", prezioTotala=" + prezioTotala +
                ", langilea=" + langilea +
                ", sortzeData=" + sortzeData +
                ", eguneratzeData=" + eguneratzeData +
                ", ezabatzeData=" + ezabatzeData +
                '}';
    }
}
