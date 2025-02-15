package eus.fpsanturtzilh.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.entity.Txandak;
import eus.fpsanturtzilh.service.TxandakService;

/**
 * {@link TxandakController} klaseak Txandak entitatearekin lotutako HTTP eskaerak kudeatzen ditu.
 * REST API bidez, erabiltzaileek Txandak datu basearekin interakzionatu ahal izango dute.
 * 
 * <p>Klase honek CRUD (Sortu, Irakurri, Eguneratu, Ezabatu) operazioak eskaintzen ditu:
 * <ul>
 *   <li>{@code getAllTxandak}: Txandak guztiak eskuratzea.</li>
 *   <li>{@code getTurnosPorFecha}: Egutegiko egunean zehar dituzten txandak eskuratzea.</li>
 *   <li>{@code addTxanda}: Txanda bat gehitzea.</li>
 *   <li>{@code getTxandaById}: Txanda bat eskuratzea bere IDaren arabera.</li>
 *   <li>{@code updateTxanda}: Txanda bat eguneratzea bere IDaren arabera.</li>
 *   <li>{@code softDeleteTxanda}: Txanda bat "ezabatzea" (egonkor markatzea) bere IDaren arabera.</li>
 * </ul>
 * </p>
 * 
 * <p>API honen bidez, bezeroek edo erabiltzaileek Txandak kudeatu eta eguneratu ahal izango dituzte.
 * </p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@RestController
@RequestMapping("/txandak")
@CrossOrigin(origins = "http://localhost:8100") // Configurar para permitir solicitudes desde el frontend
public class TxandakController {
    
    @Autowired
    private TxandakService txandakService;

    /**
     * Txandak guztiak eskuratzen ditu.
     * 
     * @return Txandak-en zerrenda.
     */
    @GetMapping
    public List<Txandak> getAllTxandak() {
        return txandakService.getTxandak();
    }

    /**
     * Egutegiko egunean zehar dituzten txandak eskuratzea.
     * 
     * @param fecha Txandak eskuratu nahi diren eguna (formato ISO: yyyy-MM-dd).
     * @return Txandak-en zerrenda egunean zehar.
     */
    @GetMapping("/fecha/{fecha}")
    public List<Txandak> getTurnosPorFecha(@PathVariable String fecha) {
        LocalDate fechaConsulta = LocalDate.parse(fecha);
        return txandakService.getTurnosDelDia(fechaConsulta);
    }

    /**
     * Txanda bat gehitzen du.
     * 
     * @param txanda Gehitu nahi den Txanda.
     * @return Gehitu den Txanda.
     */
    @PostMapping
    public Txandak addTxanda(@RequestBody Txandak txanda) {
        return txandakService.saveTxanda(txanda);
    }

    /**
     * IDaren arabera, Txanda bat eskuratzea.
     * 
     * @param id Eskatutako Txanda-en identifikatzailea.
     * @return Eskaera egindako Txanda.
     */
    @GetMapping("/{id}")
    public Optional<Txandak> getTxandaById(@PathVariable Long id) {
        return txandakService.getById(id);
    }

    /**
     * Txanda bat eguneratzea IDaren arabera.
     * 
     * @param id Eguneratu nahi den Txanda-en identifikatzailea.
     * @param request Eguneratu nahi den Txanda-ren informazioa.
     * @return Eguneratutako Txanda.
     */
    @PutMapping("/{id}")
    public Txandak updateTxanda(@PathVariable Long id, @RequestBody Txandak request) {
        return txandakService.updateById(request, id);
    }

    /**
     * Txanda bat "ezabatzea" (egonkor markatzea) IDaren arabera.
     * 
     * @param id Ezabatu nahi den Txanda-en identifikatzailea.
     * @return Erantzuna, egonkor markatzea lortu bada edo ez.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> softDeleteTxanda(@PathVariable Long id) {
        boolean deleted = txandakService.softDeleteTxanda(id);
        if (deleted) {
            return ResponseEntity.ok("Txanda with id: " + id + " marked as deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Txanda not found.");
        }
    }
}
