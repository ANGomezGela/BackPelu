package eus.fpsanturtzilh.service;

import eus.fpsanturtzilh.entity.Erabiltzaileak;
import eus.fpsanturtzilh.repository.Erabiltzaileak_repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Erabiltzaileak_service {

    private final Erabiltzaileak_repository erabiltzaileakRepository;

    public Erabiltzaileak_service(Erabiltzaileak_repository erabiltzaileakRepository) {
        this.erabiltzaileakRepository = erabiltzaileakRepository;
    }

    // Método para obtener todos los usuarios
    public List<Erabiltzaileak> findAll() {
        return erabiltzaileakRepository.findAll();
    }

    // Método para obtener un usuario por su username
    public Optional<Erabiltzaileak> findById(String username) {
        return erabiltzaileakRepository.findById(username);
    }
}
