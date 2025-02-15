package eus.fpsanturtzilh.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Ordutegiak;
import eus.fpsanturtzilh.repository.Ordutegiak_repository;

/**
 * {@link Ordutegiak_service} klaseak ordutegien kudeaketa egiten du.
 * Ordutegien datuak lortzeko, gordetzeko, eguneratzeko eta ezabatzeko funtzionalitateak eskaintzen ditu.
 *
 * <p>Klase honek {@link Ordutegiak_repository} erabiltzen du ordutegien operazioak egiteko.</p>
 *
 * <p>Metoduen deskribapena:</p>
 * <ul>
 *   <li><strong>getOrdutegiak()</strong>: Ordutegien datuak guztiak lortzen ditu.</li>
 *   <li><strong>saveOrdutegiak(Ordutegiak ordutegia)</strong>: Ordutegi berri bat gordetzen du.</li>
 *   <li><strong>getById(Long id)</strong>: Ordutegi bat bilatzen du identifikatzailearen bidez.</li>
 *   <li><strong>updateById(Ordutegiak request, Long id)</strong>: Ordutegi baten datuak eguneratzen ditu identifikatzailearen bidez.</li>
 *   <li><strong>softDeleteOrdutegiak(Long id)</strong>: Ordutegi bat ezabatzen du, baina ezabatze data ezartzen du soilik.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Service
public class Ordutegiak_service {

    @Autowired
    private Ordutegiak_repository ordutegiakRepository;

    /**
     * Ordutegien datu guztiak lortzen ditu.
     *
     * @return {@link List} Ordutegien zerrenda.
     */
    public List<Ordutegiak> getOrdutegiak() {
        return ordutegiakRepository.findAll();
    }

    /**
     * Ordutegi berri bat datu-basean gordetzen du.
     *
     * @param ordutegia {@link Ordutegiak} Gorde nahi den ordutegia.
     * @return {@link Ordutegiak} Gorde den ordutegia.
     */
    public Ordutegiak saveOrdutegiak(Ordutegiak ordutegia) {
        return ordutegiakRepository.save(ordutegia);
    }

    /**
     * Ordutegi bat bilatzen du identifikatzailearen bidez.
     *
     * @param id Ordutegiaren identifikatzailea.
     * @return {@link Optional} Ordutegiaren datuak, baldin badago.
     */
    public Optional<Ordutegiak> getById(Long id) {
        return ordutegiakRepository.findById(id);
    }

    /**
     * Ordutegi baten datuak eguneratzen ditu identifikatzailearen bidez.
     * 
     * <p>Metodo honek ordutegiaren datuak eguneratzen ditu, eta eguneratze data automatikoki ezartzen du.</p>
     *
     * @param request {@link Ordutegiak} Eguneratutako ordutegiaren datuak.
     * @param id Ordutegiaren identifikatzailea.
     * @return {@link Ordutegiak} Eguneratutako ordutegia.
     * @throws RuntimeException Ordutegia ez bada aurkitzen identifikatzailearekin.
     */
    public Ordutegiak updateById(Ordutegiak request, Long id) {
        Ordutegiak ordutegiak = ordutegiakRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Ordutegia ez da aurkitu IDarekin: " + id));
        
        ordutegiak.setTaldeak(request.getTaldeak());
        ordutegiak.setEguna(request.getEguna());
        ordutegiak.setHasieraData(request.getHasieraData());
        ordutegiak.setAmaieraData(request.getAmaieraData());
        ordutegiak.setHasieraOrdua(request.getHasieraOrdua());
        ordutegiak.setAmaieraOrdua(request.getAmaieraOrdua());
        ordutegiak.setEguneratzeData(LocalDateTime.now());
        
        return ordutegiakRepository.save(ordutegiak);
    }
    
    /**
     * Ordutegi bat ezabatzen du, ezabatzeko data ezarriz.
     * 
     * <p>Metodo honek ordutegi bat datu-basean ezabatzen du, baina ezabatze data ezartzen du soilik, datuak benetan
     * ezabatzen gabe.</p>
     *
     * @param id Ordutegiaren identifikatzailea.
     * @return {@code true} Ordutegia ezabatu bada, {@code false} bestela.
     */
    public boolean softDeleteOrdutegiak(Long id) {
        Optional<Ordutegiak> optionalOrdutegiak = ordutegiakRepository.findById(id);
        if (optionalOrdutegiak.isPresent()) {
            Ordutegiak ordutegiak = optionalOrdutegiak.get();
            ordutegiak.setEzabatzeData(LocalDateTime.now());  // Ezabatze data ezartzen du
            ordutegiakRepository.save(ordutegiak);
            return true;
        }
        return false;
    }
}
