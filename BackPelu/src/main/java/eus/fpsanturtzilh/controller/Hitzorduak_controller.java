package eus.fpsanturtzilh.controller;

import eus.fpsanturtzilh.entity.Hitzorduak;
import eus.fpsanturtzilh.service.Hitzorduak_service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/hitzorduak")
@CrossOrigin(origins = "*")
public class Hitzorduak_controller {

    private final Hitzorduak_service service;

    public Hitzorduak_controller(Hitzorduak_service service) {
        this.service = service;
    }
    

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<Hitzorduak>> getByFecha(@PathVariable String fecha) {
        LocalDate parsedFecha = LocalDate.parse(fecha);
        return ResponseEntity.ok(service.getHitzorduakByFecha(parsedFecha));
    }

    @GetMapping("/count-by-fecha")
    public ResponseEntity<List<Map<String, Object>>> getCountByFecha() {
        return ResponseEntity.ok(service.getCountByFecha());
    }

    @GetMapping
    public ResponseEntity<List<Hitzorduak>> getAll() {
        return ResponseEntity.ok(service.getAllHitzorduak());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Hitzorduak hitzordua) {
        if (hitzordua.getIzena() == null || hitzordua.getIzena().isEmpty()) {
            return ResponseEntity.badRequest().body("El campo 'izena' es obligatorio.");
        }
        if (hitzordua.getData() == null) {
            return ResponseEntity.badRequest().body("El campo 'data' es obligatorio.");
        }
        if (hitzordua.getHasieraOrdua() == null) {
            return ResponseEntity.badRequest().body("El campo 'hasieraOrdua' es obligatorio.");
        }

        // Configurar valores por defecto si están en null
        hitzordua.setAmaieraOrdua(hitzordua.getAmaieraOrdua() != null ? hitzordua.getAmaieraOrdua() : null);
        hitzordua.setEserlekua(hitzordua.getEserlekua() != null ? hitzordua.getEserlekua() : 0);
        hitzordua.setPrezioTotala(hitzordua.getPrezioTotala() != null ? hitzordua.getPrezioTotala() : BigDecimal.ZERO);

        Hitzorduak newHitzordua = service.addHitzordua(hitzordua);
        return ResponseEntity.ok(newHitzordua);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Hitzorduak updatedHitzordua) {
        Hitzorduak existingHitzordua = service.getHitzorduakById(id);

        if (existingHitzordua == null) {
            return ResponseEntity.notFound().build();
        }

        existingHitzordua.setEserlekua(updatedHitzordua.getEserlekua());
        existingHitzordua.setData(updatedHitzordua.getData());
        existingHitzordua.setHasieraOrdua(updatedHitzordua.getHasieraOrdua());
        existingHitzordua.setAmaieraOrdua(updatedHitzordua.getAmaieraOrdua());
        existingHitzordua.setIzena(updatedHitzordua.getIzena());
        existingHitzordua.setTelefonoa(updatedHitzordua.getTelefonoa());
        existingHitzordua.setDeskribapena(updatedHitzordua.getDeskribapena());
        existingHitzordua.setEtxekoa(updatedHitzordua.getEtxekoa());

        service.addHitzordua(existingHitzordua);
        return ResponseEntity.ok(existingHitzordua);
    }

    @PatchMapping("/{id}/actualizar-hora-real")
    public ResponseEntity<?> actualizarHoraReal(@PathVariable Long id, @RequestBody Map<String, String> payload) {
        Hitzorduak existingHitzordua = service.getHitzorduakById(id);

        if (existingHitzordua == null) {
            return ResponseEntity.notFound().build();
        }

        String horaRealStr = payload.get("hasieraOrduaErreala");
        if (horaRealStr != null) {
            existingHitzordua.setHasieraOrduaErreala(LocalTime.parse(horaRealStr));
            service.addHitzordua(existingHitzordua);
        }

        return ResponseEntity.ok(existingHitzordua);
    }

    @PatchMapping("/{id}/actualizar-hora-final")
    public ResponseEntity<?> actualizarHoraFinal(@PathVariable Long id, @RequestBody Map<String, String> payload) {
        Hitzorduak existingHitzordua = service.getHitzorduakById(id);

        if (existingHitzordua == null) {
            return ResponseEntity.notFound().build();
        }

        String horaFinalStr = payload.get("amaieraOrduaErreala");
        if (horaFinalStr != null) {
            existingHitzordua.setAmaieraOrduaErreala(LocalTime.parse(horaFinalStr));
            service.addHitzordua(existingHitzordua);
        }

        return ResponseEntity.ok(existingHitzordua);
    }
}
