package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * {@link Langileak} entitateak lanpostuak dituzten langileei buruzko informazioa gordetzen du.
 * Langileek talde batekin erlazionatutako datuak izan ditzakete eta lanaren historiari buruzko informazioak ere biltzen ditu,
 * hala nola izena, abizenak, sorrerako data eta eguneratzeak.
 * 
 * <p>Klase honek datu hauek gordetzen ditu:</p>
 * <ul>
 *   <li>{@code izena}: Langilearen izena, beharrezkoa eta 30 karaktere baino gehiagorik gabe.</li>
 *   <li>{@code abizenak}: Langilearen abizenak, beharrezkoa eta 100 karaktere baino gehiagorik gabe.</li>
 *   <li>{@code taldeak}: Langilea talde jakin batekin erlazionatzen da.</li>
 *   <li>{@code sortzeData}: Langilearen sorrerako data eta ordua.</li>
 *   <li>{@code eguneratzeData}: Langilearen datuetan egindako azken aldaketaren data eta ordua.</li>
 *   <li>{@code ezabatzeData}: Langilearen ezabatzeko data, hau da, erregistroa ezabatzea adierazten duena.</li>
 * </ul>
 * 
 * <p>Entitate honek Lombok liburutegia erabiltzen du, getter eta setter metodoez gain, eraikuntza erraza eta eguneratze erraza ahalbidetzen duena.</p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Entity
@Table(name = "langileak")
@Data // Lombok-en anotazioa, getter eta setter guztiak automatikoki sortzen ditu.
@NoArgsConstructor // Lombok-en anotazioa, zero-argizko eraikitzailea sortzen du.
@AllArgsConstructor // Lombok-en anotazioa, eraikitzailea guztizko parametroekin sortzen du.
@Builder // Lombok-en anotazioa, eraikitzaile mota bat ematen du, objektuaren eraikuntza errazteko.
@Getter // Lombok-en anotazioa, getter guztiak automatikoki sortzen ditu.
@Setter // Lombok-en anotazioa, setter guztiak automatikoki sortzen ditu.
public class Langileak {
    
    /**
     * Langilearen identifikatzailea (auto-generatua).
     * Langile bakoitzaren identifikatzaile bakarra.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Langilearen izena.
     * Langilearen izena, ezinbestekoa den informazioa.
     */
    @Column(name = "izena", length = 30, nullable = false)
    private String izena;

    /**
     * Langilearen abizenak.
     * Langilearen abizenak, ezinbestekoa den informazioa.
     */
    @Column(name = "abizenak", length = 100, nullable = false)
    private String abizenak;

    /**
     * Langilea talde batekin erlazionatzen da.
     * Langile bakoitzak talde jakin batekin lotura izan dezake.
     */
    @ManyToOne
    @JoinColumn(name = "kodea", nullable = false)
    private Taldeak taldeak;

    /**
     * Langilearen sorrerako data.
     * Langilearen datu-basean sartze data eta ordua.
     */
    @Column(name = "sortze_data")
    private LocalDateTime sortzeData;

    /**
     * Langilearen datuetan azken eguneraketa.
     * Langilearen datuetan egindako azken aldaketa edo eguneraketa gertatu zen data eta ordua.
     */
    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData;

    /**
     * Langilearen ezabatzeko data.
     * Langilearen erregistroaren ezabatzeko data eta ordua (ezabatzeko edo egonkor markatzeko).
     */
    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData;
}