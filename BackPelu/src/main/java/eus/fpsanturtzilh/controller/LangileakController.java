package eus.fpsanturtzilh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.entity.Langileak;
import eus.fpsanturtzilh.service.LangileakService;

@RestController
@RequestMapping("/langileak")
@CrossOrigin(origins = "http://localhost:8100")

public class LangileakController {
    
    @Autowired
    private LangileakService langileakService;

    @GetMapping
    public List<Langileak> getAllLangileak() {
        return langileakService.getLangileak();
    }

    @PostMapping
    public Langileak addLangilea(@RequestBody Langileak langilea) {
        return langileakService.saveLangilea(langilea);
    }

    @GetMapping("/{id}")
    public Optional<Langileak> getLangileaById(@PathVariable Long id) {
        return langileakService.getById(id);
    }

    @PutMapping("/{id}")
    public Langileak updateLangilea(@PathVariable Long id, @RequestBody Langileak request) {
        return langileakService.updateById(request, id);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> softDeleteLangilea(@PathVariable Long id) {
        boolean deleted = langileakService.softDeleteLangilea(id);
        if (deleted) {
            return ResponseEntity.ok("Langilea with id: " + id + " marked as deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Langilea not found.");
        }
    }


}
