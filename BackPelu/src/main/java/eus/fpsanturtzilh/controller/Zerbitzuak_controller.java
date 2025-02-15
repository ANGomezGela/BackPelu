package eus.fpsanturtzilh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.entity.Zerbitzuak;
import eus.fpsanturtzilh.service.Zerbitzuak_service;

/**
 * {@link Zerbitzuak_controller} klaseak Zerbitzuak entitatearekin lotutako HTTP eskaerak kudeatzen ditu.
 * REST API bidez, erabiltzaileek Zerbitzuak datu basearekin interakzionatu ahal izango dute.
 * 
 * <p>Klase honek CRUD (Sortu, Irakurri, Eguneratu, Ezabatu) operazioak eskaintzen ditu:
 * <ul>
 *   <li>{@code getZerbitzuak}: Zerbitzu guztiak eskuratzea.</li>
 *   <li>{@code getZerbitzuakById}: Zerbitzu bat eskuratzea bere IDaren arabera.</li>
 *   <li>{@code saveZerbitzuak}: Zerbitzu bat gehitzea.</li>
 *   <li>{@code updateZerbitzuakById}: Zerbitzu bat eguneratzea bere IDaren arabera.</li>
 *   <li>{@code patchZerbitzu}: Zerbitzu bat eguneratzea partzialki.</li>
 *   <li>{@code softDeleteZerbitzuak}: Zerbitzu bat "ezabatzea" (egonkor markatzea) bere IDaren arabera.</li>
 * </ul>
 * </p>
 * 
 * <p>API honen bidez, bezeroek edo erabiltzaileek Zerbitzuak kudeatu eta eguneratu ahal izango dituzte.
 * </p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@RestController
@RequestMapping("/zerbitzuak")
@CrossOrigin(origins = "http://localhost:8100") // Configurar para permitir solicitudes desde el frontend
public class Zerbitzuak_controller {
    
    @Autowired
    private Zerbitzuak_service zerbitzuak_service;

    /**
     * Zerbitzu guztiak eskuratzen ditu.
     * 
     * @return Zerbitzu-en zerrenda.
     */
    @GetMapping
    public List<Zerbitzuak> getZerbitzuak() {
        return this.zerbitzuak_service.getZerbitzuak();
    }

    /**
     * Zerbitzu bat eskuratzea bere IDaren arabera.
     * 
     * @param id Eskatutako Zerbitzuaren identifikatzailea.
     * @return Eskaera egindako Zerbitzua.
     */
    @GetMapping("/{id}")
    public Optional<Zerbitzuak> getZerbitzuakById(@PathVariable Long id) {
        return this.zerbitzuak_service.getById(id);
    }

    /**
     * Zerbitzu bat gehitzen du.
     * 
     * @param zerbi Gehitu nahi den Zerbitzuaren informazioa.
     * @return Gehitu den Zerbitzua.
     */
    @PostMapping
    public Zerbitzuak saveZerbitzuak(@RequestBody Zerbitzuak zerbi) {
        return this.zerbitzuak_service.saveZerbitzuak(zerbi);
    }

    /**
     * Zerbitzu bat eguneratzea bere IDaren arabera.
     * 
     * @param id Eguneratu nahi den Zerbitzuaren identifikatzailea.
     * @param request Eguneratu nahi den Zerbitzuaren informazioa.
     * @return Eguneratutako Zerbitzua.
     */
    @PutMapping("/{id}")
    public Zerbitzuak updateZerbitzuakById(@PathVariable Long id, @RequestBody Zerbitzuak request) {
        return this.zerbitzuak_service.updateById(request, id);
    }

    /**
     * Zerbitzu bat eguneratzea partzialki (Patch) bere IDaren arabera.
     * 
     * @param id Eguneratu nahi den Zerbitzuaren identifikatzailea.
     * @param request Eguneratu nahi den Zerbitzuaren informazio partziala.
     * @return Eguneratutako Zerbitzua.
     */
    @PatchMapping("/{id}")
    public Zerbitzuak patchZerbitzu(@PathVariable Long id, @RequestBody Zerbitzuak request) {
        return zerbitzuak_service.patchById(request, id);
    }

    /**
     * Zerbitzu bat "ezabatzea" (egonkor markatzea) IDaren arabera.
     * 
     * @param id Ezabatu nahi den Zerbitzuaren identifikatzailea.
     * @return Erantzuna, egonkor markatzea lortu bada edo ez.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> softDeleteZerbitzuak(@PathVariable Long id) {
        boolean deleted = zerbitzuak_service.softDeleteZerbitzuak(id);
        if (deleted) {
            return ResponseEntity.ok("Zerbitzuak with id: " + id + " marked as deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Zerbitzuak not found.");
        }
    }
}
