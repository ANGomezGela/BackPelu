package eus.fpsanturtzilh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.entity.Ticket_lerroak;

/**
 * {@link Ticket_lerroak_repository} interfazak {@link Ticket_lerroak} entitatearekin
 * lotutako datuak kudeatzeko funtzionalitatea eskaintzen du.
 * 
 * <p>Spring Data JPA-ren {@link JpaRepository} erabiltzen da, hau da, 
 * datu-baseko eragiketak (sartu, eguneratu, ezabatu, bilatu) egiteko funtzionalitatea
 * eskaintzen duen interfazea. Honek, {@link Ticket_lerroak} entitatearekin lotutako
 * operazioak modu automatikoan burutzen ditu.</p>
 * 
 * <p>Interfazearen galdera berezia:</p>
 * <ul>
 *   <li><strong>findByEzabatzeDataIsNull</strong>: Datu-basean ezabatutako ticket lerroak
 *       ez duten (aktiboak diren) ticket lerro guztien zerrenda lortzen du.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Repository
public interface Ticket_lerroak_repository extends JpaRepository<Ticket_lerroak, Long> {

    /**
     * Ezabatze data null duten ticket lerroak (aktiboak) lortzen dituen galdera.
     *
     * @return {@link List} Aktiboak diren ticket lerroak.
     */
    List<Ticket_lerroak> findByEzabatzeDataIsNull();
}
