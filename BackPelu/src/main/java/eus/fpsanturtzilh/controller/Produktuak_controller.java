package eus.fpsanturtzilh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.entity.Produktuak;
import eus.fpsanturtzilh.service.Produktuak_service;

@RestController
@RequestMapping("/produktuak")
@CrossOrigin(origins = "http://localhost:8100")  // Permitir peticiones desde Ionic

public class Produktuak_controller {
    
    @Autowired
    private Produktuak_service produktuakService;

    @GetMapping
    public List<Produktuak> getAllProduktuak() {
        return produktuakService.getProduktuak();
    }

    @PostMapping
    public Produktuak addProduktu(@RequestBody Produktuak produ) {
        return produktuakService.saveProduktu(produ);
    }
    
    @PatchMapping("/{id}")
    public Produktuak patchProduktu(@PathVariable Long id, @RequestBody Produktuak request) {
        return produktuakService.patchById(request, id);
    }

    

    @GetMapping("/{id}")
    public Optional<Produktuak> getProduktuById(@PathVariable Long id) {
        return produktuakService.getById(id);
    }

    @PutMapping("/{id}")
    public Produktuak updateProduktu(@PathVariable Long id, @RequestBody Produktuak request) {
        return produktuakService.updateById(request, id);
    }
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
