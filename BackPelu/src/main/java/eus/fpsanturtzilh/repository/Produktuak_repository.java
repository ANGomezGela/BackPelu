package eus.fpsanturtzilh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.entity.Produktuak;

@Repository
public interface Produktuak_repository extends JpaRepository<Produktuak, Long>{
	
    List<Produktuak> findByEzabatzeDataIsNull();

	

}
