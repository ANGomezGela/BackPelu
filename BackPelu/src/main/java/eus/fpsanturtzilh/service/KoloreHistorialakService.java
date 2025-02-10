package eus.fpsanturtzilh.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Kolore_historialak;
import eus.fpsanturtzilh.repository.KoloreHistorialakRepository;

@Service
public class KoloreHistorialakService {
    @Autowired
    private KoloreHistorialakRepository koloreHistorialakRepository;
    
    // Obtener todo el historial de colores
    public ArrayList<Kolore_historialak> getKoloreHistorialak(){
        return (ArrayList<Kolore_historialak>) koloreHistorialakRepository.findAll();
    }
    
    // Guardar un nuevo historial de color
    public Kolore_historialak saveKoloreHistoriala(Kolore_historialak koloreHistoriala) {
        koloreHistoriala.setSortzeData(LocalDateTime.now());
        return koloreHistorialakRepository.save(koloreHistoriala);
    }
    
    // Buscar historial de color por ID
    public Optional<Kolore_historialak> getById(Long id){
        return koloreHistorialakRepository.findById(id);
    }
    
    // Actualizar historial de color por ID
    public Kolore_historialak updateById(Kolore_historialak request, Long id) {
        Kolore_historialak koloreHistoriala = koloreHistorialakRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Historial de color no encontrado con ID: " + id));
        
        koloreHistoriala.setBezeroa(request.getBezeroa());
        koloreHistoriala.setProduktua(request.getProduktua());
        koloreHistoriala.setData(request.getData());
        koloreHistoriala.setKantitatea(request.getKantitatea());
        koloreHistoriala.setBolumena(request.getBolumena());
        koloreHistoriala.setOharrak(request.getOharrak());
        koloreHistoriala.setEguneratzeData(LocalDateTime.now());
        
        return koloreHistorialakRepository.save(koloreHistoriala);
    }
    
    // Borrar historial de color
    public Boolean deleteKoloreHistoriala(Long id) {
        try {
            koloreHistorialakRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
