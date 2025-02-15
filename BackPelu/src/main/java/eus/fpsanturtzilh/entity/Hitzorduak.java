package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * {@link Hitzorduak} entitateak hitzordu bakoitzaren informazioa kudeatzen du.
 * Honek hitzorduaren datak, ordutegiak, prezioa eta beste xehetasun batzuk biltegiratzen ditu.
 * Entitate honek datu-basean "hitzorduak" izeneko taula bat du.
 * 
 * <p>Klase honek datu hauen eguneratzeak eta ezabaketak ere kudeatzen ditu:</p>
 * <ul>
 *   <li>{@code eserlekua}: Hitzordurako esleituriko eserlekua (balio bat izan dezake).</li>
 *   <li>{@code data}: Hitzorduko data (beharrezkoa).</li>
 *   <li>{@code hasieraOrdua}: Hitzorduko hasiera ordua (balioztatu daiteke).</li>
 *   <li>{@code amaieraOrdua}: Hitzorduko amaiera ordua (balioztatu daiteke).</li>
 *   <li>{@code hasieraOrduaErreala}: Hasiera ordua benetan gertatu zen (balioztatu daiteke).</li>
 *   <li>{@code amaieraOrduaErreala}: Amaiera ordua benetan gertatu zen (balioztatu daiteke).</li>
 *   <li>{@code izena}: Hitzordura etorritako pertsonaren izena (beharrezkoa).</li>
 *   <li>{@code telefonoa}: Pertsonaren telefono zenbakia (balioztatu daiteke).</li>
 *   <li>{@code deskribapena}: Hitzorduari buruzko deskribapen edo xehetasunak (balioztatu daiteke).</li>
 *   <li>{@code etxekoa}: Hitzordua etxeko edo kanpoko pertsonarentzat den adierazlea (balioztatu daiteke).</li>
 *   <li>{@code prezioTotala}: Hitzorduko prezioa.</li>
 *   <li>{@code langilea}: Langilearekin duen erlazioa (langilea kudeatzen duen pertsona).</li>
 *   <li>{@code sortzeData}: Hitzordua sortu zen data (hitzordua sistema batean sortutako data).</li>
 *   <li>{@code eguneratzeData}: Hitzordua eguneratze data (hitzordua azken aldiz eguneratu zen data).</li>
 *   <li>{@code ezabatzeData}: Hitzordua ezabatu edo egonkor markatutako data (ezabatzeko data).</li>
 * </ul>
 * 
 * <p>Entitate honek Lombok liburutegia erabiltzen du, getter eta setter metodoez gain, eraikuntza erraza eta eguneratze erraza ahalbidetzen duena.</p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Entity
@Table(name = "hitzorduak")
@Data // Lombok-en anotazioa, getter eta setter guztiak automatikoki sortzen ditu.
@NoArgsConstructor // Lombok-en anotazioa, zero-argizko eraikitzailea sortzen du.
@AllArgsConstructor // Lombok-en anotazioa, eraikitzailea guztizko parametroekin sortzen du.
@Builder // Lombok-en anotazioa, eraikitzaile mota bat ematen du, objektuaren eraikuntza errazteko.
@Getter // Lombok-en anotazioa, getter guztiak automatikoki sortzen ditu.
@Setter // Lombok-en anotazioa, setter guztiak automatikoki sortzen ditu.
public class Hitzorduak {

    /**
     * Hitzorduaren identifikatzailea (auto-generatua).
     * Hitzorduko lehenengo identifikatzailea (auto-generatua).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Hitzordurako esleituriko eserlekua.
     * Honek eserlekua adierazten du, baliozko zenbakia izan dezake.
     */
    @Column(name = "eserlekua", nullable = true)
    private Integer eserlekua;

    /**
     * Hitzorduko data.
     * Hitzorduaren data (beharrezkoa da).
     */
    @Column(name = "data", nullable = false)
    private LocalDate data;

    /**
     * Hitzorduko hasiera ordua.
     * Hitzorduaren hasiera ordua (balioztatu daiteke).
     */
    @Column(name = "hasiera_ordua", nullable=true)
    private LocalTime hasieraOrdua;

    /**
     * Hitzorduko amaiera ordua.
     * Hitzorduaren amaiera ordua (balioztatu daiteke).
     */
    @Column(name = "amaiera_ordua", nullable=true)
    private LocalTime amaieraOrdua;

    /**
     * Hitzorduaren hasiera ordua benetan gertatu zena.
     * Erreala den hasiera ordua (balioztatu daiteke).
     */
    @Column(name = "hasiera_ordua_erreala")
    private LocalTime hasieraOrduaErreala;

    /**
     * Hitzorduaren amaiera ordua benetan gertatu zena.
     * Erreala den amaiera ordua (balioztatu daiteke).
     */
    @Column(name = "amaiera_ordua_erreala")
    private LocalTime amaieraOrduaErreala;

    /**
     * Hitzordura etorritako pertsonaren izena.
     * Beharrezkoa da hitzorduaren izena ezagutzea.
     */
    @Column(name = "izena", length = 100, nullable = false)
    private String izena;

    /**
     * Pertsonaren telefono zenbakia.
     * Hitzordura etorritako pertsonaren telefono zenbakia.
     */
    @Column(name = "telefonoa", length = 9)
    private String telefonoa;

    /**
     * Hitzorduari buruzko deskribapen edo xehetasunak.
     * Deskribapen hau hitzorduaren izaera adierazteko da.
     */
    @Column(name = "deskribapena", length = 250)
    private String deskribapena;

    /**
     * Hitzordua etxeko edo kanpoko pertsonarentzat den adierazlea.
     * 'E' (Etxeko) edo 'K' (Kanpoko).
     */
    @Column(name = "etxekoa", length = 1, nullable = true)
    private String etxekoa;

    /**
     * Hitzorduko prezio totala.
     * Hitzorduaren prezio totala kalkulatzen du.
     */
    @Column(name = "prezio_totala")
    private BigDecimal prezioTotala;

    /**
     * Langilearekin duen erlazioa.
     * Langilea hitzordua kudeatzen duen pertsona da.
     */
    @ManyToOne
    @JoinColumn(name = "id_langilea")
    private Langileak langilea;

    /**
     * Hitzordua sortu zen data.
     * Sistema batean sortu zen hitzordua data eta orduarekin.
     */
    @Column(name = "sortze_data")
    private LocalDateTime sortzeData;

    /**
     * Hitzordua eguneratu zen azken data.
     * Hitzordua eguneratzeen azken data.
     */
    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData;

    /**
     * Hitzordua ezabatu edo egonkor markatutako data.
     * Ezabatze edo egonkor markatzea adierazten du.
     */
    @Column(name = "ezabatze_data")
    private LocalDate ezabatzeData;
}
