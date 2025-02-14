package eus.fpsanturtzilh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.entity.Kolore_historialak;

@Repository
public interface KoloreHistorialakRepository extends JpaRepository<Kolore_historialak, Long> {
    List<Kolore_historialak> findByEzabatzeDataIsNull();

}
