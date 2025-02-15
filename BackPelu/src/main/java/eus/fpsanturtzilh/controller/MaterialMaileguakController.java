package eus.fpsanturtzilh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.entity.Material_maileguak;
import eus.fpsanturtzilh.service.MaterialMaileguakService;

/**
 * Materialen maileguak kudeatzeko kontrolatzailea.
 * APIaren bidez maileguak sortu, kontsultatu, eguneratu eta ezabatzeko metodoak eskaintzen ditu.
 */
@RestController
@RequestMapping("/material_maileguak")
@CrossOrigin(origins = "http://localhost:8100")
public class MaterialMaileguakController {
    
    @Autowired
    private MaterialMaileguakService materialMaileguakService;

    /**
     * Materialen mailegu guztien zerrenda lortzen du.
     * @return Material_maileguak objektuen zerrenda.
     */
    @GetMapping
    public List<Material_maileguak> getAllMaterialMaileguak() {
        return materialMaileguakService.getMaterialMaileguak();
    }

    /**
     * Material mailegu berria gehitzen du.
     * @param materialak Gehitu beharreko material mailegua.
     * @return Sortutako Material_maileguak objektua.
     */
    @PostMapping
    public Material_maileguak addMaterialMailegu(@RequestBody Material_maileguak materialak) {
        return materialMaileguakService.saveMaterialMailegua(materialak);
    }
    
    /**
     * ID baten arabera material mailegu bat bilatzen du.
     * @param id Bilatu beharreko material maileguaren IDa.
     * @return Aurkitutako Material_maileguak objektua (Optional).
     */
    @GetMapping("/{id}")
    public Optional<Material_maileguak> getMaterialById(@PathVariable Long id) {
        return materialMaileguakService.getById(id);
    }

    /**
     * Material mailegu baten datuak eguneratzen ditu.
     * @param id Eguneratu beharreko material maileguaren IDa.
     * @param request Eguneratutako datuak dituen objektua.
     * @return Eguneratutako Material_maileguak objektua.
     */
    @PutMapping("/{id}")
    public Material_maileguak updateMaterial(@PathVariable Long id, @RequestBody Material_maileguak request) {
        return materialMaileguakService.updateById(request, id);
    }
    
    /**
     * Material mailegu bat ezabatzen du modu logikoan (soft delete).
     * @param id Ezabatu beharreko material maileguaren IDa.
     * @return Eragiketaren emaitzaren ResponseEntity mezu bat.
     */
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
