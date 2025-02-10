package eus.fpsanturtzilh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eus.fpsanturtzilh.entity.Kategoriak;
import eus.fpsanturtzilh.service.Kategoriak_service;

@RestController
@RequestMapping("/kategoriak")
@CrossOrigin(origins = "http://localhost:8100")

public class Kategoriak_controller {
	
	
	@Autowired
    private Kategoriak_service kategoriak_service;
    
    @GetMapping
    public List<Kategoriak> getAllKategoriak() {
        return kategoriak_service.getKategoriak();
    }
    
    @PostMapping
    public Kategoriak addKategoriak(@RequestBody Kategoriak kategoriak) {
        return kategoriak_service.saveKategoria(kategoriak);
    }
    
    @GetMapping("/{id}")
    public Optional<Kategoriak> getKategoriatuById(@PathVariable Long id) {
        return kategoriak_service.getById(id);
    }
    @PutMapping("/{id}")
    public Kategoriak updateKategoria(@PathVariable Long id, @RequestBody Kategoriak request) {
        return kategoriak_service.updateById(request, id);
    }
    @DeleteMapping("/{id}")
    public String deleteProduktu(@PathVariable Long id) {
        boolean ok = kategoriak_service.deleteKategoria(id);
        return ok ? "Product with id: " + id + " Deleted" : "Error";
    }

    


}
