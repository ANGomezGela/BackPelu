package eus.fpsanturtzilh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
    public String deleteProduktu(@PathVariable Long id) {
        boolean ok = produktuakService.deleteProduktu(id);
        return ok ? "Product with id: " + id + " Deleted" : "Error";
    }
}
