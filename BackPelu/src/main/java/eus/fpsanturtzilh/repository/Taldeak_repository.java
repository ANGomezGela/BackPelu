package eus.fpsanturtzilh.repository;

import eus.fpsanturtzilh.entity.Taldeak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Taldeak_repository extends JpaRepository<Taldeak, String> {
	
}
