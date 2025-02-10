package eus.fpsanturtzilh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.entity.Kategoriak;

@Repository
public interface Kategoriak_repository extends JpaRepository<Kategoriak, Long>{

}
