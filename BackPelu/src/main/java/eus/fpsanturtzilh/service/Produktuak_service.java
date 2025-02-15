package eus.fpsanturtzilh.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Produktuak;
import eus.fpsanturtzilh.repository.Produktuak_repository;

/**
 * {@link Produktuak_service} klaseak produktuen kudeaketa egiten du.
 * Produktu berriak gordetzea, eguneratzea, bilatzea eta ezabatzea ahalbidetzen du.
 *
 * <p>Klase honek {@link Produktuak_repository} erabiltzen du produktuak datu-basean kudeatzeko.</p>
 *
 * <p>Metoduen deskribapena:</p>
 * <ul>
 *   <li><strong>getProduktuak()</strong>: Produktu guztiak lortzen ditu.</li>
 *   <li><strong>saveProduktu(Produktuak produ)</strong>: Produktu berri bat gordetzen du datu-basean.</li>
 *   <li><strong>getById(Long id)</strong>: Produktu bat bilatzen du identifikatzailearen bidez.</li>
 *   <li><strong>patchById(Produktuak request, Long id)</strong>: Produktu baten datuak eguneratzen ditu, baina bakarrik eskatutako aldaketak egiten ditu.</li>
 *   <li><strong>updateById(Produktuak request, Long id)</strong>: Produktu baten datuak guztiz eguneratzen ditu.</li>
 *   <li><strong>softDeleteProduktu(Long id)</strong>: Produktu bat ezabatzen du, baina ezabatze data ezartzen du soilik.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Service
public class Produktuak_service {
    @Autowired
    Produktuak_repository produktuak_repository;

    /**
     * Produktu guztiak lortzen ditu.
     *
     * @return {@link ArrayList} Produktuen zerrenda.
     */
    public ArrayList<Produktuak> getProduktuak(){
        return (ArrayList<Produktuak>) produktuak_repository.findAll();
    }

    /**
     * Produktu berri bat datu-basean gordetzen du.
     * Sortze data automatikoki ezartzen du.
     *
     * @param produ {@link Produktuak} Gorde nahi den produktuaren datuak.
     * @return {@link Produktuak} Gorde den produktua.
     */
    public Produktuak saveProduktu(Produktuak produ) {
        produ.setSortzeData(LocalDateTime.now()); // Sortze data ezartzen du
        return produktuak_repository.save(produ);
    }

    /**
     * Produktu bat bilatzen du identifikatzailearen bidez.
     *
     * @param id Produktuaren identifikatzailea.
     * @return {@link Optional} Produktuaren datuak, baldin badago.
     */
    public Optional<Produktuak> getById(Long id){
        return produktuak_repository.findById(id);
    }

    /**
     * Produktu baten datuak eguneratzen ditu, baina bakarrik eskatutako aldaketak egiten ditu.
     * Eskaera bat jasotzen denean, eskaerako informazioarekin eguneratzen ditu existitzen diren produktuak.
     *
     * @param request {@link Produktuak} Eguneratutako produktuen datuak.
     * @param id Produktuaren identifikatzailea.
     * @return {@link Produktuak} Eguneratutako produktua.
     * @throws RuntimeException Produktua ez bada aurkitu identifikatzailearekin.
     */
    public Produktuak patchById(Produktuak request, Long id) {
        Optional<Produktuak> optionalProduktu = produktuak_repository.findById(id);

        if (optionalProduktu.isPresent()) {
            Produktuak existingProduktu = optionalProduktu.get();

            // Eskaeratik datu bakarrik eguneratzen dira, ez dauden balioekin
            if (request.getIzena() != null) {
                existingProduktu.setIzena(request.getIzena());
            }
            if (request.getDeskribapena() != null) {
                existingProduktu.setDeskribapena(request.getDeskribapena());
            }
            if (request.getKategoriak() != null) {
                existingProduktu.setKategoriak(request.getKategoriak());
            }
            if (request.getMarka() != null) {
                existingProduktu.setMarka(request.getMarka());
            }
            if (request.getStock() != null) {
                existingProduktu.setStock(request.getStock());
            }

            return produktuak_repository.save(existingProduktu);
        } else {
            throw new RuntimeException("Produktu ez da aurkitu IDarekin: " + id);
        }
    }

    /**
     * Produktu baten datuak guztiz eguneratzen ditu.
     * Eskaera guztiz berriz idazten da, datu guztiak eguneratuz.
     *
     * @param request {@link Produktuak} Eguneratutako produktuen datuak.
     * @param id Produktuaren identifikatzailea.
     * @return {@link Produktuak} Eguneratutako produktua.
     * @throws RuntimeException Produktua ez bada aurkitu identifikatzailearekin.
     */
    public Produktuak updateById(Produktuak request, Long id) {
        Produktuak produ = produktuak_repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produktu ez da aurkitu IDarekin: " + id));

        if (request.getIzena() != null) produ.setIzena(request.getIzena());
        if (request.getDeskribapena() != null) produ.setDeskribapena(request.getDeskribapena());
        if (request.getKategoriak() != null) produ.setKategoriak(request.getKategoriak());
        if (request.getMarka() != null) produ.setMarka(request.getMarka());
        if (request.getStock() != null) produ.setStock(request.getStock());
        if (request.getStockAlerta() != null) produ.setStockAlerta(request.getStockAlerta());

        produ.setEguneratzeData(LocalDateTime.now());  // Eguneratzeko data ezartzen du

        return produktuak_repository.save(produ);
    }

    /**
     * Produktu bat ezabatzen du, baina ezabatze data ezartzen du soilik.
     * 
     * @param id Produktuaren identifikatzailea.
     * @return {@code true} Produktua ezabatu bada, {@code false} bestela.
     */
    public boolean softDeleteProduktu(Long id) {
        Optional<Produktuak> optionalProduktu = produktuak_repository.findById(id);
        if (optionalProduktu.isPresent()) {
            Produktuak produ = optionalProduktu.get();
            produ.setEzabatzeData(LocalDateTime.now());  // Ezabatze data ezartzen du
            produktuak_repository.save(produ);
            return true;
        }
        return false;
    }
}
