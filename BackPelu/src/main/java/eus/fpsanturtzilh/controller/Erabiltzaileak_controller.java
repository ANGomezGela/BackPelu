package eus.fpsanturtzilh.controller;

import eus.fpsanturtzilh.entity.Erabiltzaileak;
import eus.fpsanturtzilh.service.Erabiltzaileak_service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/erabiltzaileak")
@CrossOrigin(origins = "http://localhost:8100")

public class Erabiltzaileak_controller {

    private final Erabiltzaileak_service erabiltzaileakService;

    public Erabiltzaileak_controller(Erabiltzaileak_service erabiltzaileakService) {
        this.erabiltzaileakService = erabiltzaileakService;
    }

    // Obtener todos los usuarios
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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<Erabiltzaileak> user = erabiltzaileakService.findById(loginRequest.getUsername());

        if (user.isPresent()) {
            if (user.get().getPasahitza().equals(loginRequest.getPassword())) {
                String rol = user.get().getRola();

                // Convertir IK → ADMIN y IR → ALUMNO para el frontend
                String rolConvertido = rol.equals("IK") ? "ALUMNO" : "ADMIN";

                return ResponseEntity.ok(Map.of(
                    "message", "Login exitoso",
                    "username", user.get().getUsername(),
                    "role", rolConvertido
                ));
            }
        }

        return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
    }

    @GetMapping("/trabajadores") 
    public ResponseEntity<?> getTrabajadores(@RequestHeader("role") String role) {
        if (!role.equals("ADMIN")) {
            return ResponseEntity.status(403).body("No tienes acceso a esta información");
        }

        return ResponseEntity.ok("Información de trabajadores");
    }


    // Clase interna para manejar las solicitudes de login
    static class LoginRequest {
        private String username;
        private String password;

        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}

