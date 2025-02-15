package eus.fpsanturtzilh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.entity.Zerbitzuak;

/**
 * {@link Zerbitzuak_repository} interfazak {@link Zerbitzuak} entitatearekin
 * lotutako datuak kudeatzeko funtzionalitatea eskaintzen du.
 * 
 * <p>Spring Data JPA-ren {@link JpaRepository} erabiltzen da, datu-baseko
 * eragiketak (sartu, eguneratu, ezabatu, bilatu) egiteko funtzionalitatea
 * eskaintzen duen interfazea. Honek, {@link Zerbitzuak} entitatearekin lotutako
 * operazioak modu automatikoan burutzen ditu.</p>
 * 
 * <p>Interfazearen galdera bereziak:</p>
 * <ul>
 *   <li><strong>findByEzabatzeDataIsNull</strong>: Ezabatze data null duten zerbitzuak (aktiboak diren) lortzen ditu.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Repository
public interface Zerbitzuak_repository extends JpaRepository<Zerbitzuak, Long> {

    /**
     * Ezabatze data null duten zerbitzuak (aktiboak) lortzen dituen galdera.
     *
     * @return {@link List} Aktiboak diren zerbitzuak.
     */
    List<Zerbitzuak> findByEzabatzeDataIsNull();
}
