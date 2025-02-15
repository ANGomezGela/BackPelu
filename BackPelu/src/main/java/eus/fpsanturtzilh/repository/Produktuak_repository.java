package eus.fpsanturtzilh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.entity.Produktuak;

/**
 * {@link Produktuak_repository} interfazak {@link Produktuak} entitatearekin
 * lotutako datuak kudeatzeko funtzionalitatea eskaintzen du.
 * 
 * <p>Spring Data JPA-ren {@link JpaRepository} erabiltzen da, hau da, 
 * datu-baseko eragiketak (sartu, eguneratu, ezabatu, bilatu) egiteko funtzionalitatea
 * eskaintzen duen interfazea. Honek, {@link Produktuak} entitatearekin lotutako
 * operazioak modu automatikoan burutzen ditu.</p>
 * 
 * <p>Interfazearen galdera berezia:</p>
 * <ul>
 *   <li><strong>findByEzabatzeDataIsNull</strong>: Datu-basean ezabatutako produktuak ez duten
 *       (aktiboak diren) produktuen zerrenda lortzen du.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Repository
public interface Produktuak_repository extends JpaRepository<Produktuak, Long> {

    /**
     * Ezabatze data null duten produktuak (aktiboak) lortzen dituen galdera.
     *
     * @return {@link List} Aktiboak diren produktuak.
     */
    List<Produktuak> findByEzabatzeDataIsNull();
}
