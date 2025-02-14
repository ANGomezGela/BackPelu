package eus.fpsanturtzilh.service;

import java.util.stream.Collectors;
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
    
    public boolean softDeleteHitzordua(Long id) {
        Hitzorduak hitzordua = getHitzorduakById(id);
        if (hitzordua != null) {
            hitzordua.setEzabatzeData(LocalDate.now());  // Marcar con la fecha de eliminación
            repository.save(hitzordua);
            return true;
        }
        return false;
    }
    
    public List<Hitzorduak> getHitzorduakByFechaHoy(LocalDate fecha) {
        return getAllHitzorduak()
                .stream()
                .filter(h -> h.getData().equals(fecha))
                .collect(Collectors.toList());
    }
}
