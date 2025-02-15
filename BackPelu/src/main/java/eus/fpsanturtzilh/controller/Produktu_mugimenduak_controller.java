package eus.fpsanturtzilh.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eus.fpsanturtzilh.entity.Produktu_mugimenduak;
import eus.fpsanturtzilh.service.Produktu_mugimenduak_service;

/**
 * {@link Produktu_mugimenduak_controller} klaseak Produktu Mugimenduak entitatearekin lotutako HTTP eskaerak kudeatzen ditu.
 * REST API bidez, erabiltzaileek Produktu Mugimenduak datu basearekin interakzionatu ahal izango dute.
 * 
 * <p>Klase honek CRUD (Sortu, Irakurri, Eguneratu, Ezabatu) operazioak eskaintzen ditu:
 * <ul>
 *   <li>{@code getProduk}: Produktu Mugimendu guztien zerrenda eskuratzea.</li>
 *   <li>{@code saveUniversity}: Produktu Mugimendu berri bat gehitzea.</li>
 *   <li>{@code getProduktuId}: Id baten arabera Produktu Mugimendu bat eskuratzea.</li>
 *   <li>{@code updateProduktuById}: Id baten arabera Produktu Mugimendua eguneratzea.</li>
 *   <li>{@code softDeleteProduktuMugimenduak}: Produktu Mugimendua "ezabatzea" (egonkor markatzea) bere Id bidez.</li>
 * </ul>
 * </p>
 * 
 * <p>API honen bidez, bezeroek edo erabiltzaileek Produktu Mugimenduen kudeaketa egin dezakete.
 * </p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@RestController
@RequestMapping("/produktu_mugimenduak")
public class Produktu_mugimenduak_controller {
	
    @Autowired
    private Produktu_mugimenduak_service produktuak_Mugimendua_service;

    /**
     * Produktu Mugimendu guztien zerrenda eskuratzen du.
     * 
     * @return Produktu Mugimenduen zerrenda.
     */
    @GetMapping
    public ArrayList<Produktu_mugimenduak> getProduk() {
        return this.produktuak_Mugimendua_service.getProduktu_mugimenduak();
    }

    /**
     * Produktu Mugimendu berri bat gehitzen du.
     * 
     * @param produ Gehitu nahi den Produktu Mugimenduaren informazioa.
     * @return Gehitu den Produktu Mugimendua.
     */
    @PostMapping
    public Produktu_mugimenduak saveUniversity(@RequestBody Produktu_mugimenduak produ) {
        return this.produktuak_Mugimendua_service.saveProduktu_mugimenduak(produ);
    }

    /**
     * Id bat emanez, Produktu Mugimendu bat eskuratzea.
     * 
     * @param id Eskatutako Produktu Mugimenduaren identifikatzailea.
     * @return Eskaera egindako Produktu Mugimenduaren Optional.
     */
    @GetMapping(path = "/{id}")
    public Optional<Produktu_mugimenduak> getProduktuId(@PathVariable Long id) {
        return this.produktuak_Mugimendua_service.getById(id);
    }

    /**
     * Id baten arabera, Produktu Mugimendu bat eguneratzea.
     * 
     * @param request Eguneratutako Produktu Mugimenduaren informazioa.
     * @param id Eguneratu nahi den Produktu Mugimenduaren identifikatzailea.
     * @return Eguneratutako Produktu Mugimendua.
     */
    @PutMapping(path = "/{id}")
    public Produktu_mugimenduak updateProduktuById(@RequestBody Produktu_mugimenduak request, Long id) {
        return this.produktuak_Mugimendua_service.updateById(request, id);
    }

    /**
     * Produktu Mugimendu bat "ezabatzea" (egonkor markatzea), hau da, ezabatzea simulatzea.
     * 
     * @param id Ezabatu nahi den Produktu Mugimenduaren identifikatzailea.
     * @return Erantzuna, egonkor markatzea lortu bada edo ez.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> softDeleteProduktuMugimenduak(@PathVariable Long id) {
        boolean deleted = produktuak_Mugimendua_service.softDeleteProduktuMugimenduak(id);
        if (deleted) {
            return ResponseEntity.ok("Produktu mugimendua with id: " + id + " marked as deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produktu mugimendua not found.");
        }
    }
}
