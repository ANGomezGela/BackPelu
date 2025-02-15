package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * {@link Kategoriak} entitateak kategoriak kudeatzen ditu.
 * Honek kategoriaren izena eta kategoriaren estatistika garrantzitsuak gordetzen ditu.
 * Entitate honek datu-basean "kategoriak" izeneko taula bat du.
 * 
 * <p>Klase honek datu hauen eguneratzeak eta ezabaketak ere kudeatzen ditu:</p>
 * <ul>
 *   <li>{@code izena}: Kategoriaren izena (beharrezkoa).</li>
 *   <li>{@code sortzeData}: Kategoria sortu zen data (hitzordua sistema batean sortu zen data).</li>
 *   <li>{@code eguneratzeData}: Kategoria eguneratu zen azken data (eguneratzeen azken data).</li>
 *   <li>{@code ezabatzeData}: Kategoria ezabatu edo egonkor markatutako data (ezabatze edo egonkor markatzea adierazten du).</li>
 * </ul>
 * 
 * <p>Entitate honek Lombok liburutegia erabiltzen du, getter eta setter metodoez gain, eraikuntza erraza eta eguneratze erraza ahalbidetzen duena.</p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Entity
@Table(name = "kategoriak")
@Data // Lombok-en anotazioa, getter eta setter guztiak automatikoki sortzen ditu.
@NoArgsConstructor // Lombok-en anotazioa, zero-argizko eraikitzailea sortzen du.
@AllArgsConstructor // Lombok-en anotazioa, eraikitzailea guztizko parametroekin sortzen du.
@Builder // Lombok-en anotazioa, eraikitzaile mota bat ematen du, objektuaren eraikuntza errazteko.
@Getter // Lombok-en anotazioa, getter guztiak automatikoki sortzen ditu.
@Setter // Lombok-en anotazioa, setter guztiak automatikoki sortzen ditu.
public class Kategoriak {
    
    /**
     * Kategoriaren identifikatzailea (auto-generatua).
     * Kategoriaren lehenengo identifikatzailea (auto-generatua).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Kategoriaren izena.
     * Kategoriaren izena ezagutzea beharrezkoa da.
     */
    @Column(name = "izena", length = 100, nullable = false)
    private String izena;

    /**
     * Kategoriaren sortze data.
     * Kategoria sortu zen data eta ordua (hitzordua sistema batean sortu zen data).
     */
    @Column(name = "sortze_data")
    private LocalDateTime sortzeData;

    /**
     * Kategoriaren azken eguneratze data.
     * Kategoriaren azken aldaketa edo eguneraketa gertatu zen data eta ordua.
     */
    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData;

    /**
     * Kategoriaren ezabatzeko data.
     * Kategoria ezabatze edo egonkor markatzea adierazten duen data eta ordua.
     */
    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData;
}
