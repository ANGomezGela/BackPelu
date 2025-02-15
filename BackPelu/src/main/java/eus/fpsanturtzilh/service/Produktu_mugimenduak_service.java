package eus.fpsanturtzilh.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Produktu_mugimenduak;
import eus.fpsanturtzilh.repository.Produktu_mugimenduak_repository;

/**
 * {@link Produktu_mugimenduak_service} klaseak produktuen mugimenduen kudeaketa egiten du.
 * Produktuen mugimenduak lortzeko, gordetzeko, eguneratzeko eta ezabatzeko funtzionalitateak eskaintzen ditu.
 *
 * <p>Klase honek {@link Produktu_mugimenduak_repository} erabiltzen du produktuen mugimenduak kudeatzeko.</p>
 *
 * <p>Metoduen deskribapena:</p>
 * <ul>
 *   <li><strong>getProduktu_mugimenduak()</strong>: Produktu guztien mugimenduak lortzen ditu.</li>
 *   <li><strong>saveProduktu_mugimenduak(Produktu_mugimenduak produ)</strong>: Produktu mugimendu berri bat gordetzen du.</li>
 *   <li><strong>getById(Long id)</strong>: Produktu mugimendu bat bilatzen du identifikatzailearen bidez.</li>
 *   <li><strong>updateById(Produktu_mugimenduak request, Long id)</strong>: Produktu mugimendu baten datuak eguneratzen ditu identifikatzailearen bidez.</li>
 *   <li><strong>softDeleteProduktuMugimenduak(Long id)</strong>: Produktu mugimendu bat ezabatzen du, baina ezabatze data ezartzen du soilik.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Service
public class Produktu_mugimenduak_service {

    @Autowired
    Produktu_mugimenduak_repository produktu_mugimenduak_repository;

    /**
     * Produktu mugimendu guztiak lortzen ditu.
     *
     * @return {@link ArrayList} Produktu mugimenduen zerrenda.
     */
    public ArrayList<Produktu_mugimenduak> getProduktu_mugimenduak(){
        return (ArrayList<Produktu_mugimenduak>) produktu_mugimenduak_repository.findAll();
    }

    /**
     * Produktu mugimendu berri bat datu-basean gordetzen du.
     *
     * @param Produ {@link Produktu_mugimenduak} Gorde nahi den produktua.
     * @return {@link Produktu_mugimenduak} Gorde den produktu mugimendua.
     */
    public Produktu_mugimenduak saveProduktu_mugimenduak (Produktu_mugimenduak Produ) {
        return produktu_mugimenduak_repository.save(Produ);
    }

    /**
     * Produktu mugimendu bat bilatzen du identifikatzailearen bidez.
     *
     * @param id Produktu mugimenduaren identifikatzailea.
     * @return {@link Optional} Produktu mugimenduaren datuak, baldin badago.
     */
    public Optional<Produktu_mugimenduak> getById(Long id){
        return produktu_mugimenduak_repository.findById(id);
    }

    /**
     * Produktu mugimendu baten datuak eguneratzen ditu identifikatzailearen bidez.
     * 
     * <p>Metodo honek produktuen mugimenduaren datuak eguneratzen ditu, eta eguneratze data automatikoki ezartzen du.</p>
     *
     * @param request {@link Produktu_mugimenduak} Eguneratutako produktuen mugimenduaren datuak.
     * @param id Produktu mugimenduaren identifikatzailea.
     * @return {@link Produktu_mugimenduak} Eguneratutako produktuen mugimendua.
     * @throws RuntimeException Produktu mugimendua ez bada aurkitu identifikatzailearekin.
     */
    public Produktu_mugimenduak updateById(Produktu_mugimenduak request, Long id) {
        Produktu_mugimenduak produ = produktu_mugimenduak_repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produktu mugimendua ez da aurkitu IDarekin: " + id));
        
        produ.setProduktua(request.getProduktua());
        produ.setLangilea(request.getLangilea());
        produ.setData(request.getData());
        produ.setKopurua(request.getKopurua());
        produ.setSortzeData(request.getSortzeData());
        produ.setEguneratzeData(LocalDateTime.now());  
        produ.setEzabatzeData(request.getEzabatzeData());
        
        return produktu_mugimenduak_repository.save(produ);
    }

    /**
     * Produktu mugimendu bat ezabatzen du, ezabatzeko data ezarriz.
     * 
     * <p>Metodo honek produktu mugimendu bat datu-basean ezabatzen du, baina ezabatze data ezartzen du soilik, datuak benetan
     * ezabatzen gabe.</p>
     *
     * @param id Produktu mugimenduaren identifikatzailea.
     * @return {@code true} Produktu mugimendua ezabatu bada, {@code false} bestela.
     */
    public boolean softDeleteProduktuMugimenduak(Long id) {
        Optional<Produktu_mugimenduak> optionalProduktuMugimenduak = produktu_mugimenduak_repository.findById(id);
        if (optionalProduktuMugimenduak.isPresent()) {
            Produktu_mugimenduak produktua = optionalProduktuMugimenduak.get();
            produktua.setEzabatzeData(LocalDateTime.now());  // Ezabatze data ezartzen du
            produktu_mugimenduak_repository.save(produktua);
            return true;
        }
        return false;
    }
}
