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
 * {@link Material_maileguak} entitateak materialen maileguen informazioa gordetzen du,
 * langileek materialak hartu edo utzi dituzten datuak jasotzen ditu.
 * Material mailegu bakoitzak hasiera eta amaiera datak, baita sorrerako, eguneratze eta ezabatze datak ere.
 * 
 * <p>Klase honek datu hauek gordetzen ditu:</p>
 * <ul>
 *   <li>{@code materialak}: Mailegatutako materialaren informazioa.</li>
 *   <li>{@code langilea}: Materiala mailegatzen duen langilearen informazioa.</li>
 *   <li>{@code hasieraData}: Maileguaren hasiera data eta ordua.</li>
 *   <li>{@code amaieraData}: Maileguaren amaiera data eta ordua (optionala).</li>
 *   <li>{@code sortzeData}: Maileguaren erregistroaren sorrerako data eta ordua.</li>
 *   <li>{@code eguneratzeData}: Maileguaren datuetan egindako azken eguneraketaren data eta ordua.</li>
 *   <li>{@code ezabatzeData}: Maileguaren ezabatzeko data, hau da, erregistroaren ezabaketa adierazten duena.</li>
 * </ul>
 * 
 * <p>Entitate honek Lombok liburutegia erabiltzen du, getter eta setter metodoez gain, eraikuntza erraza eta eguneratze erraza ahalbidetzen duena.</p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Entity
@Table(name = "material_maileguak")
@Data // Lombok-en anotazioa, getter eta setter guztiak automatikoki sortzen ditu.
@NoArgsConstructor // Lombok-en anotazioa, zero-argizko eraikitzailea sortzen du.
@AllArgsConstructor // Lombok-en anotazioa, eraikitzailea guztizko parametroekin sortzen du.
@Builder // Lombok-en anotazioa, eraikitzaile mota bat ematen du, objektuaren eraikuntza errazteko.
@Getter // Lombok-en anotazioa, getter guztiak automatikoki sortzen ditu.
@Setter // Lombok-en anotazioa, setter guztiak automatikoki sortzen ditu.
public class Material_maileguak {

    /**
     * Material maileguaren identifikatzailea (auto-generatua).
     * Mailegu bakoitzaren identifikatzaile bakarra.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Mailegatutako materialaren informazioa.
     * Mailegu bakoitzak material jakin batekin erlazionatzen du.
     */
    @ManyToOne
    @JoinColumn(name = "id_materiala", nullable = false)
    private Materialak materialak;

    /**
     * Langilearen informazioa.
     * Materiala mailegatzen duen langilea.
     */
    @ManyToOne
    @JoinColumn(name = "id_langilea", nullable = false)
    private Langileak langilea;

    /**
     * Maileguaren hasiera data.
     * Maileguaren hasiera data eta ordua, ezinbestekoa.
     */
    @Column(name = "hasiera_data", nullable = false)
    private LocalDateTime hasieraData;

    /**
     * Maileguaren amaiera data.
     * Maileguaren amaiera data eta ordua, optionala dena.
     */
    @Column(name = "amaiera_data")
    private LocalDateTime amaieraData;

    /**
     * Maileguaren erregistroaren sorrerako data.
     * Maileguaren erregistroaren data eta ordua.
     */
    @Column(name = "sortze_data")
    private LocalDateTime sortzeData;

    /**
     * Maileguaren datuetan egindako azken eguneraketa.
     * Maileguaren datuetan egindako aldaketa edo eguneraketa gertatu zen data eta ordua.
     */
    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData;

    /**
     * Maileguaren ezabatzeko data.
     * Maileguaren erregistroaren ezabatzeko data eta ordua, hau da, erregistroaren ezabaketa adierazten duena.
     */
    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData;
}
