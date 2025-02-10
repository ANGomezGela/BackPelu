package eus.fpsanturtzilh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.entity.Materialak;
import eus.fpsanturtzilh.service.MaterialakService;

@RestController
@RequestMapping("/materialak")
@CrossOrigin(origins = "*")

public class MaterialakController {
    
    @Autowired
    private MaterialakService materialakService;

    @GetMapping
    public List<Materialak> getAllMaterialak() {
        return materialakService.getMaterialak();
    }

    @PostMapping
    public Materialak addMateriala(@RequestBody Materialak materiala) {
        return materialakService.saveMateriala(materiala);
    }
    @PatchMapping("/{id}")
    public Materialak patchMaterial(@PathVariable Long id, @RequestBody Materialak request) {
        return materialakService.patchById(request, id);
    }


    @GetMapping("/{id}")
    public Optional<Materialak> getMaterialaById(@PathVariable Long id) {
        return materialakService.getById(id);
    }

    @PutMapping("/{id}")
    public Materialak updateMateriala(@PathVariable Long id, @RequestBody Materialak request) {
        return materialakService.updateById(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteMateriala(@PathVariable Long id) {
        boolean ok = materialakService.deleteMateriala(id);
        return ok ? "Materiala with id: " + id + " Deleted" : "Error";
    }
}
