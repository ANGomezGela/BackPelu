package eus.fpsanturtzilh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.entity.Materialak;
import eus.fpsanturtzilh.service.MaterialakService;

/**
 * MaterialakController klasea, materialei buruzko HTTP eskaerak kudeatzen dituena.
 */
@RestController
@RequestMapping("/materialak")
@CrossOrigin(origins = "*")
public class MaterialakController {
    
    @Autowired
    private MaterialakService materialakService;

    /**
     * Material guztiak itzultzen ditu.
     * @return Materialen zerrenda.
     */
    @GetMapping
    public List<Materialak> getAllMaterialak() {
        return materialakService.getMaterialak();
    }

    /**
     * Material berri bat gehitzen du.
     * @param materiala Gehitu nahi den materialaren objektua.
     * @return Gehitutako materiala.
     */
    @PostMapping
    public Materialak addMateriala(@RequestBody Materialak materiala) {
        return materialakService.saveMateriala(materiala);
    }
    
    /**
     * Material bat eguneratzen du partzialki.
     * @param id Eguneratu nahi den materialaren IDa.
     * @param request Material eguneratuaren informazioa.
     * @return Eguneratutako materiala.
     */
    @PatchMapping("/{id}")
    public Materialak patchMaterial(@PathVariable Long id, @RequestBody Materialak request) {
        return materialakService.patchById(request, id);
    }

    /**
     * ID baten bidez material bat bilatzen du.
     * @param id Bilatu nahi den materialaren IDa.
     * @return Materialaren objektua (aurkituz gero).
     */
    @GetMapping("/{id}")
    public Optional<Materialak> getMaterialaById(@PathVariable Long id) {
        return materialakService.getById(id);
    }

    /**
     * Material bat osorik eguneratzen du.
     * @param id Eguneratu nahi den materialaren IDa.
     * @param request Material eguneratuaren informazioa.
     * @return Eguneratutako materiala.
     */
    @PutMapping("/{id}")
    public Materialak updateMateriala(@PathVariable Long id, @RequestBody Materialak request) {
        return materialakService.updateById(request, id);
    }
    
    /**
     * Material bat ezabatzea simulatzen du (ezabatu beharrean, baja-data ezartzen du).
     * @param id Ezabatu nahi den materialaren IDa.
     * @return Mezua, materiala ezabatu dela edo ez dagoela adieraziz.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> softDeleteMateriala(@PathVariable Long id) {
        boolean deleted = materialakService.softDeleteMateriala(id);
        if (deleted) {
            return ResponseEntity.ok("Materiala with id: " + id + " marked as deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Materiala not found.");
        }
    }
}
