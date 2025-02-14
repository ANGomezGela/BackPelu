package eus.fpsanturtzilh.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Produktu_mugimenduak;
import eus.fpsanturtzilh.repository.Produktu_mugimenduak_repository;

@Service
public class Produktu_mugimenduak_service {
	@Autowired
	Produktu_mugimenduak_repository produktu_mugimenduak_repository;

	//Gett
	public ArrayList<Produktu_mugimenduak> getProduktu_mugimenduak(){
		return (ArrayList<Produktu_mugimenduak>) produktu_mugimenduak_repository.findAll();
	}
	
	//Save
	public Produktu_mugimenduak saveProduktu_mugimenduak (Produktu_mugimenduak Produ) {
		return produktu_mugimenduak_repository.save(Produ);
	}
	//Find por Id
	public Optional<Produktu_mugimenduak>getById(Long id){
		return produktu_mugimenduak_repository.findById(id);
	}
	//Update
    public Produktu_mugimenduak updateById(Produktu_mugimenduak request, Long id) {
    	
    	Produktu_mugimenduak produ = produktu_mugimenduak_repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
        
        produ.setProduktua(request.getProduktua());
        produ.setLangilea(request.getLangilea());
        produ.setData(request.getData());
        produ.setKopurua(request.getKopurua());
        produ.setSortzeData(request.getSortzeData());
        produ.setEguneratzeData(LocalDateTime.now());  
        produ.setEzabatzeData(request.getEzabatzeData());
        
        return produktu_mugimenduak_repository.save(produ);
    }
    public boolean softDeleteProduktuMugimenduak(Long id) {
        Optional<Produktu_mugimenduak> optionalProduktuMugimenduak = produktu_mugimenduak_repository.findById(id);
        if (optionalProduktuMugimenduak.isPresent()) {
            Produktu_mugimenduak produktua = optionalProduktuMugimenduak.get();
            produktua.setEzabatzeData(LocalDateTime.now());  // Marca como eliminado
            produktu_mugimenduak_repository.save(produktua);
            return true;
        }
        return false;
    }
    

    
	
}
