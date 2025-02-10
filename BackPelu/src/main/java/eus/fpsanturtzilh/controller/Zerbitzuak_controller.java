package eus.fpsanturtzilh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.entity.Zerbitzuak;
import eus.fpsanturtzilh.service.Zerbitzuak_service;

@RestController
@RequestMapping("/zerbitzuak")
@CrossOrigin(origins = "http://localhost:8100")
public class Zerbitzuak_controller {
    
    @Autowired
    private Zerbitzuak_service zerbitzuak_service;

    @GetMapping
    public List<Zerbitzuak> getZerbitzuak() {
        return this.zerbitzuak_service.getZerbitzuak();
    }

    @GetMapping("/{id}")
    public Optional<Zerbitzuak> getZerbitzuakById(@PathVariable Long id) {
        return this.zerbitzuak_service.getById(id);
    }

    @PostMapping
    public Zerbitzuak saveZerbitzuak(@RequestBody Zerbitzuak zerbi) {
        return this.zerbitzuak_service.saveZerbitzuak(zerbi);
    }

    @PutMapping("/{id}")
    public Zerbitzuak updateZerbitzuakById(@PathVariable Long id, @RequestBody Zerbitzuak request) {
        return this.zerbitzuak_service.updateById(request, id);
    }

    @PatchMapping("/{id}")
    public Zerbitzuak patchZerbitzu(@PathVariable Long id, @RequestBody Zerbitzuak request) {
        return zerbitzuak_service.patchById(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteZerbitzuakById(@PathVariable Long id) {
        boolean ok = this.zerbitzuak_service.deleteZerbitzuak(id);
        if (ok) {
            return "Service with id: " + id + " deleted successfully.";
        } else {
            return "Error: Could not delete service with id: " + id;
        }
    }
}
