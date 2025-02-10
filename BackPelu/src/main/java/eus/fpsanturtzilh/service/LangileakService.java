package eus.fpsanturtzilh.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Langileak;
import eus.fpsanturtzilh.repository.LangileakRepository;

@Service
public class LangileakService {
    @Autowired
    private LangileakRepository langileakRepository;
    
    // Obtener todos los empleados
    public ArrayList<Langileak> getLangileak(){
        return (ArrayList<Langileak>) langileakRepository.findAll();
    }
    
    // Guardar un empleado
    public Langileak saveLangilea(Langileak langilea) {
        langilea.setSortzeData(LocalDateTime.now());
        return langileakRepository.save(langilea);
    }
    
    // Buscar empleado por ID
    public Optional<Langileak> getById(Long id){
        return langileakRepository.findById(id);
    }
    
    // Actualizar empleado por ID
    public Langileak updateById(Langileak request, Long id) {
        Langileak langilea = langileakRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Langilea no encontrado con ID: " + id));
        
        langilea.setIzena(request.getIzena());
        langilea.setAbizenak(request.getAbizenak());
        langilea.setTaldeak(request.getTaldeak());
        langilea.setEguneratzeData(LocalDateTime.now());
        
        return langileakRepository.save(langilea);
    }
    
    // Borrar empleado
    public Boolean deleteLangilea(Long id) {
        try {
            langileakRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
