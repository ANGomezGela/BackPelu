package eus.fpsanturtzilh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.entity.Langileak;

@Repository
public interface LangileakRepository extends JpaRepository<Langileak, Long> {
}