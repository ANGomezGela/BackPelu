package eus.fpsanturtzilh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.entity.Materialak;

@Repository
public interface MaterialakRepository extends JpaRepository<Materialak, Long> {
	
    List<Materialak> findByEzabatzeDataIsNull();

}
