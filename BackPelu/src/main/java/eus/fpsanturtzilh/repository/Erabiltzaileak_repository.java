package eus.fpsanturtzilh.repository;

import eus.fpsanturtzilh.entity.Erabiltzaileak;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {@link Erabiltzaileak_repository} interfazak {@link Erabiltzaileak} entitatearekin
 * lotutako datuak kudeatzeko funtzionalitatea eskaintzen du.
 * 
 * <p>Spring Data JPA-ren {@link JpaRepository} erabiltzen da, hau da, 
 * datu-baseko eragiketak (sartu, eguneratu, ezabatu, bilatu) egiteko funtzionalitatea
 * eskaintzen duen interfazea. Honek, {@link Erabiltzaileak} entitatearekin lotutako
 * operazioak modu automatikoan burutzen ditu.</p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
public interface Erabiltzaileak_repository extends JpaRepository<Erabiltzaileak, String> {
    // Inplementazio berezirik ez da behar, JpaRepository-k automatikoki eskaintzen du funtzionalitatea.
}
