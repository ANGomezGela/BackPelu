package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "material_maileguak")
public class Material_maileguak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Clave primaria autogenerada

    @ManyToOne
    @JoinColumn(name = "id_materiala", nullable = false)
    private Materialak materialak; // Relación con la tabla `materialak`

    @ManyToOne
    @JoinColumn(name = "id_langilea", nullable = false)
    private Langileak langilea; // Relación con la tabla `langileak`

    @Column(name = "hasiera_data", nullable = false)
    private LocalDateTime hasieraData; // Fecha de inicio del préstamo

    @Column(name = "amaiera_data")
    private LocalDateTime amaieraData; // Fecha de finalización del préstamo

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; // Fecha de creación del préstamo

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; // Fecha de última actualización del préstamo

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; // Fecha de eliminación lógica del préstamo

    // Constructor vacío obligatorio para JPA
    public Material_maileguak() {
    }

    // Constructor completo
    public Material_maileguak(Materialak materialak, Langileak langilea, LocalDateTime hasieraData,
                             LocalDateTime amaieraData, LocalDateTime sortzeData,
                             LocalDateTime eguneratzeData, LocalDateTime ezabatzeData) {
        this.materialak = materialak;
        this.langilea = langilea;
        this.hasieraData = hasieraData;
        this.amaieraData = amaieraData;
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

    public Materialak getMaterialak() {
        return materialak;
    }

    public void setMaterialak(Materialak materialak) {
        this.materialak = materialak;
    }

    public Langileak getLangilea() {
        return langilea;
    }

    public void setLangilea(Langileak langilea) {
        this.langilea = langilea;
    }

    public LocalDateTime getHasieraData() {
        return hasieraData;
    }

    public void setHasieraData(LocalDateTime hasieraData) {
        this.hasieraData = hasieraData;
    }

    public LocalDateTime getAmaieraData() {
        return amaieraData;
    }

    public void setAmaieraData(LocalDateTime amaieraData) {
        this.amaieraData = amaieraData;
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
        return "MaterialMaileguak{" +
                "id=" + id +
                ", materialak=" + materialak +
                ", langilea=" + langilea +
                ", hasieraData=" + hasieraData +
                ", amaieraData=" + amaieraData +
                ", sortzeData=" + sortzeData +
                ", eguneratzeData=" + eguneratzeData +
                ", ezabatzeData=" + ezabatzeData +
                '}';
    }
}
