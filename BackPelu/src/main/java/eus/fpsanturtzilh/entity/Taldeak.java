package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * {@link Taldeak} entitateak taldeei buruzko informazioa gordetzen du.
 * Talde bakoitzak kodea, izena eta datu garrantzitsu batzuk, hala nola sortze, eguneratze eta ezabatze datak, ditu.
 * 
 * <p>Klase honek datu hauek gordetzen ditu:</p>
 * <ul>
 *   <li>{@code kodea}: Taldearen identifikazioa. Talde bakoitzak kode bakar bat du.</li>
 *   <li>{@code izena}: Taldearen izena, beharrezkoa den informazioa.</li>
 *   <li>{@code sortzeData}: Taldearen sorrerako data eta ordua.</li>
 *   <li>{@code eguneratzeData}: Taldearen datuetan egindako azken eguneratzeak.</li>
 *   <li>{@code ezabatzeData}: Taldearen ezabatzeko data, hau da, taldea ezabatua izan denean.</li>
 * </ul>
 * 
 * <p>Entitate honek Lombok liburutegia erabiltzen du, getter eta setter metodoez gain, eraikuntza erraza eta eguneratze erraza ahalbidetzen duena.</p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Entity
@Table(name = "taldeak")
@Data // Lombok-en anotazioa, getter eta setter guztiak automatikoki sortzen ditu.
@NoArgsConstructor // Lombok-en anotazioa, zero-argizko eraikitzailea sortzen du.
@AllArgsConstructor // Lombok-en anotazioa, eraikitzailea guztizko parametroekin sortzen du.
@Builder // Lombok-en anotazioa, eraikitzaile mota bat ematen du, objektuaren eraikuntza errazteko.
@Getter // Lombok-en anotazioa, getter guztiak automatikoki sortzen ditu.
@Setter // Lombok-en anotazioa, setter guztiak automatikoki sortzen ditu.
public class Taldeak {

    /**
     * Taldearen identifikatzailea.
     * Talde bakoitzaren kodea, maximo 5 karaktereko luzera duen tekstua.
     */
    @Id
    @Column(name = "kodea", length = 5, nullable = false)
    private String kodea;

    /**
     * Taldearen izena.
     * Talde bakoitzaren izena, 100 karaktere artekoa.
     */
    @Column(name = "izena", length = 100, nullable = false)
    private String izena;

    /**
     * Taldearen sortze data.
     * Taldearen lehenengo sorrerako data eta ordua.
     */
    @Column(name = "sortze_data")
    private LocalDateTime sortzeData;

    /**
     * Taldearen eguneratze data.
     * Taldearen datuetan egindako azken aldaketaren data eta ordua.
     */
    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData;

    /**
     * Taldearen ezabatze data.
     * Taldearen ezabatzeko data eta ordua, hau da, taldea ezabatua izan denean.
     */
    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData;
}
