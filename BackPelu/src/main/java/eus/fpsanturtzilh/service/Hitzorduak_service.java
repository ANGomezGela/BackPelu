package eus.fpsanturtzilh.service;

import eus.fpsanturtzilh.entity.Hitzorduak;
import eus.fpsanturtzilh.repository.Hitzorduak_repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Hitzorduak_service {

    private final Hitzorduak_repository repository;

    public Hitzorduak_service(Hitzorduak_repository repository) {
        this.repository = repository;
    }

    public List<Hitzorduak> getAllHitzorduak() {
        return repository.findAll();
    }

    public Hitzorduak addHitzordua(Hitzorduak hitzordua) {
        return repository.save(hitzordua);
    }
    public Hitzorduak getHitzorduakById(Integer id) {
        return repository.findById(id).orElse(null);
    }
    
    
}
