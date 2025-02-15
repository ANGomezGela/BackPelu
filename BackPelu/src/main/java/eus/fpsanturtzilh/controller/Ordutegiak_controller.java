package eus.fpsanturtzilh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.entity.Ordutegiak;
import eus.fpsanturtzilh.service.Ordutegiak_service;

/**
 * {@link Ordutegiak_controller} klaseak Ordutegiak entitatearekin lotutako HTTP eskaerak kudeatzen ditu.
 * REST API bidez, erabiltzaileak Ordutegiak datu basearekin interakzionatu ahal izango du.
 * 
 * <p>Klase honek CRUD (Sortu, Irakurri, Eguneratu, Ezabatu) operazioak eskaintzen ditu:
 * <ul>
 *   <li>{@code getAllOrdutegiak}: Ordutegi guztien zerrenda eskuratzea.</li>
 *   <li>{@code addOrdutegia}: Ordutegi berri bat gehitzea.</li>
 *   <li>{@code getOrdutegiaById}: Id baten arabera Ordutegia eskuratzea.</li>
 *   <li>{@code updateOrdutegia}: Id baten arabera Ordutegia eguneratzea.</li>
 *   <li>{@code softDeleteOrdutegiak}: Ordutegia "ezabatzea" (egonkor markatzea) bere Id bidez.</li>
 * </ul>
 * </p>
 * 
 * <p>API honen bidez, bezeroek edo erabiltzaileek ordutegien kudeaketa egin dezakete.
 * CORS (Cross-Origin Resource Sharing) konfigurazioa aktibatuta dago, eta localhost:8100 helbideari baimena ematen zaio.</p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@RestController
@RequestMapping("/ordutegiak")
@CrossOrigin(origins = "http://localhost:8100")
public class Ordutegiak_controller {
    
    @Autowired
    private Ordutegiak_service ordutegiakService;

    /**
     * Ordutegi guztiak eskuratzen ditu.
     * 
     * @return Ordutegiak entitateen zerrenda.
     */
    @GetMapping
    public List<Ordutegiak> getAllOrdutegiak() {
        return ordutegiakService.getOrdutegiak();
    }

    /**
     * Ordutegi berri bat gehitzen du.
     * 
     * @param ordutegia Gehitu nahi den Ordutegiaren informazioa.
     * @return Gehitu den Ordutegia.
     */
    @PostMapping
    public Ordutegiak addOrdutegia(@RequestBody Ordutegiak ordutegia) {
        return ordutegiakService.saveOrdutegiak(ordutegia);
    }

    /**
     * Id bat emanez, Ordutegi bat eskuratzea.
     * 
     * @param id Eskatutako Ordutegiaren identifikatzailea.
     * @return Eskaera egindako Ordutegiaren Optional.
     */
    @GetMapping("/{id}")
    public Optional<Ordutegiak> getOrdutegiaById(@PathVariable Long id) {
        return ordutegiakService.getById(id);
    }

    /**
     * Id baten arabera, Ordutegi bat eguneratzea.
     * 
     * @param id Eguneratu nahi den Ordutegiaren identifikatzailea.
     * @param request Eguneratutako Ordutegiaren informazioa.
     * @return Eguneratutako Ordutegia.
     */
    @PutMapping("/{id}")
    public Ordutegiak updateOrdutegia(@PathVariable Long id, @RequestBody Ordutegiak request) {
        return ordutegiakService.updateById(request, id);
    }
    
    /**
     * Ordutegi bat "ezabatzea" (egonkor markatzea), hau da, ezabatzea simulatzea.
     * 
     * @param id Ezabatu nahi den Ordutegiaren identifikatzailea.
     * @return Erantzuna, egonkor markatzea lortu bada edo ez.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> softDeleteOrdutegiak(@PathVariable Long id) {
        boolean deleted = ordutegiakService.softDeleteOrdutegiak(id);
        if (deleted) {
            return ResponseEntity.ok("Ordutegiak with id: " + id + " marked as deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ordutegiak not found.");
        }
    }
}
