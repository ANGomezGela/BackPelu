package eus.fpsanturtzilh.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.entity.Txandak;
import eus.fpsanturtzilh.service.TxandakService;

@RestController
@RequestMapping("/txandak")
@CrossOrigin(origins = "http://localhost:8100")

public class TxandakController {
    
    @Autowired
    private TxandakService txandakService;

    @GetMapping
    public List<Txandak> getAllTxandak() {
        return txandakService.getTxandak();
    }
    @GetMapping("/fecha/{fecha}")
    public List<Txandak> getTurnosPorFecha(@PathVariable String fecha) {
        LocalDate fechaConsulta = LocalDate.parse(fecha);
        return txandakService.getTurnosDelDia(fechaConsulta);
    }


    @PostMapping
    public Txandak addTxanda(@RequestBody Txandak txanda) {
        return txandakService.saveTxanda(txanda);
    }

    @GetMapping("/{id}")
    public Optional<Txandak> getTxandaById(@PathVariable Long id) {
        return txandakService.getById(id);
    }

    @PutMapping("/{id}")
    public Txandak updateTxanda(@PathVariable Long id, @RequestBody Txandak request) {
        return txandakService.updateById(request, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> softDeleteTxanda(@PathVariable Long id) {
        boolean deleted = txandakService.softDeleteTxanda(id);
        if (deleted) {
            return ResponseEntity.ok("Txanda with id: " + id + " marked as deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Txanda not found.");
        }
    }

}
