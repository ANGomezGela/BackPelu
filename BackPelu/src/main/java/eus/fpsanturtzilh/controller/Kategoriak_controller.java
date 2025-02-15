package eus.fpsanturtzilh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.entity.Kategoriak;
import eus.fpsanturtzilh.service.Kategoriak_service;

/**
 * Kategoriak_controller klasea.
 * <p>
 * API honen bidez kategoriak kudeatzen dira: eskuratzea, gehitzea,
 * eguneratzea eta ezabatzea.
 * </p>
 */
@RestController
@RequestMapping("/kategoriak")
@CrossOrigin(origins = "http://localhost:8100")
public class Kategoriak_controller {
    
    /**
     * Kategoriak_service objektua injektatzen da kategoriak kudeatzeko.
     */
    @Autowired
    private Kategoriak_service kategoriak_service;
    
    /**
     * Kategoria guztiak eskuratzen ditu.
     * @return kategoriak zerrenda moduan.
     */
    @GetMapping
    public List<Kategoriak> getAllKategoriak() {
        return kategoriak_service.getKategoriak();
    }
    
    /**
     * Kategoria berri bat gehitzen du.
     * @param kategoriak gehitu beharreko kategoria.
     * @return gehitutako kategoria.
     */
    @PostMapping
    public Kategoriak addKategoriak(@RequestBody Kategoriak kategoriak) {
        return kategoriak_service.saveKategoria(kategoriak);
    }
    
    /**
     * Kategoria bat bilatzen du bere IDaren arabera.
     * @param id kategoriaren identifikadorea.
     * @return aurkitutako kategoria (Optional moduan).
     */
    @GetMapping("/{id}")
    public Optional<Kategoriak> getKategoriatuById(@PathVariable Long id) {
        return kategoriak_service.getById(id);
    }
    
    /**
     * Kategoria bat eguneratzen du.
     * @param id eguneratu beharreko kategoriaren identifikadorea.
     * @param request kategoriaren informazio eguneratua.
     * @return eguneratutako kategoria.
     */
    @PutMapping("/{id}")
    public Kategoriak updateKategoria(@PathVariable Long id, @RequestBody Kategoriak request) {
        return kategoriak_service.updateById(request, id);
    }

    /**
     * Kategoria bat "soft delete" egiten du (ezabatu bezala markatu baina ez fisikoki ezabatu).
     * @param id ezabatu beharreko kategoriaren identifikadorea.
     * @return ResponseEntity objektua, operazioaren emaitza adierazten duena.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> softDeleteKategoria(@PathVariable Long id) {
        boolean deleted = kategoriak_service.softDeleteKategoria(id);
        if (deleted) {
            return ResponseEntity.ok("Kategoria ID: " + id + " ezabatutzat markatu da.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kategoria ez da aurkitu.");
        }
    }
}
