package eus.fpsanturtzilh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.entity.Ticket_lerroak;

@Repository
public interface Ticket_lerroak_repository extends JpaRepository<Ticket_lerroak, Long>{
    List<Ticket_lerroak> findByEzabatzeDataIsNull();


}