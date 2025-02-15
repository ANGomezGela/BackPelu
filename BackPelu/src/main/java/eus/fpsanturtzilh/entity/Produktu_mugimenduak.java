package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * {@link Produktu_mugimenduak} entitateak produktuen mugimenduak (sarrera eta irteerak) kudeatzen ditu.
 * Mugimendu bakoitzak produktuen kantitatea eta langilea izendatzen ditu.
 * 
 * <p>Klase honek datu hauek gordetzen ditu:</p>
 * <ul>
 *   <li>{@code produktua}: Produktuarekin erlazionatutako mugimendua, {@link Produktuak} entitatearekin erlazionatuta.</li>
 *   <li>{@code langilea}: Mugimendua kudeatzen duen langilea, {@link Langileak} entitatearekin erlazionatuta.</li>
 *   <li>{@code data}: Mugimenduaren data eta ordua, produktuaren sarrera edo irteera egina izan den momentua.</li>
 *   <li>{@code kopurua}: Mugimenduan transferitu den produktuen kopurua.</li>
 *   <li>{@code sortzeData}: Produktuaren mugimenduaren sorrerako data eta ordua.</li>
 *   <li>{@code eguneratzeData}: Produktuaren mugimenduaren datuetan egindako azken eguneraketaren data eta ordua.</li>
 *   <li>{@code ezabatzeData}: Produktuaren mugimenduaren ezabatzeko data, hau da, mugimendua ezabatua izan denean.</li>
 * </ul>
 * 
 * <p>Entitate honek Lombok liburutegia erabiltzen du, getter eta setter metodoez gain, eraikuntza erraza eta eguneratze erraza ahalbidetzen duena.</p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Entity
@Table(name = "produktu_mugimenduak")
@Data // Lombok-en anotazioa, getter eta setter guztiak automatikoki sortzen ditu.
@NoArgsConstructor // Lombok-en anotazioa, zero-argizko eraikitzailea sortzen du.
@AllArgsConstructor // Lombok-en anotazioa, eraikitzailea guztizko parametroekin sortzen du.
@Builder // Lombok-en anotazioa, eraikitzaile mota bat ematen du, objektuaren eraikuntza errazteko.
@Getter // Lombok-en anotazioa, getter guztiak automatikoki sortzen ditu.
@Setter // Lombok-en anotazioa, setter guztiak automatikoki sortzen ditu.
public class Produktu_mugimenduak {

    /**
     * Produktu mugimenduaren identifikatzailea (auto-generatua).
     * Produktu mugimendu bakoitzaren identifikazio bakarra.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Produktuarekin erlazionatutako mugimendua.
     * {@link Produktuak} entitatearekin erlazionatuta, produktu bakoitzak mugimendu bat izaten du.
     */
    @ManyToOne
    @JoinColumn(name = "id_produktua", nullable = false)
    private Produktuak produktua;

    /**
     * Langilea, produktua kudeatzen duen pertsona.
     * {@link Langileak} entitatearekin erlazionatuta, langile bakoitzak produktu mugimendu bat izaten du.
     */
    @ManyToOne
    @JoinColumn(name = "id_langilea", nullable = false)
    private Langileak langilea;

    /**
     * Produktuaren mugimenduaren data eta ordua.
     * Sarrera edo irteera egin den momentua.
     */
    @Column(name = "data", nullable = false)
    private LocalDateTime data;

    /**
     * Produktuaren mugimenduan transferitu den kantitatea.
     * Produktuaren sarrera edo irteera kopurua.
     */
    @Column(name = "kopurua", nullable = false)
    private Integer kopurua;

    /**
     * Produktu mugimenduaren sorrerako data.
     * Produktu mugimenduaren hasierako data eta ordua.
     */
    @Column(name = "sortze_data")
    private LocalDateTime sortzeData;

    /**
     * Produktu mugimenduaren eguneratze data.
     * Produktu mugimenduaren azken aldaketaren data eta ordua.
     */
    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData;

    /**
     * Produktu mugimenduaren ezabatzeko data.
     * Produktu mugimendua ezabatu den data eta ordua.
     */
    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData;
}
