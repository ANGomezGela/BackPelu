package eus.fpsanturtzilh.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Materialak;
import eus.fpsanturtzilh.entity.Produktuak;
import eus.fpsanturtzilh.repository.MaterialakRepository;

@Service
public class MaterialakService {
    @Autowired
    private MaterialakRepository materialakRepository;
    
    // Obtener todos los materiales
    public ArrayList<Materialak> getMaterialak(){
        return (ArrayList<Materialak>) materialakRepository.findAll();
    }
    
    // Guardar un material
    public Materialak saveMateriala(Materialak materiala) {
        materiala.setSortzeData(LocalDateTime.now());
        return materialakRepository.save(materiala);
    }
    
    // Buscar material por ID
    public Optional<Materialak> getById(Long id){
        return materialakRepository.findById(id);
    }
    
    public Materialak patchById(Materialak request, Long id) {
        Optional<Materialak> optionalMaterial = materialakRepository.findById(id);

        if (optionalMaterial.isPresent()) {
            Materialak existingMaterial = optionalMaterial.get();

            // Solo actualiza los campos que no sean nulos en la petición
            if (request.getEtiketa() != null) {
                existingMaterial.setEtiketa(request.getEtiketa());
            }
            if (request.getIzena() != null) {
                existingMaterial.setIzena(request.getIzena());
            }
            if (request.getKategoriak() != null) {
                existingMaterial.setKategoriak(request.getKategoriak());
            }

            existingMaterial.setEguneratzeData(LocalDateTime.now());

            return materialakRepository.save(existingMaterial);
        } else {
            throw new RuntimeException("Material no encontrado con ID: " + id);
        }
    }

    
    // Actualizar material por ID
    public Materialak updateById(Materialak request, Long id) {
        Materialak materiala = materialakRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Materiala no encontrado con ID: " + id));
        
        materiala.setEtiketa(request.getEtiketa());
        materiala.setIzena(request.getIzena());
        materiala.setKategoriak(request.getKategoriak());
        materiala.setEguneratzeData(LocalDateTime.now());
        
        return materialakRepository.save(materiala);
    }
    
    public boolean softDeleteMateriala(Long id) {
        Optional<Materialak> optionalMateriala = materialakRepository.findById(id);
        if (optionalMateriala.isPresent()) {
            Materialak materiala = optionalMateriala.get();
            materiala.setEzabatzeData(LocalDateTime.now());  // Marca como eliminado
            materialakRepository.save(materiala);
            return true;
        }
        return false;
    }
    

}
