package eus.fpsanturtzilh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.entity.Produktu_mugimenduak;

/**
 * {@link Produktu_mugimenduak_repository} interfazak {@link Produktu_mugimenduak} entitatearekin
 * lotutako datuak kudeatzeko funtzionalitatea eskaintzen du.
 * 
 * <p>Spring Data JPA-ren {@link JpaRepository} erabiltzen da, hau da, 
 * datu-baseko eragiketak (sartu, eguneratu, ezabatu, bilatu) egiteko funtzionalitatea
 * eskaintzen duen interfazea. Honek, {@link Produktu_mugimenduak} entitatearekin lotutako
 * operazioak modu automatikoan burutzen ditu.</p>
 * 
 * <p>Interfazearen galdera berezia:</p>
 * <ul>
 *   <li><strong>findByEzabatzeDataIsNull</strong>: Datu-basean ezabatutako produktu mugimenduak ez duen
 *       (aktiboak diren) produktuen mugimendu zerrenda lortzen du.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Repository
public interface Produktu_mugimenduak_repository extends JpaRepository<Produktu_mugimenduak, Long> {

    /**
     * Ezabatze data null duten produktuen mugimenduak (aktiboak) lortzen dituen galdera.
     *
     * @return {@link List} Aktiboak diren produktuen mugimenduak.
     */
    List<Produktu_mugimenduak> findByEzabatzeDataIsNull();
}
