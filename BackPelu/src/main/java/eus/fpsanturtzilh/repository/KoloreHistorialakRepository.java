package eus.fpsanturtzilh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.entity.Kolore_historialak;

/**
 * {@link KoloreHistorialakRepository} interfazak {@link Kolore_historialak} entitatearekin
 * lotutako datuak kudeatzeko funtzionalitatea eskaintzen du.
 * 
 * <p>Spring Data JPA-ren {@link JpaRepository} erabiltzen da, hau da, 
 * datu-baseko eragiketak (sartu, eguneratu, ezabatu, bilatu) egiteko funtzionalitatea
 * eskaintzen duen interfazea. Honek, {@link Kolore_historialak} entitatearekin lotutako
 * operazioak modu automatikoan burutzen ditu.</p>
 * 
 * <p>Interfazearen galdera berezia:</p>
 * <ul>
 *   <li><strong>findByEzabatzeDataIsNull</strong>: Datu-basean ezabatutako
 *       kolore historialik ez duen (aktiboak diren) kolore historialen zerrenda lortzen du.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Repository
public interface KoloreHistorialakRepository extends JpaRepository<Kolore_historialak, Long> {

    /**
     * Ezabatze data null duten kolore historialak (aktiboak) lortzen dituen galdera.
     *
     * @return {@link List} Aktiboak diren kolore historialak.
     */
    List<Kolore_historialak> findByEzabatzeDataIsNull();
}
