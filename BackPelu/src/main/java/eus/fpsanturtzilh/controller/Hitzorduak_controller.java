package eus.fpsanturtzilh.controller;

import eus.fpsanturtzilh.entity.Hitzorduak;
import eus.fpsanturtzilh.service.Hitzorduak_service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<Hitzorduak> getAll() {
        return service.getAllHitzorduak();
    }

    @PostMapping
    public ResponseEntity<Hitzorduak> create(@RequestBody Hitzorduak hitzordua) {
        if (hitzordua.getAmaieraOrdua() == null) {
            System.out.println("La hora de fin es nula, se asignará un valor predeterminado.");
            hitzordua.setAmaieraOrdua(null);  
        }
        Hitzorduak newHitzordua = service.addHitzordua(hitzordua);
        return ResponseEntity.ok(newHitzordua);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Hitzorduak> update(@PathVariable Integer id, @RequestBody Hitzorduak updatedHitzordua) {
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
    public ResponseEntity<Hitzorduak> actualizarHoraReal(@PathVariable Integer id, @RequestBody Hitzorduak updatedHitzordua) {
        Hitzorduak existingHitzordua = service.getHitzorduakById(id);

        if (existingHitzordua == null) {
            return ResponseEntity.notFound().build();
        }

        existingHitzordua.setHasieraOrduaErreala(updatedHitzordua.getHasieraOrduaErreala());
        service.addHitzordua(existingHitzordua);
        
        return ResponseEntity.ok(existingHitzordua);
    }
    
    @PatchMapping("/{id}/actualizar-hora-final")
    public ResponseEntity<Hitzorduak> actualizarHoraFinal(@PathVariable Integer id, @RequestBody Map<String, String> payload) {
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
