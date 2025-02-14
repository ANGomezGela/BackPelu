package eus.fpsanturtzilh.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eus.fpsanturtzilh.entity.Produktu_mugimenduak;
import eus.fpsanturtzilh.service.Produktu_mugimenduak_service;

@RestController
@RequestMapping("/produktu_mugimenduak")
public class Produktu_mugimenduak_controller {
	
	@Autowired
	private Produktu_mugimenduak_service produktuak_Mugimendua_service;
	
	@GetMapping
	public ArrayList<Produktu_mugimenduak> getProduk() {
		return this.produktuak_Mugimendua_service.getProduktu_mugimenduak();
	}
	
	@PostMapping
	public Produktu_mugimenduak saveUniversity(@RequestBody Produktu_mugimenduak produ) {
		return this.produktuak_Mugimendua_service.saveProduktu_mugimenduak(produ);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Produktu_mugimenduak> getProduktuId(@PathVariable Long id) {
		return this.produktuak_Mugimendua_service.getById(id);
	}
	@PutMapping(path = "/{id}")
	public Produktu_mugimenduak updateProduktuById(@RequestBody Produktu_mugimenduak request, Long id) {
		return this.produktuak_Mugimendua_service.updateById(request, id);
	}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> softDeleteProduktuMugimenduak(@PathVariable Long id) {
        boolean deleted = produktuak_Mugimendua_service.softDeleteProduktuMugimenduak(id);
        if (deleted) {
            return ResponseEntity.ok("Produktu mugimendua with id: " + id + " marked as deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produktu mugimendua not found.");
        }
    }

}
