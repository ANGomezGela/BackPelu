package eus.fpsanturtzilh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.entity.Material_maileguak;

@Repository
public interface MaterialMaileguakRepository extends JpaRepository<Material_maileguak, Long> {
    List<Material_maileguak> findByEzabatzeDataIsNull();

}
