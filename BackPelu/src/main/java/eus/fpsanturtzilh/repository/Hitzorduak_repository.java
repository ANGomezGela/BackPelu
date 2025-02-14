package eus.fpsanturtzilh.repository;

import eus.fpsanturtzilh.entity.Hitzorduak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface Hitzorduak_repository extends JpaRepository<Hitzorduak, Long> {

    @Query("SELECT h FROM Hitzorduak h WHERE h.data = :fecha ORDER BY h.hasieraOrdua ASC")
    List<Hitzorduak> findByFecha(@Param("fecha") LocalDate fecha);

    @Query("SELECT h.data as fecha, COUNT(h) as cantidad FROM Hitzorduak h GROUP BY h.data ORDER BY h.data ASC")
    List<Map<String, Object>> countByFecha();
    
    
    List<Hitzorduak> findByEzabatzeDataIsNull();  

    List<Hitzorduak> findByFechaAndEzabatzeDataIsNull(LocalDate fecha);

}
