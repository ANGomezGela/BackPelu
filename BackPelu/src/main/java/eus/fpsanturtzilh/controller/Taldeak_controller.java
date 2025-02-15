package eus.fpsanturtzilh.controller;

import eus.fpsanturtzilh.entity.Taldeak;
import eus.fpsanturtzilh.service.Taldeak_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * {@link Taldeak_controller} klaseak Taldeak entitatearekin lotutako HTTP eskaerak kudeatzen ditu.
 * REST API bidez, erabiltzaileek Taldeak datu basearekin interakzionatu ahal izango dute.
 * 
 * <p>Klase honek CRUD (Sortu, Irakurri, Eguneratu, Ezabatu) operazioak eskaintzen ditu:
 * <ul>
 *   <li>{@code getAllGroups}: Talde guztiak eskuratzea.</li>
 *   <li>{@code getGroupById}: Talde bat kodearen arabera eskuratzea.</li>
 *   <li>{@code addOrUpdateGroup}: Talde bat gehitzea edo eguneratzea.</li>
 *   <li>{@code softDeleteGroup}: Talde bat "ezabatzea" (egonkor markatzea) bere kodearen arabera.</li>
 * </ul>
 * </p>
 * 
 * <p>API honen bidez, bezeroek edo erabiltzaileek Taldeak kudeatu eta eguneratu ahal izango dituzte.
 * </p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@RestController
@RequestMapping("/taldeak")
@CrossOrigin(origins = "*") // Configurar para permitir solicitudes desde el frontend
public class Taldeak_controller {

    @Autowired
    private Taldeak_service taldeakService;

    /**
     * Talde guztiak eskuratzen ditu.
     * 
     * @return Taldeen zerrenda.
     */
    @GetMapping
    public List<Taldeak> getAllGroups() {
        return taldeakService.getAllGroups();
    }

    /**
     * Kodea emanez, Talde bat eskuratzea.
     * 
     * @param kodea Eskatutako Taldearen identifikatzailea.
     * @return Eskaera egindako Taldearen ResponseEntity.
     */
    @GetMapping("/{kodea}")
    public ResponseEntity<Taldeak> getGroupById(@PathVariable String kodea) {
        return taldeakService.getGroupById(kodea)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Talde bat gehitzen edo eguneratzen du.
     * 
     * @param taldeak Gehitu edo eguneratu nahi den Taldearen informazioa.
     * @return Gehitu edo eguneratutako Taldea.
     */
    @PostMapping
    public Taldeak addOrUpdateGroup(@RequestBody Taldeak taldeak) {
        return taldeakService.saveOrUpdateGroup(taldeak);
    }

    /**
     * Talde bat "ezabatzea" (egonkor markatzea), hau da, ezabatzea simulatzea.
     * 
     * @param kodea Ezabatu nahi den Taldearen identifikatzailea.
     * @return Erantzuna, egonkor markatzea lortu bada edo ez.
     */
    @DeleteMapping("/{kodea}")
    public ResponseEntity<String> softDeleteGroup(@PathVariable String kodea) {
        boolean deleted = taldeakService.softDeleteGroup(kodea);
        if (deleted) {
            return ResponseEntity.ok("Taldeak with kodea: " + kodea + " marked as deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Taldeak not found.");
        }
    }
}
