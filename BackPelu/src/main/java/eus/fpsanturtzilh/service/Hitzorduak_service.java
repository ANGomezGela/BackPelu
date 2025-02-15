package eus.fpsanturtzilh.service;

import java.util.stream.Collectors;
import eus.fpsanturtzilh.entity.Hitzorduak;
import eus.fpsanturtzilh.repository.Hitzorduak_repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * {@link Hitzorduak_service} klaseak {@link Hitzorduak} entitatearekin
 * lotutako zerbitzuak eskaintzen ditu, hitzorduak kudeatzeko funtzionalitateak
 * eskainiz.
 * 
 * <p>Klase honek {@link Hitzorduak_repository} erabiltzen du hitzorduak kudeatzeko
 * operazioak egiteko. Hitzorduak bilatzeko, gehitzeko, ezabatzeko eta eguneratzeko
 * metodoak eskaintzen ditu.</p>
 * 
 * <p>Metoduen deskribapena:</p>
 * <ul>
 *   <li><strong>getAllHitzorduak()</strong>: Datu-basean gordetako hitzorduen
 *       zerrenda guztia lortzen du.</li>
 *   <li><strong>getHitzorduakByFecha(LocalDate fecha)</strong>: Data jakin bateko
 *       hitzorduen zerrenda lortzen du.</li>
 *   <li><strong>getCountByFecha()</strong>: Data bakoitzeko hitzordu kopurua itzultzen du
 *       mapa baten bidez.</li>
 *   <li><strong>addHitzordua(Hitzorduak hitzordua)</strong>: Hitzordu bat datu-basean
 *       gehitzen du.</li>
 *   <li><strong>getHitzorduakById(Long id)</strong>: Hitzordu bat lortzen du identifikatzaile
 *       baten bidez.</li>
 *   <li><strong>softDeleteHitzordua(Long id)</strong>: Hitzordu bat ezabatzen du, ezabatzeko
 *       data ezarriz.</li>
 *   <li><strong>getHitzorduakByFechaHoy(LocalDate fecha)</strong>: Gaurko datako hitzorduen
 *       zerrenda lortzen du.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Service
public class Hitzorduak_service {

    private final Hitzorduak_repository repository;

    /**
     * {@link Hitzorduak_service} klasearen konstruktorea. {@link Hitzorduak_repository}
     * parametro gisa jasotzen du eta injektatzen du.
     *
     * @param repository {@link Hitzorduak_repository} inyectatua.
     */
    public Hitzorduak_service(Hitzorduak_repository repository) {
        this.repository = repository;
    }

    /**
     * Datu-basean gordetako hitzorduen zerrenda guztia lortzen du.
     *
     * @return {@link List} Hitzordu guztien zerrenda.
     */
    public List<Hitzorduak> getAllHitzorduak() {
        return repository.findAll();
    }

    /**
     * Data jakin bateko hitzorduen zerrenda lortzen du.
     *
     * @param fecha Data.
     * @return {@link List} Hitzorduak data zehatz horrekin.
     */
    public List<Hitzorduak> getHitzorduakByFecha(LocalDate fecha) {
        return repository.findByFecha(fecha);
    }

    /**
     * Data bakoitzeko hitzordu kopurua itzultzen du mapa baten bidez.
     *
     * @return {@link List} Mapa bat, non bakoitzak datari buruzko hitzordu kopurua adierazten duen.
     */
    public List<Map<String, Object>> getCountByFecha() {
        return repository.countByFecha();
    }

    /**
     * Hitzordu bat datu-basean gehitzen du.
     *
     * @param hitzordua {@link Hitzorduak} Gehitu nahi den hitzordua.
     * @return {@link Hitzorduak} Gehitu den hitzordua.
     */
    public Hitzorduak addHitzordua(Hitzorduak hitzordua) {
        return repository.save(hitzordua);
    }

    /**
     * Hitzordu bat bilatzen du identifikatzailearen bidez.
     *
     * @param id Hitzorduen identifikatzailea.
     * @return {@link Hitzorduak} Hitzordua, baldin eta aurkitzen bada.
     */
    public Hitzorduak getHitzorduakById(Long id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Hitzordu bat ezabatzen du, ezabatzeko data ezarriz.
     *
     * @param id Hitzordua ezabatzeko identifikatzailea.
     * @return {@code true} Hitzordua ezabatuta izan bada, {@code false} bestela.
     */
    public boolean softDeleteHitzordua(Long id) {
        Hitzorduak hitzordua = getHitzorduakById(id);
        if (hitzordua != null) {
            hitzordua.setEzabatzeData(LocalDate.now());  // Ezabatze data ezartzen du
            repository.save(hitzordua);
            return true;
        }
        return false;
    }

    /**
     * Gaurko datako hitzorduen zerrenda lortzen du.
     *
     * @param fecha Gaurko data.
     * @return {@link List} Gaurko datako hitzorduak.
     */
    public List<Hitzorduak> getHitzorduakByFechaHoy(LocalDate fecha) {
        return getAllHitzorduak()
                .stream()
                .filter(h -> h.getData().equals(fecha))
                .collect(Collectors.toList());
    }
}
