package eus.fpsanturtzilh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import eus.fpsanturtzilh.entity.Txandak;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TxandakRepository extends JpaRepository<Txandak, Long> {
	
    List<Txandak> findByEzabatzeDataIsNull();


    // Encuentra turnos por fecha (hoy)
    List<Txandak> findByData(LocalDate data);

    @Query("SELECT t FROM Txandak t WHERE t.data = :fecha")
    List<Txandak> buscarTurnosPorFecha(@Param("fecha") LocalDate fecha);

}
