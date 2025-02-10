package eus.fpsanturtzilh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.entity.Kolore_historialak;
import eus.fpsanturtzilh.service.KoloreHistorialakService;

@RestController
@RequestMapping("/kolore-historialak")
@CrossOrigin(origins = "http://localhost:8100")
public class KoloreHistorialakController {
    
    @Autowired
    private KoloreHistorialakService koloreHistorialakService;

    @GetMapping
    public List<Kolore_historialak> getAllKoloreHistorialak() {
        return koloreHistorialakService.getKoloreHistorialak();
    }

    @PostMapping
    public Kolore_historialak addKoloreHistoriala(@RequestBody Kolore_historialak koloreHistoriala) {
        return koloreHistorialakService.saveKoloreHistoriala(koloreHistoriala);
    }

    @GetMapping("/{id}")
    public Optional<Kolore_historialak> getKoloreHistorialaById(@PathVariable Long id) {
        return koloreHistorialakService.getById(id);
    }

    @PutMapping("/{id}")
    public Kolore_historialak updateKoloreHistoriala(@PathVariable Long id, @RequestBody Kolore_historialak request) {
        return koloreHistorialakService.updateById(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteKoloreHistoriala(@PathVariable Long id) {
        boolean ok = koloreHistorialakService.deleteKoloreHistoriala(id);
        return ok ? "Kolore historiala with id: " + id + " Deleted" : "Error";
    }
}
