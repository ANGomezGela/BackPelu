package eus.fpsanturtzilh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.entity.Kolore_historialak;
import eus.fpsanturtzilh.service.KoloreHistorialakService;

/**
 * Kolore historialen kontrolatzailea.
 * Endpoint hauek erabiliz, kolore historialen erregistroak sortu, eskuratu, eguneratu eta ezabatu daitezke.
 */
@RestController
@RequestMapping("/kolore-historialak")
@CrossOrigin(origins = "http://localhost:8100")
public class KoloreHistorialakController {
    
    @Autowired
    private KoloreHistorialakService koloreHistorialakService;

    /**
     * Kolore historial guztien zerrenda eskuratzen du.
     * @return Kolore historialen zerrenda.
     */
    @GetMapping
    public List<Kolore_historialak> getAllKoloreHistorialak() {
        return koloreHistorialakService.getKoloreHistorialak();
    }

    /**
     * Kolore historial berri bat sortzen du.
     * @param koloreHistoriala Sortu beharreko kolore historialaren datuak.
     * @return Sortutako kolore historialaren objektua.
     */
    @PostMapping
    public Kolore_historialak addKoloreHistoriala(@RequestBody Kolore_historialak koloreHistoriala) {
        return koloreHistorialakService.saveKoloreHistoriala(koloreHistoriala);
    }

    /**
     * ID jakin bateko kolore historial bat eskuratzen du.
     * @param id Bilatu beharreko kolore historialaren identifikadorea.
     * @return Aurkitutako kolore historialaren objektua edo Optional huts bat.
     */
    @GetMapping("/{id}")
    public Optional<Kolore_historialak> getKoloreHistorialaById(@PathVariable Long id) {
        return koloreHistorialakService.getById(id);
    }

    /**
     * ID jakin bateko kolore historial bat eguneratzen du.
     * @param id Eguneratu beharreko kolore historialaren identifikadorea.
     * @param request Eguneratutako datuak dituen objektua.
     * @return Eguneratutako kolore historialaren objektua.
     */
    @PutMapping("/{id}")
    public Kolore_historialak updateKoloreHistoriala(@PathVariable Long id, @RequestBody Kolore_historialak request) {
        return koloreHistorialakService.updateById(request, id);
    }
    
    /**
     * Kolore historial bat "ezabatutzat" markatzen du IDaren arabera (ezabatze logikoa).
     * @param id Ezabatu beharreko kolore historialaren identifikadorea.
     * @return Mezua, ezabapena arrakastatsua izan den edo ez adieraziz.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> softDeleteKoloreHistoriala(@PathVariable Long id) {
        boolean deleted = koloreHistorialakService.softDeleteKoloreHistoriala(id);
        if (deleted) {
            return ResponseEntity.ok("Kolore historiala IDarekin: " + id + " ezabatutzat markatu da.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kolore historiala ez da aurkitu.");
        }
    }
}
