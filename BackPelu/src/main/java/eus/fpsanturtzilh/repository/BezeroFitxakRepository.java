package eus.fpsanturtzilh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import eus.fpsanturtzilh.entity.Bezero_fitxak;

/**
 * {@link BezeroFitxakRepository} interfazak {@link Bezero_fitxak} entitatearekin
 * lotutako datuak kudeatzeko funtzionalitatea eskaintzen du.
 * 
 * <p>Spring Data JPA-ren {@link JpaRepository} erabiltzen da, hau da, 
 * datu-baseko eragiketak (sartu, eguneratu, ezabatu, bilatu) egiteko funtzionalitatea
 * eskaintzen duen interfazea.</p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Repository
public interface BezeroFitxakRepository extends JpaRepository<Bezero_fitxak, Long> {
    // Inplementazio berezirik ez da behar, JpaRepository-k automatikoki eskaintzen du funtzionalitatea.
}
