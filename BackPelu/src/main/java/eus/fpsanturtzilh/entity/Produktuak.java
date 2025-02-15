package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * {@link Produktuak} entitateak produktuen informazioa gordetzen du.
 * Produktu bakoitzak izena, deskribapena, kategoria, marka, stock kopurua eta stock alertak dituela definitzen du.
 * 
 * <p>Klase honek datu hauek gordetzen ditu:</p>
 * <ul>
 *   <li>{@code izena}: Produktuaren izena, beharrezkoa den ezaugarri bat.</li>
 *   <li>{@code deskribapena}: Produktuaren deskribapen laburra.</li>
 *   <li>{@code kategoriak}: Produktua kategoria batera sailkatzen duen informazioa, {@link Kategoriak} entitatearekin erlazionatuta.</li>
 *   <li>{@code marka}: Produktuaren marka, beharrezkoa den ezaugarri bat.</li>
 *   <li>{@code stock}: Produktuaren stock kopurua, eskuragarri dauden unitateak.</li>
 *   <li>{@code stockAlerta}: Stock txikia denean abisua jasotzeko beharrezkoa den kantitatea.</li>
 *   <li>{@code sortzeData}: Produktuaren sorrerako data eta ordua.</li>
 *   <li>{@code eguneratzeData}: Produktuaren datuetan egindako azken eguneratzeak.</li>
 *   <li>{@code ezabatzeData}: Produktuaren ezabatzeko data, hau da, produktua ezabatua izan denean.</li>
 * </ul>
 * 
 * <p>Entitate honek Lombok liburutegia erabiltzen du, getter eta setter metodoez gain, eraikuntza erraza eta eguneratze erraza ahalbidetzen duena.</p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Entity
@Table(name = "produktuak")
@Data // Lombok-en anotazioa, getter eta setter guztiak automatikoki sortzen ditu.
@NoArgsConstructor // Lombok-en anotazioa, zero-argizko eraikitzailea sortzen du.
@AllArgsConstructor // Lombok-en anotazioa, eraikitzailea guztizko parametroekin sortzen du.
@Builder // Lombok-en anotazioa, eraikitzaile mota bat ematen du, objektuaren eraikuntza errazteko.
@Getter // Lombok-en anotazioa, getter guztiak automatikoki sortzen ditu.
@Setter // Lombok-en anotazioa, setter guztiak automatikoki sortzen ditu.
public class Produktuak {

    /**
     * Produktuaren identifikatzailea (auto-generatua).
     * Produktu bakoitzaren identifikazio bakarra.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Produktuaren izena.
     * Beharrezkoa den informazioa produktu bakoitzarentzat.
     */
    @Column(name = "izena", length = 100, nullable = false)
    private String izena;

    /**
     * Produktuaren deskribapena.
     * Produktuaren xehetasunak azaltzen dituen informazioa.
     */
    @Column(name = "deskribapena", length = 250)
    private String deskribapena;

    /**
     * Produktuaren kategoria.
     * {@link Kategoriak} entitatearekin erlazionatuta, produktu bakoitzak kategoria bat izaten du.
     */
    @ManyToOne
    @JoinColumn(name = "id_kategoria", nullable = false)
    private Kategoriak kategoriak;

    /**
     * Produktuaren marka.
     * Produktuaren marka zehazten duen informazioa.
     */
    @Column(name = "marka", length = 50, nullable = false)
    private String marka;

    /**
     * Produktuaren stock kopurua.
     * Eskaerak betetzeko eskuragarri dauden produktu unitateak.
     */
    @Column(name = "stock", nullable = false)
    private Integer stock;

    /**
     * Stock alertaren kopurua.
     * Produktuaren stock kopurua txikia denean abisua jasotzeko beharrezkoa den kantitatea.
     */
    @Column(name = "stock_alerta", nullable = false)
    private Integer stockAlerta;

    /**
     * Produktuaren sortze data.
     * Produktuaren lehenengo sorrerako data eta ordua.
     */
    @Column(name = "sortze_data")
    private LocalDateTime sortzeData;

    /**
     * Produktuaren eguneratze data.
     * Produktuaren datuetan egindako azken aldaketaren data eta ordua.
     */
    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData;

    /**
     * Produktuaren ezabatze data.
     * Produktuaren ezabatzeko data eta ordua, hau da, produktua ezabatua izan denean.
     */
    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData;
}
