package eus.fpsanturtzilh.repository;

import eus.fpsanturtzilh.entity.Taldeak;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * {@link Taldeak_repository} interfazak {@link Taldeak} entitatearekin
 * lotutako datuak kudeatzeko funtzionalitatea eskaintzen du.
 * 
 * <p>Spring Data JPA-ren {@link JpaRepository} erabiltzen da, hau da, 
 * datu-baseko eragiketak (sartu, eguneratu, ezabatu, bilatu) egiteko funtzionalitatea
 * eskaintzen duen interfazea. Honek, {@link Taldeak} entitatearekin lotutako
 * operazioak modu automatikoan burutzen ditu.</p>
 * 
 * <p>Interfazearen galdera berezia:</p>
 * <ul>
 *   <li><strong>findByEzabatzeDataIsNull</strong>: Datu-basean ezabatutako taldeak ez duten
 *       (aktiboak diren) talde guztien zerrenda lortzen du.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Repository
public interface Taldeak_repository extends JpaRepository<Taldeak, String> {

    /**
     * Ezabatze data null duten taldeak (aktiboak) lortzen dituen galdera.
     *
     * @return {@link List} Aktiboak diren taldeak.
     */
    List<Taldeak> findByEzabatzeDataIsNull();
}
