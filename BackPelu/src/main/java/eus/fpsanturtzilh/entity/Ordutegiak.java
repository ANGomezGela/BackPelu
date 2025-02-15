package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * {@link Ordutegiak} entitateak taldeei dagozkien ordutegiak gordetzen ditu.
 * Ordutegiek eguna, hasiera eta amaiera datak eta orduak barne hartzen dituzte.
 * 
 * <p>Klase honek datu hauek gordetzen ditu:</p>
 * <ul>
 *   <li>{@code taldeak}: Taldearekin erlazionatutako ordutegia, {@link Taldeak} entitatearekin erlazionatuta.</li>
 *   <li>{@code eguna}: Ordutegia aplikatzen den eguna, zenbakizko formatuan.</li>
 *   <li>{@code hasieraData}: Ordutegiaren hasierako data.</li>
 *   <li>{@code amaieraData}: Ordutegiaren amaierako data.</li>
 *   <li>{@code hasieraOrdua}: Ordutegiaren hasierako ordua.</li>
 *   <li>{@code amaieraOrdua}: Ordutegiaren amaierako ordua.</li>
 *   <li>{@code sortzeData}: Ordutegiaren sorrerako data eta ordua.</li>
 *   <li>{@code eguneratzeData}: Ordutegiaren datuetan egindako azken eguneraketaren data eta ordua.</li>
 *   <li>{@code ezabatzeData}: Ordutegiaren ezabatzeko data, hau da, ordutegia ezabatu denean.</li>
 * </ul>
 * 
 * <p>Entitate honek Lombok liburutegia erabiltzen du, getter eta setter metodoez gain, eraikuntza erraza eta eguneratze erraza ahalbidetzen duena.</p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Entity
@Table(name = "ordutegiak")
@Data // Lombok-en anotazioa, getter eta setter guztiak automatikoki sortzen ditu.
@NoArgsConstructor // Lombok-en anotazioa, zero-argizko eraikitzailea sortzen du.
@AllArgsConstructor // Lombok-en anotazioa, eraikitzailea guztizko parametroekin sortzen du.
@Builder // Lombok-en anotazioa, eraikitzaile mota bat ematen du, objektuaren eraikuntza errazteko.
@Getter // Lombok-en anotazioa, getter guztiak automatikoki sortzen ditu.
@Setter // Lombok-en anotazioa, setter guztiak automatikoki sortzen ditu.
public class Ordutegiak {

    /**
     * Ordutegiaren identifikatzailea (auto-generatua).
     * Ordutegi bakoitzaren identifikazio bakarra.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Ordutegiaren taldeari dagozkion datuak.
     * {@link Taldeak} entitatearekin erlazionatuta, talde bakoitzari dagokion ordutegia.
     */
    @ManyToOne
    @JoinColumn(name = "kodea", nullable = false)
    private Taldeak taldeak;

    /**
     * Ordutegia aplikatzen den eguna.
     * Zenbakizko formatuan adierazten da (adibidez, 1 = Astelehena, 2 = Asteartea, ...).
     */
    @Column(name = "eguna", nullable = false)
    private Integer eguna;

    /**
     * Ordutegiaren hasiera data.
     * Ordutegiak hasten den eguna.
     */
    @Column(name = "hasiera_data", nullable = false)
    private LocalDate hasieraData;

    /**
     * Ordutegiaren amaiera data.
     * Ordutegiak amaitzen den eguna.
     */
    @Column(name = "amaiera_data", nullable = false)
    private LocalDate amaieraData;

    /**
     * Ordutegiaren hasiera ordua.
     * Ordutegiaren hastapen ordua.
     */
    @Column(name = "hasiera_ordua", nullable = false)
    private LocalTime hasieraOrdua;

    /**
     * Ordutegiaren amaiera ordua.
     * Ordutegiaren amaierako ordua.
     */
    @Column(name = "amaiera_ordua", nullable = false)
    private LocalTime amaieraOrdua;

    /**
     * Ordutegiaren sorrerako data.
     * Ordutegia sortu zen data eta ordua.
     */
    @Column(name = "sortze_data")
    private LocalDateTime sortzeData;

    /**
     * Ordutegiaren eguneratze data.
     * Ordutegiaren azken aldaketaren data eta ordua.
     */
    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData;

    /**
     * Ordutegiaren ezabatzeko data.
     * Ordutegia ezabatu zen data eta ordua.
     */
    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData;
}
