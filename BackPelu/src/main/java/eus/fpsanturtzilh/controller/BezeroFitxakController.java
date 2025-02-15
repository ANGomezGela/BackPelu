package eus.fpsanturtzilh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.entity.Bezero_fitxak;
import eus.fpsanturtzilh.service.BezeroFitxakService;

/**
 * BezeroFitxakController klasea bezeroen datuak kudeatzeko REST API kontrolatzailea da.
 * HTTP eskaerei erantzuten die eta BezeroFitxakService zerbitzuarekin komunikatzen da.
 */
@RestController
@RequestMapping("/bezeroak")
@CrossOrigin(origins = "http://localhost:8100")
public class BezeroFitxakController {
    
    @Autowired
    private BezeroFitxakService bezeroFitxakService;

    /**
     * Bezero guztiak lortzen ditu.
     * @return Bezeroen zerrenda
     */
    @GetMapping
    public List<Bezero_fitxak> getAllBezeroak() {
        return bezeroFitxakService.getBezeroak();
    }

    /**
     * Bezero berri bat gehitzen du.
     * @param bezeroa Bezeroaren datuak
     * @return Sortutako bezeroa
     */
    @PostMapping
    public Bezero_fitxak addBezeroa(@RequestBody Bezero_fitxak bezeroa) {
        return bezeroFitxakService.saveBezeroa(bezeroa);
    }

    /**
     * Bezero bat IDaren arabera bilatzen du.
     * @param id Bezeroaren identifikatzailea
     * @return Aurkitutako bezeroa (Optional)
     */
    @GetMapping("/{id}")
    public Optional<Bezero_fitxak> getBezeroaById(@PathVariable Long id) {
        return bezeroFitxakService.getById(id);
    }

    /**
     * Bezero baten datuak eguneratzen ditu.
     * @param id Bezeroaren identifikatzailea
     * @param request Eguneratutako datuak dituen objektua
     * @return Eguneratutako bezeroa
     */
    @PutMapping("/{id}")
    public Bezero_fitxak updateBezeroa(@PathVariable Long id, @RequestBody Bezero_fitxak request) {
        return bezeroFitxakService.updateById(request, id);
    }
    
    /**
     * Bezero bat ezabatzeko metodoa (soft delete), bezeroa aktibo gisa markatzen ez duena.
     * @param id Bezeroaren identifikatzailea
     * @return Erantzun mezua, arrakastatsua edo errorea
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> softDeleteBezeroa(@PathVariable Long id) {
        boolean ok = bezeroFitxakService.softDeleteBezeroa(id);
        if (ok) {
            return ResponseEntity.ok("Bezeroa with id: " + id + " marked as deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bezeroa not found");
        }
    }
}
