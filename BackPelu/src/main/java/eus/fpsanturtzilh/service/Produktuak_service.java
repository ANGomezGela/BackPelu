package eus.fpsanturtzilh.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Produktuak;
import eus.fpsanturtzilh.repository.Produktuak_repository;

@Service
public class Produktuak_service {
	@Autowired
	Produktuak_repository produktuak_repository;
	
	//Gett
	public ArrayList<Produktuak> getProduktuak(){
		return (ArrayList<Produktuak>) produktuak_repository.findAll();
	}
	public Produktuak saveProduktu(Produktuak produ) {
	    produ.setSortzeData(LocalDateTime.now()); // Establecer la fecha de creación
	    return produktuak_repository.save(produ);
	}

	//Find por Id
	public Optional<Produktuak>getById(Long id){
		return produktuak_repository.findById(id);
	}
	
	public Produktuak patchById(Produktuak request, Long id) {
	    Optional<Produktuak> optionalProduktu = produktuak_repository.findById(id);

	    if (optionalProduktu.isPresent()) {
	        Produktuak existingProduktu = optionalProduktu.get();

	        // Solo actualiza los campos que no sean nulos en la petición
	        if (request.getIzena() != null) {
	            existingProduktu.setIzena(request.getIzena());
	        }
	        if (request.getDeskribapena() != null) {

	        }
	        if (request.getKategoriak() != null) {
	            existingProduktu.setKategoriak(request.getKategoriak());
	        }
	        if (request.getMarka() != null) {
	            existingProduktu.setMarka(request.getMarka());
	        }
	        if (request.getStock() != null) {
	            existingProduktu.setStock(request.getStock());
	        }

	        return produktuak_repository.save(existingProduktu);
	    } else {
	        throw new RuntimeException("Producto no encontrado con ID: " + id);
	    }
	}

	
	public Produktuak updateById(Produktuak request, Long id) {
	    Produktuak produ = produktuak_repository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));

	    if (request.getIzena() != null) produ.setIzena(request.getIzena());
	    if (request.getDeskribapena() != null) produ.setDeskribapena(request.getDeskribapena());
	    if (request.getKategoriak() != null) produ.setKategoriak(request.getKategoriak());
	    if (request.getMarka() != null) produ.setMarka(request.getMarka());
	    if (request.getStock() != null) produ.setStock(request.getStock());
	    if (request.getStockAlerta() != null) produ.setStockAlerta(request.getStockAlerta());

	    produ.setEguneratzeData(LocalDateTime.now());  

	    return produktuak_repository.save(produ);
	}

	//Borrar
	public Boolean deleteProduktu (Long id) {
		try {
			produktuak_repository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
    
	
}
