package eus.fpsanturtzilh.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Ticket_lerroak;
import eus.fpsanturtzilh.repository.Ticket_lerroak_repository;
import jakarta.persistence.EntityNotFoundException;

/**
 * {@link Ticket_lerroak_service} klaseak ticket lerroen kudeaketa egiten du.
 * Ticket lerroak lortzea, gordetzea, eguneratzea eta ezabatzea ahalbidetzen du.
 *
 * <p>Klase honek {@link Ticket_lerroak_repository} erabiltzen du ticket lerroak datu-basean kudeatzeko.</p>
 *
 * <p>Metoduen deskribapena:</p>
 * <ul>
 *   <li><strong>getLerroservice()</strong>: Ticket lerro guztiak lortzen ditu.</li>
 *   <li><strong>saveLerroservice(Ticket_lerroak ticket_lerroak)</strong>: Ticket lerro bat gordetzen du datu-basean.</li>
 *   <li><strong>getById(Long id)</strong>: Ticket lerro bat bilatzen du IDaren bidez.</li>
 *   <li><strong>updateById(Ticket_lerroak request, Long id)</strong>: Ticket lerro baten datuak eguneratzen ditu.</li>
 *   <li><strong>softDeleteLerro(Long id)</strong>: Ticket lerro bat ezabatzen du, baina ezabatze data ezartzen du soilik.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Service
public class Ticket_lerroak_service {
	@Autowired
	Ticket_lerroak_repository ticket_lerroak_repository;
	
	/**
	 * Ticket lerro guztiak lortzen ditu.
	 *
	 * @return {@link ArrayList} Ticket lerroen zerrenda.
	 */
	public ArrayList<Ticket_lerroak> getLerroservice(){
		return (ArrayList<Ticket_lerroak>) ticket_lerroak_repository.findAll();
	}
	
	/**
	 * Ticket lerro berri bat gordetzen du datu-basean.
	 *
	 * @param Courses Ticket lerroa gordetzeko objektua.
	 * @return {@link Ticket_lerroak} Gordetako ticket lerroa.
	 */
	public Ticket_lerroak saveLerroservice (Ticket_lerroak Courses) {
		return ticket_lerroak_repository.save(Courses);
	}
	
	/**
	 * Ticket lerro bat bilatzen du IDaren bidez.
	 *
	 * @param id Ticket lerroaren IDa.
	 * @return {@link Optional} Ticket lerroaren datuak, baldin badago.
	 */
	public Optional<Ticket_lerroak> getById(Long id){
		return ticket_lerroak_repository.findById(id);
	}
	
	/**
	 * Ticket lerro baten datuak eguneratzen ditu IDaren bidez.
	 * 
	 * @param request Eguneratutako Ticket lerroaren datuak.
	 * @param id Ticket lerroaren IDa.
	 * @return {@link Ticket_lerroak} Eguneratutako ticket lerroa.
	 * @throws EntityNotFoundException If ticket lerroa ez bada aurkitzen IDarekin.
	 */
	public Ticket_lerroak updateById(Ticket_lerroak request, Long id) {
        Optional<Ticket_lerroak> optionalTicket = ticket_lerroak_repository.findById(id);
        
        if (optionalTicket.isPresent()) {
            Ticket_lerroak ticket_lerroak = optionalTicket.get();

            // Eguneratu nahi diren soilik behar diren datuak
            ticket_lerroak.setHitzordua(request.getHitzordua());
            ticket_lerroak.setZerbitzua(request.getZerbitzua());
            ticket_lerroak.setPrezioa(request.getPrezioa());
            ticket_lerroak.setEguneratzeData(LocalDateTime.now()); // Eguneratzearen data ezartzen du

            return ticket_lerroak_repository.save(ticket_lerroak);
        } else {
            throw new EntityNotFoundException("Ticket_lerroak ez da aurkitu IDarekin: " + id);
        }
    }
	
	/**
	 * Ticket lerro bat ezabatzen du, baina ezabatze data ezartzen du soilik.
	 * 
	 * @param id Ticket lerroaren IDa.
	 * @return {@code true} Ticket lerroa ezabatzea lortu bada, {@code false} bestela.
	 */
    public boolean softDeleteLerro(Long id) {
        Optional<Ticket_lerroak> optionalTicket = ticket_lerroak_repository.findById(id);
        if (optionalTicket.isPresent()) {
            Ticket_lerroak ticket = optionalTicket.get();
            ticket.setEzabatzeData(LocalDateTime.now());  // Ezabatze data ezartzen du
            ticket_lerroak_repository.save(ticket);
            return true;
        }
        return false;
    }
}
