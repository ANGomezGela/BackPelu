package eus.fpsanturtzilh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.entity.Produktu_mugimenduak;

@Repository
public interface Produktu_mugimenduak_repository extends JpaRepository<Produktu_mugimenduak, Long>{

}
