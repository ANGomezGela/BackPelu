package eus.fpsanturtzilh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.entity.Langileak;

/**
 * {@link LangileakRepository} interfazak {@link Langileak} entitatearekin
 * lotutako datuak kudeatzeko funtzionalitatea eskaintzen du.
 * 
 * <p>Spring Data JPA-ren {@link JpaRepository} erabiltzen da, hau da, 
 * datu-baseko eragiketak (sartu, eguneratu, ezabatu, bilatu) egiteko funtzionalitatea
 * eskaintzen duen interfazea. Honek, {@link Langileak} entitatearekin lotutako
 * operazioak modu automatikoan burutzen ditu.</p>
 * 
 * <p>Interfazearen galdera berezia:</p>
 * <ul>
 *   <li><strong>findByEzabatzeDataIsNull</strong>: Datu-basean ezabatutako
 *       langileak ez duen (aktiboak diren) langileen zerrenda lortzen du.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Repository
public interface LangileakRepository extends JpaRepository<Langileak, Long> {

    /**
     * Ezabatze data null duten langileak (aktiboak) lortzen dituen galdera.
     *
     * @return {@link List} Aktiboak diren langileak.
     */
    List<Langileak> findByEzabatzeDataIsNull();
}
