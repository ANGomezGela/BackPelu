package eus.fpsanturtzilh.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Ticket_lerroak;
import eus.fpsanturtzilh.repository.Ticket_lerroak_repository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class Ticket_lerroak_service {
	@Autowired
	Ticket_lerroak_repository ticket_lerroak_repository;
	
	//Gett
	public ArrayList<Ticket_lerroak> getLerroservice(){
		return (ArrayList<Ticket_lerroak>) ticket_lerroak_repository.findAll();
	}
	
	//Save
	public Ticket_lerroak saveLerroservice (Ticket_lerroak Courses) {
		return ticket_lerroak_repository.save(Courses);
	}
	
	//Find por Id
	public Optional<Ticket_lerroak>getById(Long id){
		return ticket_lerroak_repository.findById(id);
	}
	
	//Update
	public Ticket_lerroak updateById(Ticket_lerroak request, Long id) {
        Optional<Ticket_lerroak> optionalTicket = ticket_lerroak_repository.findById(id);
        
        if (optionalTicket.isPresent()) {
            Ticket_lerroak ticket_lerroak = optionalTicket.get();

            // Actualizar solo los campos que quieres modificar
            ticket_lerroak.setHitzordua(request.getHitzordua());
            ticket_lerroak.setZerbitzua(request.getZerbitzua());
            ticket_lerroak.setPrezioa(request.getPrezioa());
            ticket_lerroak.setEguneratzeData(LocalDateTime.now()); // Marcar fecha de actualización

            return ticket_lerroak_repository.save(ticket_lerroak);
        } else {
            throw new EntityNotFoundException("Ticket_lerroak no encontrado con id: " + id);
        }
    }
	
	//Borrar
	public Boolean deleteLerro_service (Long id) {
		try {
			ticket_lerroak_repository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

}
