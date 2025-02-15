package eus.fpsanturtzilh.repository;

import eus.fpsanturtzilh.entity.Hitzorduak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * {@link Hitzorduak_repository} interfazak {@link Hitzorduak} entitatearekin
 * lotutako datuak kudeatzeko funtzionalitatea eskaintzen du.
 * 
 * <p>Spring Data JPA-ren {@link JpaRepository} erabiltzen da, hau da, 
 * datu-baseko eragiketak (sartu, eguneratu, ezabatu, bilatu) egiteko funtzionalitatea
 * eskaintzen duen interfazea. Honek, {@link Hitzorduak} entitatearekin lotutako
 * operazioak modu automatikoan burutzen ditu.</p>
 * 
 * <p>Interfazearen bi galdera espezifiko ere definitzen dira:</p>
 * <ul>
 *   <li><strong>findByFecha</strong>: Zehaztutako datako hitzorduak eskuratzeko, 
 *       hasiera ordutik ordenatuta.</li>
 *   <li><strong>countByFecha</strong>: Hitzordu bakoitzeko kopurua eta data lortzeko, 
 *       data bakoitzeko kopurua kontatzen duena.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
public interface Hitzorduak_repository extends JpaRepository<Hitzorduak, Long> {

    /**
     * Zehaztutako data baten arabera, hasiera ordutik ordenatuta, 
     * hitzorduak lortzen dituen galdera.
     *
     * @param fecha Data zehaztua.
     * @return {@link List} Hitzorduak, hasiera ordutik ordenatuta.
     */
    @Query("SELECT h FROM Hitzorduak h WHERE h.data = :fecha ORDER BY h.hasieraOrdua ASC")
    List<Hitzorduak> findByFecha(@Param("fecha") LocalDate fecha);

    /**
     * Hitzordu bakoitzeko kopurua eta data lortzen dituen galdera.
     *
     * @return {@link List} Map bat, non bakoitzak data eta kopurua azaltzen dituen.
     */
    @Query("SELECT h.data as fecha, COUNT(h) as cantidad FROM Hitzorduak h GROUP BY h.data ORDER BY h.data ASC")
    List<Map<String, Object>> countByFecha();
}
