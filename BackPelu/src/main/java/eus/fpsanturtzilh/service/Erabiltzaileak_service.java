package eus.fpsanturtzilh.service;

import eus.fpsanturtzilh.entity.Erabiltzaileak;
import eus.fpsanturtzilh.repository.Erabiltzaileak_repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * {@link Erabiltzaileak_service} klaseak {@link Erabiltzaileak} entitatearekin
 * lotutako zerbitzuak eskaintzen ditu, erabiltzaileak kudeatzeko funtzionalitateak
 * eskainiz.
 * 
 * <p>Klase honek {@link Erabiltzaileak_repository} erabiltzen du erabiltzaileekin
 * lotutako operazioak egiteko. Erabiltzaileak bilatzeko eta jasotzeko metodoak
 * eskaintzen ditu.</p>
 * 
 * <p>Metoduen deskribapena:</p>
 * <ul>
 *   <li><strong>findAll()</strong>: Datu-basean gordetako erabiltzaileen zerrenda
 *       guztia lortzen du.</li>
 *   <li><strong>findById(String username)</strong>: Erabiltzaile bat bilatzen du
 *       erabiltzailearen izenarekin (username).</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Service
public class Erabiltzaileak_service {

    private final Erabiltzaileak_repository erabiltzaileakRepository;

    /**
     * {@link Erabiltzaileak_service} klasearen konstruktorea. {@link Erabiltzaileak_repository}
     * parametro gisa jasotzen du eta injektatzen du.
     *
     * @param erabiltzaileakRepository {@link Erabiltzaileak_repository} inyectatua.
     */
    public Erabiltzaileak_service(Erabiltzaileak_repository erabiltzaileakRepository) {
        this.erabiltzaileakRepository = erabiltzaileakRepository;
    }

    /**
     * Datu-basean gordetako erabiltzaileen zerrenda guztia lortzen du.
     *
     * @return {@link List} Erabiltzaile guztien zerrenda.
     */
    public List<Erabiltzaileak> findAll() {
        return erabiltzaileakRepository.findAll();
    }

    /**
     * Erabiltzaile bat bilatzen du izenarekin (username). 
     * {@link Optional} itzultzen du erabiltzailea aurkitzen bada.
     *
     * @param username Erabiltzailearen izena (username).
     * @return {@link Optional} Erabiltzailearen informazioa, baldin eta aurkitzen bada.
     */
    public Optional<Erabiltzaileak> findById(String username) {
        return erabiltzaileakRepository.findById(username);
    }
}
