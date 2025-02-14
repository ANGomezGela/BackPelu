package eus.fpsanturtzilh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.entity.Zerbitzuak;

@Repository
public interface Zerbitzuak_repository extends JpaRepository<Zerbitzuak, Long>{
    List<Zerbitzuak> findByEzabatzeDataIsNull();

	
}