package eus.fpsanturtzilh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.entity.Material_maileguak;
import eus.fpsanturtzilh.entity.Ordutegiak;
import eus.fpsanturtzilh.service.MaterialMaileguakService;
import eus.fpsanturtzilh.service.Ordutegiak_service;

@RestController
@RequestMapping("/material_maileguak")
@CrossOrigin(origins = "http://localhost:8100")

public class MaterialMaileguakController {
    
    @Autowired
    private MaterialMaileguakService materialMaileguakService;

    @GetMapping
    public List<Material_maileguak> getAllMaterialMaileguak() {
        return materialMaileguakService.getMaterialMaileguak();
    }

    @PostMapping
    public Material_maileguak addMaterialMailegu(@RequestBody Material_maileguak materialak) {
        return materialMaileguakService.saveMaterialMailegua(materialak);
    }
    

    @GetMapping("/{id}")
    public Optional<Material_maileguak> getMaterialById(@PathVariable Long id) {
        return materialMaileguakService.getById(id);
    }

    @PutMapping("/{id}")
    public Material_maileguak updateMaterial(@PathVariable Long id, @RequestBody Material_maileguak request) {
        return materialMaileguakService.updateById(request, id);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> softDeleteMaterialMailegua(@PathVariable Long id) {
        boolean deleted = materialMaileguakService.softDeleteMaterialMailegua(id);
        if (deleted) {
            return ResponseEntity.ok("Material mailegua with id: " + id + " marked as deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Material mailegua not found.");
        }
    }
    
}
