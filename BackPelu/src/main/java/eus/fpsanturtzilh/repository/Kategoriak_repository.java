package eus.fpsanturtzilh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.entity.Kategoriak;

/**
 * {@link Kategoriak_repository} interfazak {@link Kategoriak} entitatearekin
 * lotutako datuak kudeatzeko funtzionalitatea eskaintzen du.
 * 
 * <p>Spring Data JPA-ren {@link JpaRepository} erabiltzen da, hau da, 
 * datu-baseko eragiketak (sartu, eguneratu, ezabatu, bilatu) egiteko funtzionalitatea
 * eskaintzen duen interfazea. Honek, {@link Kategoriak} entitatearekin lotutako
 * operazioak modu automatikoan burutzen ditu.</p>
 * 
 * <p>Interfazearen galdera berezia:</p>
 * <ul>
 *   <li><strong>findByEzabatzeDataIsNull</strong>: Datu-basean ezabatutako
 *       kategoriarik ez duen (aktiboak diren) kategorien zerrenda lortzen du.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Repository
public interface Kategoriak_repository extends JpaRepository<Kategoriak, Long>{

    /**
     * Ezabatze data null duten kategoriak (aktiboak) lortzen dituen galdera.
     *
     * @return {@link List} Aktiboak diren kategoriak.
     */
    List<Kategoriak> findByEzabatzeDataIsNull();  // Solo registros activos (no eliminados)
}
