package eus.fpsanturtzilh.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Ordutegiak;
import eus.fpsanturtzilh.repository.Ordutegiak_repository;

@Service
public class Ordutegiak_service {

    @Autowired
    private Ordutegiak_repository ordutegiakRepository;

    // Obtener todos los horarios
    public List<Ordutegiak> getOrdutegiak() {
        return ordutegiakRepository.findAll();
    }

    // Guardar un horario
    public Ordutegiak saveOrdutegiak(Ordutegiak ordutegia) {
        return ordutegiakRepository.save(ordutegia);
    }

    // Obtener horario por ID
    public Optional<Ordutegiak> getById(Long id) {
        return ordutegiakRepository.findById(id);
    }

    // Actualizar un horario por ID
    public Ordutegiak updateById(Ordutegiak request, Long id) {
        Ordutegiak ordutegiak = ordutegiakRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Horario no encontrado con ID: " + id));
        
        ordutegiak.setTaldeak(request.getTaldeak());
        ordutegiak.setEguna(request.getEguna());
        ordutegiak.setHasieraData(request.getHasieraData());
        ordutegiak.setAmaieraData(request.getAmaieraData());
        ordutegiak.setHasieraOrdua(request.getHasieraOrdua());
        ordutegiak.setAmaieraOrdua(request.getAmaieraOrdua());
        ordutegiak.setEguneratzeData(LocalDateTime.now());
        
        return ordutegiakRepository.save(ordutegiak);
    }
	//Borrar
	public Boolean deleteOrdutegiak (Long id) {
		try {
			ordutegiakRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
    
}
