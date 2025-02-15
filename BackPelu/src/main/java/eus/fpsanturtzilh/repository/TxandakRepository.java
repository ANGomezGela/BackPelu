package eus.fpsanturtzilh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import eus.fpsanturtzilh.entity.Txandak;
import java.time.LocalDate;
import java.util.List;

/**
 * {@link TxandakRepository} interfazak {@link Txandak} entitatearekin
 * lotutako datuak kudeatzeko funtzionalitatea eskaintzen du.
 * 
 * <p>Spring Data JPA-ren {@link JpaRepository} erabiltzen da, hau da, 
 * datu-baseko eragiketak (sartu, eguneratu, ezabatu, bilatu) egiteko funtzionalitatea
 * eskaintzen duen interfazea. Honek, {@link Txandak} entitatearekin lotutako
 * operazioak modu automatikoan burutzen ditu.</p>
 * 
 * <p>Interfazearen galdera bereziak:</p>
 * <ul>
 *   <li><strong>findByEzabatzeDataIsNull</strong>: Datu-basean ezabatutako txandak
 *       ez duten (aktiboak diren) txanda guztiak lortzen ditu.</li>
 *   <li><strong>findByData</strong>: Zehaztutako datan dagoen txanda zerrenda lortzen du (egon daitezkeen txandak adibidez, gaur).</li>
 *   <li><strong>buscarTurnosPorFecha</strong>: Zehaztutako data duen txanda guztiak lortzen ditu. Honek {@link Query} erabiltzen du.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Repository
public interface TxandakRepository extends JpaRepository<Txandak, Long> {
    
    /**
     * Ezabatze data null duten txandak (aktiboak) lortzen dituen galdera.
     *
     * @return {@link List} Aktiboak diren txandak.
     */
    List<Txandak> findByEzabatzeDataIsNull();

    /**
     * Zehaztutako datan dagoen txanda zerrenda lortzen du.
     *
     * @param data Datuan zehar ikusi nahi den txanda.
     * @return {@link List} Txanda zerrenda, zehaztutako datarekin.
     */
    List<Txandak> findByData(LocalDate data);

    /**
     * Zehaztutako data duen txanda guztiak lortzen ditu.
     *
     * @param fecha Zehaztutako data.
     * @return {@link List} Txandak, zehaztutako datarekin.
     */
    @Query("SELECT t FROM Txandak t WHERE t.data = :fecha")
    List<Txandak> buscarTurnosPorFecha(@Param("fecha") LocalDate fecha);
}
