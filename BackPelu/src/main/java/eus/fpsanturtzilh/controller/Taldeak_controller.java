package eus.fpsanturtzilh.controller;

import eus.fpsanturtzilh.entity.Taldeak;
import eus.fpsanturtzilh.service.Taldeak_service;
import org.springframework.beans.factory.annotation.Autowired;
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

    // Eliminar un grupo por código
    @DeleteMapping("/{kodea}")
    public ResponseEntity<Void> deleteGroup(@PathVariable String kodea) {
        taldeakService.deleteGroup(kodea);
        return ResponseEntity.noContent().build();
    }
}
