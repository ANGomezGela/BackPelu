package eus.fpsanturtzilh.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Zerbitzuak;
import eus.fpsanturtzilh.repository.Zerbitzuak_repository;


@Service
public class Zerbitzuak_service {
	@Autowired
	Zerbitzuak_repository zerbitzuak_repository;
	
	
	//Gett
	public ArrayList<Zerbitzuak> getZerbitzuak(){
		return (ArrayList<Zerbitzuak>) zerbitzuak_repository.findAll();
	}
	
	//save
	public Zerbitzuak saveZerbitzuak (Zerbitzuak servi) {
		return zerbitzuak_repository.save(servi);
	}
	
	//Find por Id
	public Optional<Zerbitzuak>getById(Long id){
		return zerbitzuak_repository.findById(id);
	}
	public Zerbitzuak patchById(Zerbitzuak request, Long id) {
	    Optional<Zerbitzuak> optionalZerbitzu = zerbitzuak_repository.findById(id);

	    if (optionalZerbitzu.isPresent()) {
	        Zerbitzuak existingZerbitzu = optionalZerbitzu.get();

	        // Solo actualiza los campos que no sean nulos en la petición
	        if (request.getIzena() != null) {
	            existingZerbitzu.setIzena(request.getIzena());
	        }
	        if (request.getKategoriak() != null) {
	            existingZerbitzu.setKategoriak(request.getKategoriak());
	        }
	        if (request.getEtxekoPrezioa() != null) {
	            existingZerbitzu.setEtxekoPrezioa(request.getEtxekoPrezioa());
	        }
	        if (request.getKanpokoPrezioa() != null) {
	            existingZerbitzu.setKanpokoPrezioa(request.getKanpokoPrezioa());
	        }

	        existingZerbitzu.setEguneratzeData(LocalDateTime.now()); // Actualizar fecha de modificación

	        return zerbitzuak_repository.save(existingZerbitzu);
	    } else {
	        throw new RuntimeException("Servicio no encontrado con ID: " + id);
	    }
	}

	
	//Update
	public Zerbitzuak updateById(Zerbitzuak request, Long id){
		Zerbitzuak zerbitzuak = zerbitzuak_repository.findById(id).get();

        // Actualizar campos
        zerbitzuak.setIzena(request.getIzena());
        zerbitzuak.setKategoriak(request.getKategoriak());
        zerbitzuak.setEtxekoPrezioa(request.getEtxekoPrezioa());
        zerbitzuak.setKanpokoPrezioa(request.getKanpokoPrezioa());
        zerbitzuak.setEguneratzeData(LocalDateTime.now()); // Fecha de actualización

        // Guardar en la base de datos
        return zerbitzuak_repository.save(zerbitzuak);
		
			}
	
	//Borrar
	public Boolean deleteZerbitzuak (Long id) {
		try {
			zerbitzuak_repository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	

}
