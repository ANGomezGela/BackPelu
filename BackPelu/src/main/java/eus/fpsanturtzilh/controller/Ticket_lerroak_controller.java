package eus.fpsanturtzilh.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eus.fpsanturtzilh.entity.Ticket_lerroak;
import eus.fpsanturtzilh.service.Ticket_lerroak_service;

@RestController
@RequestMapping("/ticket_lerroak_controler")
@CrossOrigin(origins = "http://localhost:8100")

public class Ticket_lerroak_controller {

	@Autowired
	private Ticket_lerroak_service ticket_lerroak_service;
	
	@GetMapping
	public ArrayList<Ticket_lerroak> getLerroservice() {
		return this.ticket_lerroak_service.getLerroservice();
	}
	
	@PostMapping
	public Ticket_lerroak saveLerro(@RequestBody Ticket_lerroak course) {
		return this.ticket_lerroak_service.saveLerroservice(course);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Ticket_lerroak> getLerroId(@PathVariable Long id) {
		return this.ticket_lerroak_service.getById(id);
	}

	@PutMapping(path = "/{id}")
	public Ticket_lerroak updateLerroById(@RequestBody Ticket_lerroak request, Long id) {
		return this.ticket_lerroak_service.updateById(request, id);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteLerroById(@PathVariable("id") Long id) {
		boolean ok = this.ticket_lerroak_service.deleteLerro_service(id);
		if (ok = true) {
			return "User with id: " + id + " Deleted";
		} else {
			return "Error";
		}
	}

	
}
