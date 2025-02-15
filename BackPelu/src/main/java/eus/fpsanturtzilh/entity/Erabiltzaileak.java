package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * {@link Erabiltzaileak} entitateak erabiltzaileei buruzko informazioa kudeatzen du.
 * Honek erabiltzaileen izenak, pasahitzak, rolak eta beste informazio garrantzitsua biltegiratzen du.
 * Entitate honek datu-basean "erabiltzaileak" izeneko taula bat du.
 * 
 * <p>Klase honek datu hauen eguneratzeak eta ezabaketak ere kudeatzen ditu:</p>
 * <ul>
 *   <li>{@code username}: Erabiltzailearen izena (login izena).</li>
 *   <li>{@code pasahitza}: Erabiltzailearen pasahitza (segurtasunarekin lotuta).</li>
 *   <li>{@code rola}: Erabiltzailearen rola (adibidez, admin, langile, bezero).</li>
 *   <li>{@code sortzeData}: Erabiltzailearen sortze data.</li>
 *   <li>{@code eguneratzeData}: Erabiltzailearen azken eguneratze data.</li>
 *   <li>{@code ezabatzeData}: Erabiltzailearen ezabaketaren data (egonkor markatzeko).</li>
 * </ul>
 * 
 * <p>Entitate honek Lombok liburutegia erabiltzen du, getter eta setter metodoez gain, eraikuntza erraza eta eguneratze erraza ahalbidetzen duena.</p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Entity
@Table(name = "erabiltzaileak")
@Data // Lombok-en anotazioa, getter eta setter guztiak automatikoki sortzen ditu.
@NoArgsConstructor // Lombok-en anotazioa, zero-argizko eraikitzailea sortzen du.
@AllArgsConstructor // Lombok-en anotazioa, eraikitzailea guztizko parametroekin sortzen du.
@Builder // Lombok-en anotazioa, eraikitzaile mota bat ematen du, objektuaren eraikuntza errazteko.
@Getter // Lombok-en anotazioa, getter guztiak automatikoki sortzen ditu.
@Setter // Lombok-en anotazioa, setter guztiak automatikoki sortzen ditu.
public class Erabiltzaileak {

    /**
     * Erabiltzailearen izena. 
     * Honek login izena ordezkatzen du, eta ezin da hutsik utzi.
     * Gehienez 15 karaktere izan ditzake.
     */
    @Id
    @Column(name = "username", length = 15, nullable = false)
    private String username; 

    /**
     * Erabiltzailearen pasahitza.
     * Ez da hutsik utzi behar eta gehienez 100 karaktere izan ditzake.
     */
    @Column(name = "pasahitza", length = 100, nullable = false)
    private String pasahitza; 

    /**
     * Erabiltzailearen rola.
     * Gehienez 2 karaktere izan ditzake (adibidez, "AD" adminentzat, "BE" bezeroentzat).
     */
    @Column(name = "rola", length = 2, nullable = false)
    private String rola; 

    /**
     * Erabiltzailearen sortze data.
     * Data eta ordua gordetzen ditu.
     */
    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; 

    /**
     * Erabiltzailearen azken eguneratze data.
     * Data eta ordua gordetzen ditu.
     */
    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; 

    /**
     * Erabiltzailearen ezabaketaren data.
     * Erabiltzailearen fitxak egonkor markatzea adierazten du.
     */
    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; 
}
