package eus.fpsanturtzilh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.entity.Produktuak;
import eus.fpsanturtzilh.service.Produktuak_service;

/**
 * {@link Produktuak_controller} klaseak Produktuak entitatearekin lotutako HTTP eskaerak kudeatzen ditu.
 * REST API bidez, erabiltzaileek Produktuak datu basearekin interakzionatu ahal izango dute.
 * 
 * <p>Klase honek CRUD (Sortu, Irakurri, Eguneratu, Ezabatu) operazioak eskaintzen ditu:
 * <ul>
 *   <li>{@code getAllProduktuak}: Produktu guztiak eskuratzea.</li>
 *   <li>{@code addProduktu}: Produktu berri bat gehitzea.</li>
 *   <li>{@code patchProduktu}: Produktu bat partzialki eguneratzea (aldaketa txikiak egiteko).</li>
 *   <li>{@code getProduktuById}: Id baten arabera Produktu bat eskuratzea.</li>
 *   <li>{@code updateProduktu}: Id baten arabera Produktu bat guztiz eguneratzea.</li>
 *   <li>{@code softDeleteProduktu}: Produktu bat "ezabatzea" (egonkor markatzea) bere Id bidez.</li>
 * </ul>
 * </p>
 * 
 * <p>API honen bidez, bezeroek edo erabiltzaileek Produktuak kudeatu eta eguneratu ahal izango dituzte.
 * </p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@RestController
@RequestMapping("/produktuak")
@CrossOrigin(origins = "http://localhost:8100")  // Permitir peticiones desde Ionic
public class Produktuak_controller {
    
    @Autowired
    private Produktuak_service produktuakService;

    /**
     * Produktu guztiak eskuratzen ditu.
     * 
     * @return Produktuen zerrenda.
     */
    @GetMapping
    public List<Produktuak> getAllProduktuak() {
        return produktuakService.getProduktuak();
    }

    /**
     * Produktu berri bat gehitzen du.
     * 
     * @param produ Gehitu nahi den Produktuaren informazioa.
     * @return Gehitu den Produktua.
     */
    @PostMapping
    public Produktuak addProduktu(@RequestBody Produktuak produ) {
        return produktuakService.saveProduktu(produ);
    }

    /**
     * Produktu bat partzialki eguneratzen du, aldaketa txikiak egiteko.
     * 
     * @param id Eguneratu nahi den Produktuaren identifikatzailea.
     * @param request Eguneratutako Produktuaren informazioa.
     * @return Eguneratutako Produktua.
     */
    @PatchMapping("/{id}")
    public Produktuak patchProduktu(@PathVariable Long id, @RequestBody Produktuak request) {
        return produktuakService.patchById(request, id);
    }

    /**
     * Id bat emanez, Produktu bat eskuratzea.
     * 
     * @param id Eskatutako Produktuaren identifikatzailea.
     * @return Eskaera egindako Produktuaren Optional.
     */
    @GetMapping("/{id}")
    public Optional<Produktuak> getProduktuById(@PathVariable Long id) {
        return produktuakService.getById(id);
    }

    /**
     * Id baten arabera, Produktu bat eguneratzea.
     * 
     * @param id Eguneratu nahi den Produktuaren identifikatzailea.
     * @param request Eguneratutako Produktuaren informazioa.
     * @return Eguneratutako Produktua.
     */
    @PutMapping("/{id}")
    public Produktuak updateProduktu(@PathVariable Long id, @RequestBody Produktuak request) {
        return produktuakService.updateById(request, id);
    }

    /**
     * Produktu bat "ezabatzea" (egonkor markatzea), hau da, ezabatzea simulatzea.
     * 
     * @param id Ezabatu nahi den Produktuaren identifikatzailea.
     * @return Erantzuna, egonkor markatzea lortu bada edo ez.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> softDeleteProduktu(@PathVariable Long id) {
        boolean deleted = produktuakService.softDeleteProduktu(id);
        if (deleted) {
            return ResponseEntity.ok("Produktuak with id: " + id + " marked as deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produktuak not found.");
        }
    }
}
