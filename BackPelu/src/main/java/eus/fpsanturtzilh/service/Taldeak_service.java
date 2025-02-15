package eus.fpsanturtzilh.service;

import eus.fpsanturtzilh.entity.Taldeak;
import eus.fpsanturtzilh.repository.Taldeak_repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * {@link Taldeak_service} klaseak taldeen kudeaketa egiten du.
 * Taldeak lortzea, gordetzea, eguneratzea eta ezabatzea ahalbidetzen du.
 *
 * <p>Klase honek {@link Taldeak_repository} erabiltzen du taldeak datu-basean kudeatzeko.</p>
 *
 * <p>Metoduen deskribapena:</p>
 * <ul>
 *   <li><strong>getAllGroups()</strong>: Talde guztiak lortzen ditu.</li>
 *   <li><strong>getGroupById(String kodea)</strong>: Talde bat bilatzen du kodearen bidez.</li>
 *   <li><strong>saveOrUpdateGroup(Taldeak taldeak)</strong>: Talde berri bat gordetzen edo eguneratzen du datu-basean.</li>
 *   <li><strong>softDeleteGroup(String kodea)</strong>: Talde bat ezabatzen du, baina ezabatze data ezartzen du soilik.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Service
public class Taldeak_service {

    @Autowired
    private Taldeak_repository taldeakRepository;

    /**
     * Talde guztiak lortzen ditu.
     *
     * @return {@link List} Taldeen zerrenda.
     */
    public List<Taldeak> getAllGroups() {
        return taldeakRepository.findAll();
    }

    /**
     * Talde bat bilatzen du kodearen bidez.
     *
     * @param kodea Taldearen kodea.
     * @return {@link Optional} Taldearen datuak, baldin badago.
     */
    public Optional<Taldeak> getGroupById(String kodea) {
        return taldeakRepository.findById(kodea);
    }

    /**
     * Talde berri bat gordetzen edo eguneratzen du datu-basean.
     * Taldearen datuak gordetzea edo eguneratzea ahalbidetzen du.
     *
     * @param taldeak {@link Taldeak} Gordetzeko edo eguneratzeko taldea.
     * @return {@link Taldeak} Gordetako edo eguneratutako taldea.
     */
    public Taldeak saveOrUpdateGroup(Taldeak taldeak) {
        return taldeakRepository.save(taldeak);
    }

    /**
     * Talde bat ezabatzen du, baina ezabatze data ezartzen du soilik.
     * Taldea ezabatzea adierazten du, baina datu-basean mantentzen da.
     *
     * @param kodea Taldearen kodea.
     * @return {@code true} Taldea ezabatu bada, {@code false} bestela.
     */
    public boolean softDeleteGroup(String kodea) {
        Optional<Taldeak> optionalTaldeak = taldeakRepository.findById(kodea);
        if (optionalTaldeak.isPresent()) {
            Taldeak taldeak = optionalTaldeak.get();
            taldeak.setEzabatzeData(LocalDateTime.now());  // Ezabatze data ezartzen du
            taldeakRepository.save(taldeak);
            return true;
        }
        return false;
    }
}
