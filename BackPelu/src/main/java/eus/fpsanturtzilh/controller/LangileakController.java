package eus.fpsanturtzilh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.entity.Langileak;
import eus.fpsanturtzilh.service.LangileakService;

/**
 * Langileen kontrolatzailea. APIaren endpoint-ak kudeatzen ditu.
 */
@RestController
@RequestMapping("/langileak")
@CrossOrigin(origins = "http://localhost:8100")
public class LangileakController {
    
    @Autowired
    private LangileakService langileakService;

    /**
     * Langile guztiak itzultzen ditu.
     * @return Langileen zerrenda.
     */
    @GetMapping
    public List<Langileak> getAllLangileak() {
        return langileakService.getLangileak();
    }

    /**
     * Langile berri bat gehitzen du.
     * @param langilea Gehitu nahi den langilea.
     * @return Sortutako langilea.
     */
    @PostMapping
    public Langileak addLangilea(@RequestBody Langileak langilea) {
        return langileakService.saveLangilea(langilea);
    }

    /**
     * Langile bat bilatzen du bere IDaren arabera.
     * @param id Langilearen IDa.
     * @return Langilearen datuak, aurkituz gero.
     */
    @GetMapping("/{id}")
    public Optional<Langileak> getLangileaById(@PathVariable Long id) {
        return langileakService.getById(id);
    }

    /**
     * Langile bat eguneratzen du bere IDaren arabera.
     * @param id Eguneratu nahi den langilearen IDa.
     * @param request Eguneratutako datuak dituen objektua.
     * @return Eguneratutako langilea.
     */
    @PutMapping("/{id}")
    public Langileak updateLangilea(@PathVariable Long id, @RequestBody Langileak request) {
        return langileakService.updateById(request, id);
    }
    
    /**
     * Langile bat "ezabatutzat" markatzen du bere IDaren arabera.
     * @param id Ezabatu nahi den langilearen IDa.
     * @return Mezua, langilea aurkitu bada edo ez.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> softDeleteLangilea(@PathVariable Long id) {
        boolean deleted = langileakService.softDeleteLangilea(id);
        if (deleted) {
            return ResponseEntity.ok("Langilea IDarekin: " + id + " ezabatutzat markatu da.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Langilea ez da aurkitu.");
        }
    }
}
