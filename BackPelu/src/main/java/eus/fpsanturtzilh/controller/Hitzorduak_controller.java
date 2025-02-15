package eus.fpsanturtzilh.controller;

import eus.fpsanturtzilh.entity.Hitzorduak;
import eus.fpsanturtzilh.service.Hitzorduak_service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

/**
 * Hitzorduak kontrolatzeko REST APIko kontrolatzailea.
 * Hitzorduak sortzeko, eguneratzeko, ezabatzeko eta kontsultatzeko metodoak eskaintzen ditu.
 */
@RestController
@RequestMapping("/api/hitzorduak")
@CrossOrigin(origins = "*")
public class Hitzorduak_controller {

    private final Hitzorduak_service service;

    /**
     * Hitzorduak kontrolatzailearen eraikitzailea.
     * @param service Hitzorduak_service instantzia.
     */
    public Hitzorduak_controller(Hitzorduak_service service) {
        this.service = service;
    }

    /**
     * Emandako datako hitzorduak lortzen ditu.
     * @param fecha Data (String moduan).
     * @return Emandako datako hitzorduen zerrenda.
     */
    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<Hitzorduak>> getByFecha(@PathVariable String fecha) {
        LocalDate parsedFecha = LocalDate.parse(fecha);
        return ResponseEntity.ok(service.getHitzorduakByFecha(parsedFecha));
    }

    /**
     * Hitzordu kopurua dataren arabera lortzen du.
     * @return Data bakoitzeko hitzordu kopurua duen zerrenda.
     */
    @GetMapping("/count-by-fecha")
    public ResponseEntity<List<Map<String, Object>>> getCountByFecha() {
        return ResponseEntity.ok(service.getCountByFecha());
    }

    /**
     * Hitzordu guztien zerrenda lortzen du.
     * @return Hitzorduen zerrenda.
     */
    @GetMapping
    public ResponseEntity<List<Hitzorduak>> getAll() {
        return ResponseEntity.ok(service.getAllHitzorduak());
    }

    /**
     * Hitzordu bat ezabatzen du "soft delete" bidez.
     * @param id Ezabatu beharreko hitzorduaren IDa.
     * @return Mezua, ezabaketa arrakastatsua izan den edo ez jakinaraziz.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> softDeleteHitzordua(@PathVariable Long id) {
        boolean deleted = service.softDeleteHitzordua(id);
        if (deleted) {
            return ResponseEntity.ok("Hitzordua ID: " + id + " ezabatuta izan da.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hitzordua ez da aurkitu.");
        }
    }

    /**
     * Gaurko hitzorduak lortzen ditu.
     * @return Gaurko hitzorduak zerrenda moduan.
     */
    @GetMapping("/hoy")
    public ResponseEntity<List<Hitzorduak>> getHitzorduakHoy() {
        LocalDate hoy = LocalDate.now();
        List<Hitzorduak> hitzorduakHoy = service.getHitzorduakByFechaHoy(hoy);
        if (hitzorduakHoy.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(hitzorduakHoy);
    }

    /**
     * Hitzordu berria sortzen du.
     * @param hitzordua Sortu beharreko hitzordua.
     * @return Sortutako hitzordua edo errore mezua.
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Hitzorduak hitzordua) {
        if (hitzordua.getIzena() == null || hitzordua.getIzena().isEmpty()) {
            return ResponseEntity.badRequest().body("'izena' eremua derrigorrezkoa da.");
        }
        if (hitzordua.getData() == null) {
            return ResponseEntity.badRequest().body("'data' eremua derrigorrezkoa da.");
        }
        if (hitzordua.getHasieraOrdua() == null) {
            return ResponseEntity.badRequest().body("'hasieraOrdua' eremua derrigorrezkoa da.");
        }
        
        hitzordua.setAmaieraOrdua(hitzordua.getAmaieraOrdua() != null ? hitzordua.getAmaieraOrdua() : null);
        hitzordua.setEserlekua(hitzordua.getEserlekua() != null ? hitzordua.getEserlekua() : 0);
        hitzordua.setPrezioTotala(hitzordua.getPrezioTotala() != null ? hitzordua.getPrezioTotala() : BigDecimal.ZERO);
        
        Hitzorduak newHitzordua = service.addHitzordua(hitzordua);
        return ResponseEntity.ok(newHitzordua);
    }

    /**
     * Hitzordua eguneratzen du.
     * @param id Hitzorduaren IDa.
     * @param updatedHitzordua Eguneratutako hitzordua.
     * @return Eguneratutako hitzordua edo errore mezua.
     */
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
}
