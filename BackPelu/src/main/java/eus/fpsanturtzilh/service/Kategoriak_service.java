package eus.fpsanturtzilh.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Kategoriak;
import eus.fpsanturtzilh.repository.Kategoriak_repository;

/**
 * {@link Kategoriak_service} klaseak kategoriak kudeatzeko zerbitzuak eskaintzen ditu.
 * Kategoriak bilatzeko, gehitzeko, eguneratzeko eta ezabatzeko funtzionalitateak eskaintzen ditu.
 *
 * <p>Klase honek {@link Kategoriak_repository} erabiltzen du kategoriak kudeatzeko
 * operazioak egiteko.</p>
 *
 * <p>Metoduen deskribapena:</p>
 * <ul>
 *   <li><strong>getKategoriak()</strong>: Datu-basean gordetako kategoriak lortzen ditu.</li>
 *   <li><strong>saveKategoria(Kategoriak kategoria)</strong>: Kategoria berri bat datu-basean
 *       gehitzen du.</li>
 *   <li><strong>getById(Long id)</strong>: Kategoria bat bilatzen du identifikatzailearen bidez.</li>
 *   <li><strong>updateById(Kategoriak request, Long id)</strong>: Kategoria bat eguneratzen du,
 *       `izena` eta `eguneratzeData` eguneratuz. `ezabatzeData` baliozko bat badago, eguneratzen du
 *       ere.</li>
 *   <li><strong>softDeleteKategoria(Long id)</strong>: Kategoria bat ezabatzen du, baina
 *       ezabatze data ezartzen du soilik.</li>
 * </ul>
 *
 * @author [Zure Izena]
 * @since [Data]
 */
@Service
public class Kategoriak_service {
    
    @Autowired
    Kategoriak_repository kategoriak_repository;

    /**
     * Datu-basean gordetako kategoriak lortzen ditu.
     *
     * @return {@link ArrayList} Kategoriak guztien zerrenda.
     */
    public ArrayList<Kategoriak> getKategoriak() {
        return (ArrayList<Kategoriak>) kategoriak_repository.findAll();
    }

    /**
     * Kategoria berri bat datu-basean gehitzen du.
     *
     * @param kategoria {@link Kategoriak} Gehitu nahi den kategoria.
     * @return {@link Kategoriak} Gehitu den kategoria.
     */
    public Kategoriak saveKategoria(Kategoriak kategoria) {
        return kategoriak_repository.save(kategoria);
    }

    /**
     * Kategoria bat bilatzen du identifikatzailearen bidez.
     *
     * @param id Kategoriaren identifikatzailea.
     * @return {@link Optional} Kategoria aurkitzen bada.
     */
    public Optional<Kategoriak> getById(Long id) {
        return kategoriak_repository.findById(id);
    }

    /**
     * Kategoria bat eguneratzen du identifikatzailearen bidez.
     * 
     * <p>Metodo honek kategoria eguneratze data eguneratzen du eta,
     * halaber, ezabatze data eskatuz gero, hori ere eguneratzen du.</p>
     *
     * @param request {@link Kategoriak} Eguneratutako kategoria datuak.
     * @param id Kategoriaren identifikatzailea.
     * @return {@link Kategoriak} Eguneratutako kategoria.
     * @throws RuntimeException Kategoria ez badago aurkitua.
     */
    public Kategoriak updateById(Kategoriak request, Long id) {
        Kategoriak kategoria = kategoriak_repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + id));

        kategoria.setIzena(request.getIzena());

        // Ez da aldatzen `sortzeData`, egon bezala mantenduz
        // `eguneratzeData` automatikoki eguneratzen da
        kategoria.setEguneratzeData(LocalDateTime.now());

        // `ezabatzeData` eguneratzen da soilik balio bat datorrenean
        if (request.getEzabatzeData() != null) {
            kategoria.setEzabatzeData(request.getEzabatzeData());
        }

        return kategoriak_repository.save(kategoria);
    }

    /**
     * Kategoria bat ezabatzen du, ezabatzeko data ezarriz.
     * 
     * <p>Metodo honek kategoria ezabatzen du, baina ezabatzeko data
     * bakarrik eguneratzen du, datu-basean ezabatutako kategoriek ez dute
     * benetako ezabatzea jasaten.</p>
     *
     * @param id Kategoriaren identifikatzailea.
     * @return {@code true} Kategoria ezabatuta izan bada, {@code false} bestela.
     */
    public boolean softDeleteKategoria(Long id) {
        Optional<Kategoriak> kategoriaOptional = kategoriak_repository.findById(id);
        if (kategoriaOptional.isPresent()) {
            Kategoriak kategoria = kategoriaOptional.get();
            kategoria.setEzabatzeData(LocalDateTime.now());  // Ezabatze data ezartzen du
            kategoriak_repository.save(kategoria);
            return true;
        }
        return false;
    }
}
