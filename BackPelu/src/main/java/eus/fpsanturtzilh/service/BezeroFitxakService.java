package eus.fpsanturtzilh.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Bezero_fitxak;
import eus.fpsanturtzilh.repository.BezeroFitxakRepository;

@Service
public class BezeroFitxakService {
    @Autowired
    private BezeroFitxakRepository bezeroFitxakRepository;

    
    // Obtener todos los clientes
    public ArrayList<Bezero_fitxak> getBezeroak(){
        return (ArrayList<Bezero_fitxak>) bezeroFitxakRepository.findAll();
    }
    
    // Guardar un cliente
    public Bezero_fitxak saveBezeroa(Bezero_fitxak bezeroa) {
        bezeroa.setSortzeData(LocalDateTime.now());
        return bezeroFitxakRepository.save(bezeroa);
    }
    
    
    // Buscar cliente por ID
    public Optional<Bezero_fitxak> getById(Long id){
        return bezeroFitxakRepository.findById(id);
    }
    
    // Actualizar cliente por ID
    public Bezero_fitxak updateById(Bezero_fitxak request, Long id) {
        Bezero_fitxak bezeroa = bezeroFitxakRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Bezeroa no encontrado con ID: " + id));
        
        bezeroa.setIzena(request.getIzena());
        bezeroa.setAbizena(request.getAbizena());
        bezeroa.setTelefonoa(request.getTelefonoa());
        bezeroa.setAzalSentikorra(request.getAzalSentikorra());
        bezeroa.setEguneratzeData(LocalDateTime.now());
        
        return bezeroFitxakRepository.save(bezeroa);
    }
    
    public boolean softDeleteBezeroa(Long id) {
        Optional<Bezero_fitxak> bezeroaOptional = bezeroFitxakRepository.findById(id);
        if (bezeroaOptional.isPresent()) {
            Bezero_fitxak bezeroa = bezeroaOptional.get();
            bezeroa.setEzabatzeData(LocalDate.now()); // Establece la fecha de eliminación
            bezeroFitxakRepository.save(bezeroa); // Guarda los cambios en la BD
            return true;
        }
        return false;
    }
    
}
