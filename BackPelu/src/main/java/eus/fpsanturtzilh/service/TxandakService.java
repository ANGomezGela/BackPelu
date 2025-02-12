package eus.fpsanturtzilh.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Txandak;
import eus.fpsanturtzilh.repository.TxandakRepository;

@Service
public class TxandakService {
    @Autowired
    private TxandakRepository txandakRepository;
    
    // Obtener todos los turnos
    public ArrayList<Txandak> getTxandak(){
        return (ArrayList<Txandak>) txandakRepository.findAll();
    }
    
    // Guardar un turno
    public Txandak saveTxanda(Txandak txanda) {
        txanda.setSortzeData(LocalDateTime.now());
        return txandakRepository.save(txanda);
    }
    
    // Obtener los turnos del día actual
    public List<Txandak> getTurnosDelDia() {
        LocalDate today = LocalDate.now();
        return txandakRepository.findByData(today);
    }
    public List<Txandak> getTurnosDelDia(LocalDate fecha) {
        return txandakRepository.buscarTurnosPorFecha(fecha);
    }

    
    // Buscar turno por ID
    public Optional<Txandak> getById(Long id){
        return txandakRepository.findById(id);
    }
    
    // Actualizar turno por ID
    public Txandak updateById(Txandak request, Long id) {
        Txandak txanda = txandakRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Txanda no encontrada con ID: " + id));
        
        txanda.setMota(request.getMota());
        txanda.setData(request.getData());
        txanda.setLangilea(request.getLangilea());
        txanda.setEguneratzeData(LocalDateTime.now());
        
        return txandakRepository.save(txanda);
    }
    
    // Borrar turno
    public Boolean deleteTxanda(Long id) {
        try {
            txandakRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}