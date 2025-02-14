package eus.fpsanturtzilh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.entity.Langileak;

@Repository
public interface LangileakRepository extends JpaRepository<Langileak, Long> {
	
    List<Langileak> findByEzabatzeDataIsNull();

}