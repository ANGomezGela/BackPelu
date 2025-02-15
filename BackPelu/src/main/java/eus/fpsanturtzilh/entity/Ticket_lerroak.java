package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * {@link Ticket_lerroak} entitateak tiketeko lerroei buruzko informazioa gordetzen du.
 * Tiketek zerbitzuak eta hitzorduak lotzen dituzte, baita prezioak eta datu garrantzitsuak ere, hala nola sortze, eguneratze eta ezabatze datak.
 * 
 * <p>Klase honek datu hauek gordetzen ditu:</p>
 * <ul>
 *   <li>{@code id}: Tiketeko lerroaren identifikazioa. Lerro bakoitzak identifikazio bakarra izango du.</li>
 *   <li>{@code hitzordua}: Tiketearen lotura duen hitzordua. Hitzordu honek zerbitzuaren erabilera jasotzen du.</li>
 *   <li>{@code zerbitzua}: Tiketearen lotura duen zerbitzua, erabiltzaileak jaso dezakeena.</li>
 *   <li>{@code prezioa}: Tiketearen prezioa, kontabilitatean erabiltzen den zenbatekoa.</li>
 *   <li>{@code sortzeData}: Tiketearen sorrerako data eta ordua.</li>
 *   <li>{@code eguneratzeData}: Tiketearen datuetan egindako azken eguneratzeak.</li>
 *   <li>{@code ezabatzeData}: Tiketearen ezabatze data, hau da, tiketearen ezabatzeko data eta ordua.</li>
 * </ul>
 * 
 * <p>Entitate honek Lombok liburutegia erabiltzen du, getter eta setter metodoez gain, eraikuntza erraza eta eguneratze erraza ahalbidetzen duena.</p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Entity
@Table(name = "ticket_lerroak")
@Data // Lombok-en anotazioa, getter eta setter guztiak automatikoki sortzen ditu.
@NoArgsConstructor // Lombok-en anotazioa, zero-argizko eraikitzailea sortzen du.
@AllArgsConstructor // Lombok-en anotazioa, eraikitzailea guztizko parametroekin sortzen du.
@Builder // Lombok-en anotazioa, eraikitzaile mota bat ematen du, objektuaren eraikuntza errazteko.
@Getter // Lombok-en anotazioa, getter guztiak automatikoki sortzen ditu.
@Setter // Lombok-en anotazioa, setter guztiak automatikoki sortzen ditu.
public class Ticket_lerroak {

    /**
     * Tiketeko lerroaren identifikatzailea.
     * Tiketeko lerro bakoitzak identifikazio bakar bat izango du.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Tiketearen lotura duen hitzordua.
     * Hitzorduak zerbitzuaren erabilera jasotzen du eta tiketearen erabilera agertzen du.
     */
    @ManyToOne
    @JoinColumn(name = "id_hitzordua", nullable = false)
    private Hitzorduak hitzordua;

    /**
     * Tiketearen lotura duen zerbitzua.
     * Zerbitzuak erabiltzaileari ematen zaion zerbitzua da.
     */
    @ManyToOne
    @JoinColumn(name = "id_zerbitzua", nullable = false)
    private Zerbitzuak zerbitzua;

    /**
     * Tiketearen prezioa.
     * Prezioa kontabilitatean erabiltzen den zenbatekoa izango da.
     */
    @Column(name = "prezioa", nullable = false)
    private BigDecimal prezioa;

    /**
     * Tiketearen sortze data.
     * Tiketearen lehenengo sorrerako data eta ordua.
     */
    @Column(name = "sortze_data")
    private LocalDateTime sortzeData;

    /**
     * Tiketearen eguneratze data.
     * Tiketearen datuetan egindako azken aldaketaren data eta ordua.
     */
    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData;

    /**
     * Tiketearen ezabatze data.
     * Tiketearen ezabatzeko data eta ordua, hau da, tiketearen ezabatua izan denean.
     */
    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData;
}
