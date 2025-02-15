package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * {@link Txandak} entitateak langileek egiten dituzten txandekiko informazioa gordetzen du.
 * Txandak mota, data eta langileari dagozkion datu garrantzitsuak biltzen ditu, hala nola sortze, eguneratze eta ezabatze datak.
 * 
 * <p>Klase honek datu hauek gordetzen ditu:</p>
 * <ul>
 *   <li>{@code id}: Txandaren identifikazioa. Txanda bakoitzak identifikazio bakarra izango du.</li>
 *   <li>{@code mota}: Txandaren mota, adibidez, goizekoa edo arratsaldekoa den adierazteko.</li>
 *   <li>{@code data}: Txandaren eguna, langileak lan egiten duen eguna.</li>
 *   <li>{@code langilea}: Txandarekin lotutako langilea. Langile honek txanda hori betetzen du.</li>
 *   <li>{@code sortzeData}: Txandaren sorrerako data eta ordua.</li>
 *   <li>{@code eguneratzeData}: Txandaren datuetan egindako azken eguneratzeak.</li>
 *   <li>{@code ezabatzeData}: Txandaren ezabatze data, hau da, txanda hori ezabatu den data eta ordua.</li>
 * </ul>
 * 
 * <p>Entitate honek Lombok liburutegia erabiltzen du, getter eta setter metodoez gain, eraikuntza erraza eta eguneratze erraza ahalbidetzen duena.</p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Entity
@Table(name = "txandak")
@Data // Lombok-en anotazioa, getter eta setter guztiak automatikoki sortzen ditu.
@NoArgsConstructor // Lombok-en anotazioa, zero-argizko eraikitzailea sortzen du.
@AllArgsConstructor // Lombok-en anotazioa, eraikitzailea guztizko parametroekin sortzen du.
@Builder // Lombok-en anotazioa, eraikitzaile mota bat ematen du, objektuaren eraikuntza errazteko.
@Getter // Lombok-en anotazioa, getter guztiak automatikoki sortzen ditu.
@Setter // Lombok-en anotazioa, setter guztiak automatikoki sortzen ditu.
public class Txandak {

    /**
     * Txandaren identifikatzailea.
     * Txanda bakoitzak identifikazio bakarra izango du.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Txandaren mota.
     * Txanda mota, hala nola, goizekoa edo arratsaldekoa, zehazteko erabiltzen da.
     */
    @Column(name = "mota", length = 1, nullable = false)
    private String mota;

    /**
     * Txandaren data.
     * Txandaren eguna adierazten du, langileak lan egiten duen eguna.
     */
    @Column(name = "data", nullable = false)
    private LocalDate data;

    /**
     * Txandarekin lotutako langilea.
     * Langileak txanda hori betetzen du eta txandaren egunak zehazten du.
     */
    @ManyToOne
    @JoinColumn(name = "id_langilea", nullable = false)
    private Langileak langilea;

    /**
     * Txandaren sortze data.
     * Txandaren lehenengo sorrerako data eta ordua.
     */
    @Column(name = "sortze_data")
    private LocalDateTime sortzeData;

    /**
     * Txandaren eguneratze data.
     * Txandaren datuetan egindako azken aldaketaren data eta ordua.
     */
    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData;

    /**
     * Txandaren ezabatze data.
     * Txandaren ezabatze data eta ordua, hau da, txanda hori ezabatu denean.
     */
    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData;
}
