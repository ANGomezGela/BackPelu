package eus.fpsanturtzilh.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Kategoriak;
import eus.fpsanturtzilh.repository.Kategoriak_repository;

@Service
public class Kategoriak_service {
	@Autowired
	Kategoriak_repository kategoriak_repository;
	//Gett
	public ArrayList<Kategoriak> getKategoriak(){
		return (ArrayList<Kategoriak>) kategoriak_repository.findAll();
	}
	
	//Save
	public Kategoriak saveKategoria (Kategoriak kategoria) {
		return kategoriak_repository.save(kategoria);
	}
	
	//Find por Id
	public Optional<Kategoriak>getById(Long id){
		return kategoriak_repository.findById(id);
	}
	
	public Kategoriak updateById(Kategoriak request, Long id) {
	    
	    Kategoriak kategoria = kategoriak_repository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + id));

	    kategoria.setIzena(request.getIzena());
	    
	    // No cambiar `sortzeData`, mantenerla como está
	    // Actualiza `eguneratzeData` automáticamente a la fecha actual
	    kategoria.setEguneratzeData(LocalDateTime.now());

	    // Solo actualizar `ezabatzeData` si viene en la petición
	    if (request.getEzabatzeData() != null) {
	        kategoria.setEzabatzeData(request.getEzabatzeData());
	    }

	    return kategoriak_repository.save(kategoria);
	}
	
    public boolean softDeleteKategoria(Long id) {
        Optional<Kategoriak> kategoriaOptional = kategoriak_repository.findById(id);
        if (kategoriaOptional.isPresent()) {
            Kategoriak kategoria = kategoriaOptional.get();
            kategoria.setEzabatzeData(LocalDateTime.now());  // Marcar como eliminada
            kategoriak_repository.save(kategoria);
            return true;
        }
        return false;
    }


}
