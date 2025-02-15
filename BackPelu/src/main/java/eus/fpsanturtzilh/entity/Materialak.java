package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * {@link Materialak} entitateak materialen informazioa gordetzen du.
 * Material bakoitzak etiketa, izena, kategoria eta datu administratiboak ditu,
 * hala nola sorrerako, eguneratze eta ezabatze datak.
 * 
 * <p>Klase honek datu hauek gordetzen ditu:</p>
 * <ul>
 *   <li>{@code etiketa}: Materialaren etiketa, identifikazio bakarra.</li>
 *   <li>{@code izena}: Materialaren izena.</li>
 *   <li>{@code kategoriak}: Materialaren kategoria, {@link Kategoriak} entitatearekin erlazionatuta.</li>
 *   <li>{@code sortzeData}: Materialaren erregistroaren sorrerako data eta ordua.</li>
 *   <li>{@code eguneratzeData}: Materialaren datuetan egindako azken eguneraketaren data eta ordua.</li>
 *   <li>{@code ezabatzeData}: Materialaren ezabatzeko data, hau da, materialaren ezabaketa adierazten duena.</li>
 * </ul>
 * 
 * <p>Entitate honek Lombok liburutegia erabiltzen du, getter eta setter metodoez gain, eraikuntza erraza eta eguneratze erraza ahalbidetzen duena.</p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Entity
@Table(name = "materialak")
@Data // Lombok-en anotazioa, getter eta setter guztiak automatikoki sortzen ditu.
@NoArgsConstructor // Lombok-en anotazioa, zero-argizko eraikitzailea sortzen du.
@AllArgsConstructor // Lombok-en anotazioa, eraikitzailea guztizko parametroekin sortzen du.
@Builder // Lombok-en anotazioa, eraikitzaile mota bat ematen du, objektuaren eraikuntza errazteko.
@Getter // Lombok-en anotazioa, getter guztiak automatikoki sortzen ditu.
@Setter // Lombok-en anotazioa, setter guztiak automatikoki sortzen ditu.
public class Materialak {

    /**
     * Materialaren identifikatzailea (auto-generatua).
     * Material bakoitzaren identifikatzaile bakarra.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Materialaren etiketa.
     * Identifikazio bakarra duen materialaren etiketa.
     */
    @Column(name = "etiketa", length = 10, nullable = false)
    private String etiketa;

    /**
     * Materialaren izena.
     * Materialaren izen deskribatzailea.
     */
    @Column(name = "izena", length = 100, nullable = false)
    private String izena;

    /**
     * Materialaren kategoria.
     * {@link Kategoriak} entitatearekin erlazionatuta dago, eta materialaren sailkapenaren informazioa jasotzen du.
     */
    @ManyToOne
    @JoinColumn(name = "id_kategoria", nullable = false)
    private Kategoriak kategoriak;

    /**
     * Materialaren erregistroaren sorrerako data.
     * Materialaren sorrerako data eta ordua.
     */
    @Column(name = "sortze_data")
    private LocalDateTime sortzeData;

    /**
     * Materialaren datuetan egindako azken eguneraketa.
     * Materialaren datuetan egindako aldaketa edo eguneraketa gertatu zen data eta ordua.
     */
    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData;

    /**
     * Materialaren ezabatzeko data.
     * Materialaren erregistroaren ezabatzeko data eta ordua, hau da, materialaren ezabaketa adierazten duena.
     */
    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData;
}
