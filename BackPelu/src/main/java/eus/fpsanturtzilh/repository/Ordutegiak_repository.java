package eus.fpsanturtzilh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.entity.Ordutegiak;

@Repository
public interface Ordutegiak_repository extends JpaRepository<Ordutegiak, Long>{

}
