package eus.fpsanturtzilh.controller;

import eus.fpsanturtzilh.service.Erabiltzaileak_service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/erabiltzaileak")
@CrossOrigin(origins = "http://localhost:8100")

public class Erabiltzaileak_controller {

    private final Erabiltzaileak_service erabiltzaileakService;

    public Erabiltzaileak_controller(Erabiltzaileak_service erabiltzaileakService) {
        this.erabiltzaileakService = erabiltzaileakService;
    }

 // Obtener todos los usuarios con los campos necesarios
    @GetMapping
    public List<Map<String, String>> getAll() {
        return erabiltzaileakService.findAll()
                .stream()
                .map(user -> Map.of(
                        "username", user.getUsername(),
                        "pasahitza", user.getPasahitza(),
                        "rola", user.getRola()))
                .toList();
    }
    
}

