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
 * {@link Kolore_historialak} entitateak bezeroen eta produktuen kolore erabileraren historiak kudeatzen ditu.
 * Kolorearen erabilera, kantitatea, bolumena eta oharrei buruzko informazioa gordetzen du, baita erregistroaren 
 * sorrerako, eguneraketako eta ezabatzeko datak ere.
 * 
 * <p>Klase honek datu hauek gordetzen ditu:</p>
 * <ul>
 *   <li>{@code bezeroa}: Bezeroaren informazioa, bezero bakoitzak kolorearen erabilera historial bat izan dezake.</li>
 *   <li>{@code produktua}: Produktuaren informazioa, produktu bakoitzak kolorearen erabilera historial bat izan dezake.</li>
 *   <li>{@code data}: Kolorearen erabilera gertatu zen eguna.</li>
 *   <li>{@code kantitatea}: Erabilitako kolore kantitatea.</li>
 *   <li>{@code bolumena}: Kolorearen bolumena (aukera).</li>
 *   <li>{@code oharrak}: Kolorearen erabilerari buruzko ohar edo deskribapenak (aukera).</li>
 *   <li>{@code sortzeData}: Erregistroaren sortze data eta ordua.</li>
 *   <li>{@code eguneratzeData}: Erregistroaren azken eguneratze data eta ordua.</li>
 *   <li>{@code ezabatzeData}: Erregistroaren ezabatzeko data (ezabatze edo egonkor markatzea adierazten du).</li>
 * </ul>
 * 
 * <p>Entitate honek Lombok liburutegia erabiltzen du, getter eta setter metodoez gain, eraikuntza erraza eta eguneratze erraza ahalbidetzen duena.</p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Entity
@Table(name = "kolore_historialak")
@Data // Lombok-en anotazioa, getter eta setter guztiak automatikoki sortzen ditu.
@NoArgsConstructor // Lombok-en anotazioa, zero-argizko eraikitzailea sortzen du.
@AllArgsConstructor // Lombok-en anotazioa, eraikitzailea guztizko parametroekin sortzen du.
@Builder // Lombok-en anotazioa, eraikitzaile mota bat ematen du, objektuaren eraikuntza errazteko.
@Getter // Lombok-en anotazioa, getter guztiak automatikoki sortzen ditu.
@Setter // Lombok-en anotazioa, setter guztiak automatikoki sortzen ditu.
public class Kolore_historialak {

    /**
     * Kolore historialaren identifikatzailea (auto-generatua).
     * Kolore historialaren lehenengo identifikatzailea (auto-generatua).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Bezeroaren informazioa.
     * Bezero bakoitzak kolorearen erabilera historial bat du.
     */
    @ManyToOne
    @JoinColumn(name = "id_bezeroa", nullable = false)
    private Bezero_fitxak bezeroa;

    /**
     * Produktuaren informazioa.
     * Produktu bakoitzak kolorearen erabilera historial bat du.
     */
    @ManyToOne
    @JoinColumn(name = "id_produktua", nullable = false)
    private Produktuak produktua;

    /**
     * Kolorearen erabilera gertatu zen eguna.
     * Kolorea zein egunean erabili zen adierazten du.
     */
    @Column(name = "data", nullable = false)
    private LocalDate data;

    /**
     * Kolorearen kantitatea.
     * Erabilitako kolore kantitatea adierazten du.
     */
    @Column(name = "kantitatea")
    private Integer kantitatea;

    /**
     * Kolorearen bolumena.
     * Kolorearen bolumena zehazten du (aukera).
     */
    @Column(name = "bolumena", length = 100)
    private String bolumena;

    /**
     * Kolorearen erabileraren oharra.
     * Erabilera honi buruzko ohar edo deskribapenak gordetzen ditu (aukera).
     */
    @Column(name = "oharrak", length = 250)
    private String oharrak;

    /**
     * Erregistroaren sortze data.
     * Kolore historialaren sorreraren data eta ordua adierazten ditu.
     */
    @Column(name = "sortze_data")
    private LocalDateTime sortzeData;

    /**
     * Erregistroaren azken eguneratze data.
     * Kolore historialaren azken aldaketa edo eguneraketa gertatu zen data eta ordua.
     */
    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData;

    /**
     * Erregistroaren ezabatzeko data.
     * Kolore historialaren ezabatze edo egonkor markatzea adierazten duen data eta ordua.
     */
    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; // Fecha de eliminación lógica del registro
}

