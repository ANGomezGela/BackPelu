package eus.fpsanturtzilh.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Langileak;
import eus.fpsanturtzilh.repository.LangileakRepository;

/**
 * {@link LangileakService} klaseak langileen datuak kudeatzeko zerbitzuak eskaintzen ditu.
 * Langileen datuak lortzeko, gordetzeko, eguneratzeko eta ezabatzeko funtzionalitateak eskaintzen ditu.
 *
 * <p>Klase honek {@link LangileakRepository} erabiltzen du langileei buruzko operazioak egiteko.</p>
 *
 * <p>Metoduen deskribapena:</p>
 * <ul>
 *   <li><strong>getLangileak()</strong>: Langileen datu guztiak lortzen ditu.</li>
 *   <li><strong>saveLangilea(Langileak langilea)</strong>: Langile berri bat datu-basean gordetzen du.</li>
 *   <li><strong>getById(Long id)</strong>: Langile bat bilatzen du identifikatzailearen bidez.</li>
 *   <li><strong>updateById(Langileak request, Long id)</strong>: Langile baten datuak eguneratzen ditu identifikatzailearen bidez.</li>
 *   <li><strong>softDeleteLangilea(Long id)</strong>: Langilea ezabatzen du, baina ezabatze data ezartzen du soilik.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Service
public class LangileakService {

    @Autowired
    private LangileakRepository langileakRepository;

    /**
     * Langileen datu guztiak lortzen ditu.
     *
     * @return {@link ArrayList} Langileen zerrenda.
     */
    public ArrayList<Langileak> getLangileak() {
        return (ArrayList<Langileak>) langileakRepository.findAll();
    }

    /**
     * Langile berri bat datu-basean gordetzen du.
     *
     * @param langilea {@link Langileak} Gorde nahi den langilearen datuak.
     * @return {@link Langileak} Gorde den langilea.
     */
    public Langileak saveLangilea(Langileak langilea) {
        langilea.setSortzeData(LocalDateTime.now());
        return langileakRepository.save(langilea);
    }

    /**
     * Langile bat bilatzen du identifikatzailearen bidez.
     *
     * @param id Langilearen identifikatzailea.
     * @return {@link Optional} Langilearen datuak, baldin badago.
     */
    public Optional<Langileak> getById(Long id) {
        return langileakRepository.findById(id);
    }

    /**
     * Langile baten datuak eguneratzen ditu identifikatzailearen bidez.
     * 
     * <p>Metodo honek langilearen datuak eguneratzen ditu, eta eguneratze data automatikoki ezartzen du.</p>
     *
     * @param request {@link Langileak} Eguneratutako langilearen datuak.
     * @param id Langilearen identifikatzailea.
     * @return {@link Langileak} Eguneratutako langilea.
     * @throws RuntimeException Langilea ez bada aurkitzen identifikatzailearekin.
     */
    public Langileak updateById(Langileak request, Long id) {
        Langileak langilea = langileakRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Langilea no encontrado con ID: " + id));
        
        langilea.setIzena(request.getIzena());
        langilea.setAbizenak(request.getAbizenak());
        langilea.setTaldeak(request.getTaldeak());
        langilea.setEguneratzeData(LocalDateTime.now());
        
        return langileakRepository.save(langilea);
    }

    /**
     * Langilea ezabatzen du, ezabatzeko data ezarriz.
     * 
     * <p>Metodo honek langilea datu-basean ezabatzen du, baina ezabatze data ezartzen du soilik, datuak benetan
     * ezabatzen gabe.</p>
     *
     * @param id Langilearen identifikatzailea.
     * @return {@code true} Langilea ezabatu bada, {@code false} bestela.
     */
    public boolean softDeleteLangilea(Long id) {
        Optional<Langileak> optionalLangilea = langileakRepository.findById(id);
        if (optionalLangilea.isPresent()) {
            Langileak langilea = optionalLangilea.get();
            langilea.setEzabatzeData(LocalDateTime.now());  // Ezabatze data ezartzen du
            langileakRepository.save(langilea);
            return true;
        }
        return false;
    }
}
