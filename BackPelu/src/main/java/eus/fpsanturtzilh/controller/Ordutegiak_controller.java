package eus.fpsanturtzilh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.entity.Ordutegiak;
import eus.fpsanturtzilh.service.Ordutegiak_service;

@RestController
@RequestMapping("/ordutegiak")
@CrossOrigin(origins = "http://localhost:8100")

public class Ordutegiak_controller {
    
    @Autowired
    private Ordutegiak_service ordutegiakService;

    @GetMapping
    public List<Ordutegiak> getAllOrdutegiak() {
        return ordutegiakService.getOrdutegiak();
    }

    @PostMapping
    public Ordutegiak addOrdutegia(@RequestBody Ordutegiak ordutegia) {
        return ordutegiakService.saveOrdutegiak(ordutegia);
    }

    @GetMapping("/{id}")
    public Optional<Ordutegiak> getOrdutegiaById(@PathVariable Long id) {
        return ordutegiakService.getById(id);
    }

    @PutMapping("/{id}")
    public Ordutegiak updateOrdutegia(@PathVariable Long id, @RequestBody Ordutegiak request) {
        return ordutegiakService.updateById(request, id);
    }
}
