package eus.fpsanturtzilh.controller;

import eus.fpsanturtzilh.entity.Erabiltzaileak;
import eus.fpsanturtzilh.service.Erabiltzaileak_service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/erabiltzaileak") 
public class Erabiltzaileak_controller {

    private final Erabiltzaileak_service erabiltzaileakService;

    public Erabiltzaileak_controller(Erabiltzaileak_service erabiltzaileakService) {
        this.erabiltzaileakService = erabiltzaileakService;
    }

    // Solo necesitamos obtener todos los usuarios
    @GetMapping
    public List<Erabiltzaileak> getAll() {
        return erabiltzaileakService.findAll();
    }

    // Obtener un usuario por su username
    @GetMapping("/{username}")
    public ResponseEntity<Erabiltzaileak> getByUsername(@PathVariable String username) {
        return erabiltzaileakService.findById(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
