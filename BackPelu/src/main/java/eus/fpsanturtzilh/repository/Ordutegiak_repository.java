package eus.fpsanturtzilh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.entity.Ordutegiak;

/**
 * {@link Ordutegiak_repository} interfazak {@link Ordutegiak} entitatearekin
 * lotutako datuak kudeatzeko funtzionalitatea eskaintzen du.
 * 
 * <p>Spring Data JPA-ren {@link JpaRepository} erabiltzen da, hau da, 
 * datu-baseko eragiketak (sartu, eguneratu, ezabatu, bilatu) egiteko funtzionalitatea
 * eskaintzen duen interfazea. Honek, {@link Ordutegiak} entitatearekin lotutako
 * operazioak modu automatikoan burutzen ditu.</p>
 * 
 * <p>Interfazearen galdera berezia:</p>
 * <ul>
 *   <li><strong>findByEzabatzeDataIsNull</strong>: Datu-basean ezabatutako ordutegiak ez duen
 *       (aktiboak diren) ordutegien zerrenda lortzen du.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Repository
public interface Ordutegiak_repository extends JpaRepository<Ordutegiak, Long> {

    /**
     * Ezabatze data null duten ordutegiak (aktiboak) lortzen dituen galdera.
     *
     * @return {@link List} Aktiboak diren ordutegiak.
     */
    List<Ordutegiak> findByEzabatzeDataIsNull();
}
