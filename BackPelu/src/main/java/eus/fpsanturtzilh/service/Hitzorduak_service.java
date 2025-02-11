package eus.fpsanturtzilh.service;

import eus.fpsanturtzilh.entity.Hitzorduak;
import eus.fpsanturtzilh.repository.Hitzorduak_repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class Hitzorduak_service {

    private final Hitzorduak_repository repository;

    public Hitzorduak_service(Hitzorduak_repository repository) {
        this.repository = repository;
    }

    public List<Hitzorduak> getAllHitzorduak() {
        return repository.findAll();
    }

    public List<Hitzorduak> getHitzorduakByFecha(LocalDate fecha) {
        return repository.findByFecha(fecha);
    }
    

    public List<Map<String, Object>> getCountByFecha() {
        return repository.countByFecha();
    }

    public Hitzorduak addHitzordua(Hitzorduak hitzordua) {
        return repository.save(hitzordua);
    }

    public Hitzorduak getHitzorduakById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
