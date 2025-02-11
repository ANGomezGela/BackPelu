package eus.fpsanturtzilh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.entity.Bezero_fitxak;
import eus.fpsanturtzilh.service.BezeroFitxakService;

@RestController
@RequestMapping("/bezeroak")
@CrossOrigin(origins = "http://localhost:8100")
public class BezeroFitxakController {
    
    @Autowired
    private BezeroFitxakService bezeroFitxakService;


    @GetMapping
    public List<Bezero_fitxak> getAllBezeroak() {
        return bezeroFitxakService.getBezeroak();
    }

    @PostMapping
    public Bezero_fitxak addBezeroa(@RequestBody Bezero_fitxak bezeroa) {
        return bezeroFitxakService.saveBezeroa(bezeroa);
    }

    @GetMapping("/{id}")
    public Optional<Bezero_fitxak> getBezeroaById(@PathVariable Long id) {
        return bezeroFitxakService.getById(id);
    }



    @PutMapping("/{id}")
    public Bezero_fitxak updateBezeroa(@PathVariable Long id, @RequestBody Bezero_fitxak request) {
        return bezeroFitxakService.updateById(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteBezeroa(@PathVariable Long id) {
        boolean ok = bezeroFitxakService.deleteBezeroa(id);
        return ok ? "Bezeroa with id: " + id + " Deleted" : "Error";
    }
}
