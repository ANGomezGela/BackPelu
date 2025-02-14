package eus.fpsanturtzilh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.entity.Kategoriak;

@Repository
public interface Kategoriak_repository extends JpaRepository<Kategoriak, Long>{

    List<Kategoriak> findByEzabatzeDataIsNull();  // Solo registros activos (no eliminados)

}
