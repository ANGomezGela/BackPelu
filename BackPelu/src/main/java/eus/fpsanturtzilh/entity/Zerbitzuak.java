package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * {@link Zerbitzuak} entitateak zerbitzuen informazioa gordetzen du, hala nola zerbitzuaren izena, kategoria, prezioak eta datu garrantzitsuak.
 * Zerbitzu bakoitzak prezio bat izango du, etxean eta kanpoan ematen den zerbitzuaren arabera.
 * 
 * <p>Klase honek datu hauek gordetzen ditu:</p>
 * <ul>
 *   <li>{@code id}: Zerbitzuaren identifikazioa. Zerbitzu bakoitzak identifikazio bakarra izango du.</li>
 *   <li>{@code izena}: Zerbitzuaren izena, zerbitzu horren deskribapena ematen duena.</li>
 *   <li>{@code kategoriak}: Zerbitzuaren kategoria, zerbitzu mota sailkatzeko erabiltzen dena.</li>
 *   <li>{@code etxekoPrezioa}: Etxean emandako zerbitzuaren prezioa.</li>
 *   <li>{@code kanpokoPrezioa}: Kanpoan emandako zerbitzuaren prezioa.</li>
 *   <li>{@code sortzeData}: Zerbitzuaren sorrerako data eta ordua.</li>
 *   <li>{@code eguneratzeData}: Zerbitzuaren datuetan egindako azken eguneratzeak.</li>
 *   <li>{@code ezabatzeData}: Zerbitzuaren ezabatze data, hau da, zerbitzu hori ezabatu den data eta ordua.</li>
 * </ul>
 * 
 * <p>Entitate honek Lombok liburutegia erabiltzen du, getter eta setter metodoez gain, eraikuntza erraza eta eguneratze erraza ahalbidetzen duena.</p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Entity
@Table(name = "zerbitzuak")
@Data // Lombok-en anotazioa, getter eta setter guztiak automatikoki sortzen ditu.
@NoArgsConstructor // Lombok-en anotazioa, zero-argizko eraikitzailea sortzen du.
@AllArgsConstructor // Lombok-en anotazioa, eraikitzailea guztizko parametroekin sortzen du.
@Builder // Lombok-en anotazioa, eraikitzaile mota bat ematen du, objektuaren eraikuntza errazteko.
@Getter // Lombok-en anotazioa, getter guztiak automatikoki sortzen ditu.
@Setter // Lombok-en anotazioa, setter guztiak automatikoki sortzen ditu.
public class Zerbitzuak {

    /**
     * Zerbitzuaren identifikatzailea.
     * Zerbitzu bakoitzak identifikazio bakarra izango du.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Zerbitzuaren izena.
     * Zerbitzuaren izena, zerbitzu horren deskribapena ematen duena.
     */
    @Column(name = "izena", length = 100, nullable = false)
    private String izena;

    /**
     * Zerbitzuaren kategoria.
     * Zerbitzu mota sailkatzeko erabiltzen den kategoria.
     */
    @ManyToOne
    @JoinColumn(name = "id_kategoria", nullable = false)
    private Kategoriak kategoriak;

    /**
     * Etxeko zerbitzuaren prezioa.
     * Etxean emandako zerbitzuaren prezioa, bezeroek ordaintzen dutena.
     */
    @Column(name = "etxeko_prezioa", nullable = false)
    private BigDecimal etxekoPrezioa;

    /**
     * Kanpoko zerbitzuaren prezioa.
     * Kanpoan emandako zerbitzuaren prezioa, bezeroek ordaintzen dutena.
     */
    @Column(name = "kanpoko_prezioa", nullable = false)
    private BigDecimal kanpokoPrezioa;

    /**
     * Zerbitzuaren sortze data.
     * Zerbitzuaren lehenengo sorrerako data eta ordua.
     */
    @Column(name = "sortze_data")
    private LocalDateTime sortzeData;

    /**
     * Zerbitzuaren eguneratze data.
     * Zerbitzuaren datuetan egindako azken aldaketaren data eta ordua.
     */
    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData;

    /**
     * Zerbitzuaren ezabatze data.
     * Zerbitzuaren ezabatze data eta ordua, hau da, zerbitzu hori ezabatu denean.
     */
    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData;
}
