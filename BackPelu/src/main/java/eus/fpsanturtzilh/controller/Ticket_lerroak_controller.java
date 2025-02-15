package eus.fpsanturtzilh.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eus.fpsanturtzilh.entity.Ticket_lerroak;
import eus.fpsanturtzilh.service.Ticket_lerroak_service;

/**
 * {@link Ticket_lerroak_controller} klaseak Ticket_lerroak entitatearekin lotutako HTTP eskaerak kudeatzen ditu.
 * REST API bidez, erabiltzaileek Ticket_lerroak datu basearekin interakzionatu ahal izango dute.
 * 
 * <p>Klase honek CRUD (Sortu, Irakurri, Eguneratu, Ezabatu) operazioak eskaintzen ditu:
 * <ul>
 *   <li>{@code getLerroservice}: Ticket_lerroak guztiak eskuratzea.</li>
 *   <li>{@code saveLerro}: Ticket_lerroak bat gehitzea.</li>
 *   <li>{@code getLerroId}: Ticket_lerroak bat eskuratzea bere IDaren arabera.</li>
 *   <li>{@code updateLerroById}: Ticket_lerroak bat eguneratzea bere IDaren arabera.</li>
 *   <li>{@code softDeleteLerro}: Ticket_lerroak bat "ezabatzea" (egonkor markatzea) bere IDaren arabera.</li>
 * </ul>
 * </p>
 * 
 * <p>API honen bidez, bezeroek edo erabiltzaileek Ticket_lerroak kudeatu eta eguneratu ahal izango dituzte.
 * </p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@RestController
@RequestMapping("/ticket_lerroak_controler")
@CrossOrigin(origins = "http://localhost:8100") // Configurar para permitir solicitudes desde el frontend
public class Ticket_lerroak_controller {

    @Autowired
    private Ticket_lerroak_service ticket_lerroak_service;
    
    /**
     * Ticket_lerroak guztiak eskuratzen ditu.
     * 
     * @return Ticket_lerroak-en zerrenda.
     */
    @GetMapping
    public ArrayList<Ticket_lerroak> getLerroservice() {
        return this.ticket_lerroak_service.getLerroservice();
    }
    
    /**
     * Ticket_lerroak bat gehitzen du.
     * 
     * @param course Gehitu nahi den Ticket_lerroak.
     * @return Gehitu den Ticket_lerroak.
     */
    @PostMapping
    public Ticket_lerroak saveLerro(@RequestBody Ticket_lerroak course) {
        return this.ticket_lerroak_service.saveLerroservice(course);
    }
    
    /**
     * IDaren arabera, Ticket_lerroak bat eskuratzea.
     * 
     * @param id Eskatutako Ticket_lerroak-en identifikatzailea.
     * @return Eskaera egindako Ticket_lerroak.
     */
    @GetMapping(path = "/{id}")
    public Optional<Ticket_lerroak> getLerroId(@PathVariable Long id) {
        return this.ticket_lerroak_service.getById(id);
    }

    /**
     * Ticket_lerroak bat eguneratzea IDaren arabera.
     * 
     * @param request Eguneratu nahi den Ticket_lerroak-en informazioa.
     * @param id Eguneratu nahi den Ticket_lerroak-en identifikatzailea.
     * @return Eguneratutako Ticket_lerroak.
     */
    @PutMapping(path = "/{id}")
    public Ticket_lerroak updateLerroById(@RequestBody Ticket_lerroak request, Long id) {
        return this.ticket_lerroak_service.updateById(request, id);
    }

    /**
     * Ticket_lerroak bat "ezabatzea" (egonkor markatzea) IDaren arabera.
     * 
     * @param id Ezabatu nahi den Ticket_lerroak-en identifikatzailea.
     * @return Erantzuna, egonkor markatzea lortu bada edo ez.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> softDeleteLerro(@PathVariable Long id) {
        boolean deleted = ticket_lerroak_service.softDeleteLerro(id);
        if (deleted) {
            return ResponseEntity.ok("Ticket_lerroak with id: " + id + " marked as deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket_lerroak not found.");
        }
    }
}
