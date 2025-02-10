package eus.fpsanturtzilh.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Material_maileguak;
import eus.fpsanturtzilh.repository.MaterialMaileguakRepository;

@Service
public class MaterialMaileguakService {
    @Autowired
    private MaterialMaileguakRepository materialMaileguakRepository;
    
    // Obtener todos los préstamos de material
    public ArrayList<Material_maileguak> getMaterialMaileguak(){
        return (ArrayList<Material_maileguak>) materialMaileguakRepository.findAll();
    }
    
    // Guardar un préstamo de material
    public Material_maileguak saveMaterialMailegua(Material_maileguak materialMailegua) {
        materialMailegua.setSortzeData(LocalDateTime.now());
        return materialMaileguakRepository.save(materialMailegua);
    }
    
    // Buscar préstamo de material por ID
    public Optional<Material_maileguak> getById(Long id){
        return materialMaileguakRepository.findById(id);
    }
    
    // Actualizar préstamo de material por ID
    public Material_maileguak updateById(Material_maileguak request, Long id) {
        Material_maileguak materialMailegua = materialMaileguakRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Material mailegua no encontrado con ID: " + id));
        
        materialMailegua.setMaterialak(request.getMaterialak());
        materialMailegua.setLangilea(request.getLangilea());
        materialMailegua.setHasieraData(request.getHasieraData());
        materialMailegua.setAmaieraData(request.getAmaieraData());
        materialMailegua.setEguneratzeData(LocalDateTime.now());
        
        return materialMaileguakRepository.save(materialMailegua);
    }
    
    // Borrar préstamo de material
    public Boolean deleteMaterialMailegua(Long id) {
        try {
            materialMaileguakRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
