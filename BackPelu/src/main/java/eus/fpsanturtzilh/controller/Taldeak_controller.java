package eus.fpsanturtzilh.controller;

import eus.fpsanturtzilh.entity.Taldeak;
import eus.fpsanturtzilh.service.Taldeak_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taldeak")
@CrossOrigin(origins = "*") // Configurar para permitir solicitudes desde el frontend
public class Taldeak_controller {

    @Autowired
    private Taldeak_service taldeakService;

    // Obtener todos los grupos
    @GetMapping
    public List<Taldeak> getAllGroups() {
        return taldeakService.getAllGroups();
    }

    // Obtener un grupo por código
    @GetMapping("/{kodea}")
    public ResponseEntity<Taldeak> getGroupById(@PathVariable String kodea) {
        return taldeakService.getGroupById(kodea)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Añadir o actualizar un grupo
    @PostMapping
    public Taldeak addOrUpdateGroup(@RequestBody Taldeak taldeak) {
        return taldeakService.saveOrUpdateGroup(taldeak);
    }
    @DeleteMapping("/{kodea}")
    public ResponseEntity<String> softDeleteGroup(@PathVariable String kodea) {
        boolean deleted = taldeakService.softDeleteGroup(kodea);
        if (deleted) {
            return ResponseEntity.ok("Taldeak with kodea: " + kodea + " marked as deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Taldeak not found.");
        }
    }

}
