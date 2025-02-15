package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * {@link Bezero_fitxak} entitateak bezeroen datuak kudeatzen ditu.
 * Honek bezeroen izenak, abizenak, telefonoak eta beste informazio garrantzitsua biltegiratzen du.
 * Entitate honek datu-basean "bezero_fitxak" izeneko taula bat du.
 * 
 * <p>Klase honek datu hauen eguneratzeak eta ezabaketak ere kudeatzen ditu:</p>
 * <ul>
 *   <li>{@code id}: Bezeroaren identifikatzailea (autoincrementala).</li>
 *   <li>{@code izena}: Bezeroaren izena.</li>
 *   <li>{@code abizena}: Bezeroaren abizena.</li>
 *   <li>{@code telefonoa}: Bezeroaren telefono zenbakia.</li>
 *   <li>{@code azalSentikorra}: Bezeroaren azala sentikorra den adierazlea (bai/ez).</li>
 *   <li>{@code sortzeData}: Bezeroaren sortze data.</li>
 *   <li>{@code eguneratzeData}: Bezeroaren azken eguneratze data.</li>
 *   <li>{@code ezabatzeData}: Bezeroaren ezabaketaren data (egonkor markatzeko).</li>
 * </ul>
 * 
 * <p>Entitate honek Lombok liburutegia erabiltzen du, getter eta setter metodoez gain, eraikuntza erraza eta eguneratze erraza ahalbidetzen duena.</p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Entity
@Table(name = "bezero_fitxak")
@Data // Lombok-en anotazioa, getter eta setter guztiak automatikoki sortzen ditu.
@NoArgsConstructor // Lombok-en anotazioa, zero-argizko eraikitzailea sortzen du.
@AllArgsConstructor // Lombok-en anotazioa, eraikitzailea guztizko parametroekin sortzen du.
@Builder // Lombok-en anotazioa, eraikitzaile mota bat ematen du, objektuaren eraikuntza errazteko.
@Getter // Lombok-en anotazioa, getter guztiak automatikoki sortzen ditu.
@Setter // Lombok-en anotazioa, setter guztiak automatikoki sortzen ditu.
public class Bezero_fitxak {

    /**
     * Bezeroaren identifikatzailea. Taulan auto-inkremental bat bezala definitua.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    /**
     * Bezeroaren izena. 
     * Ez da hutsik utzi behar eta gehienez 100 karaktere izan ditzake.
     */
    @Column(name = "izena", length = 100, nullable = false)
    private String izena; 

    /**
     * Bezeroaren abizena.
     * Ez da hutsik utzi behar eta gehienez 200 karaktere izan ditzake.
     */
    @Column(name = "abizena", length = 200, nullable = false)
    private String abizena; 

    /**
     * Bezeroaren telefono zenbakia.
     * Gehienez 9 karaktere izan ditzake eta aukera da hutsik uztea.
     */
    @Column(name = "telefonoa", length = 9)
    private String telefonoa; 

    /**
     * Bezeroaren azala sentikorra den adierazlea.
     * 1 karaktereko string-a izan behar du (bai edo ez).
     */
    @Column(name = "azal_sentikorra", length = 1, nullable = false)
    private String azalSentikorra; 

    /**
     * Bezeroaren sortze data.
     * Data eta ordua gordetzen ditu.
     */
    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; 

    /**
     * Bezeroaren azken eguneratze data.
     * Data eta ordua gordetzen ditu.
     */
    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; 

    /**
     * Bezeroaren ezabaketaren data.
     * Bezeroaren fitxak egonkor markatzea adierazten du.
     */
    @Column(name = "ezabatze_data")
    private LocalDate ezabatzeData; 
}
