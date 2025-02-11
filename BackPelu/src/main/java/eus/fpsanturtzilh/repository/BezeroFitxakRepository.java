package eus.fpsanturtzilh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.entity.Bezero_fitxak;

@Repository
public interface BezeroFitxakRepository extends JpaRepository<Bezero_fitxak, Long> {
	
	
}
