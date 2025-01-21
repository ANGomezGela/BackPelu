package eus.fpsanturtzilh.service;

import eus.fpsanturtzilh.entity.Taldeak;
import eus.fpsanturtzilh.repository.Taldeak_repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Taldeak_service {

    @Autowired
    private Taldeak_repository taldeakRepository;

    // Obtener todos los grupos
    public List<Taldeak> getAllGroups() {
        return taldeakRepository.findAll();
    }

    // Obtener un grupo por código
    public Optional<Taldeak> getGroupById(String kodea) {
        return taldeakRepository.findById(kodea);
    }

    // Añadir o actualizar un grupo
    public Taldeak saveOrUpdateGroup(Taldeak taldeak) {
        return taldeakRepository.save(taldeak);
    }

    // Eliminar un grupo por código
    public void deleteGroup(String kodea) {
        taldeakRepository.deleteById(kodea);
    }
}
