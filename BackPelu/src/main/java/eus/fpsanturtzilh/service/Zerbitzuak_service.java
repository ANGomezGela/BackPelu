package eus.fpsanturtzilh.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Zerbitzuak;
import eus.fpsanturtzilh.repository.Zerbitzuak_repository;

/**
 * {@link Zerbitzuak_service} klaseak zerbitzuen kudeaketa eskaintzen du.
 * Klase honek zerbitzuen datuak kudeatzen ditu, zerbitzuak lortzea,
 * gordetzea, eguneratzea, eguneratze partziala (patch) eta ezabatzea ahalbidetzen du.
 *
 * <p>Klase honek {@link Zerbitzuak_repository} erabiltzen du zerbitzuen datuak datu-basean kudeatzeko.</p>
 *
 * <p>Metoduen deskribapena:</p>
 * <ul>
 *   <li><strong>getZerbitzuak()</strong>: Zerbitzu guztiak lortzen ditu.</li>
 *   <li><strong>saveZerbitzuak(Zerbitzuak servi)</strong>: Zerbitzu berri bat gordetzen du datu-basean.</li>
 *   <li><strong>getById(Long id)</strong>: Zerbitzu bat bilatzen du IDaren bidez.</li>
 *   <li><strong>patchById(Zerbitzuak request, Long id)</strong>: Zerbitzu baten datuak eguneratzen ditu, baina soilik beharrezkoak direnak.</li>
 *   <li><strong>updateById(Zerbitzuak request, Long id)</strong>: Zerbitzu baten datuak eguneratzen ditu IDaren bidez.</li>
 *   <li><strong>softDeleteZerbitzuak(Long id)</strong>: Zerbitzu bat ezabatzen du, baina ezabatze data ezartzen du soilik.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Service
public class Zerbitzuak_service {
	@Autowired
	Zerbitzuak_repository zerbitzuak_repository;
	
	/**
	 * Zerbitzu guztiak lortzen ditu.
	 *
	 * @return {@link ArrayList} Zerbitzuen zerrenda.
	 */
	public ArrayList<Zerbitzuak> getZerbitzuak(){
		return (ArrayList<Zerbitzuak>) zerbitzuak_repository.findAll();
	}
	
	/**
	 * Zerbitzu berri bat gordetzen du datu-basean.
	 *
	 * @param servi Gordetzeko zerbitzuaren informazioa.
	 * @return {@link Zerbitzuak} Gordetako zerbitzua.
	 */
	public Zerbitzuak saveZerbitzuak(Zerbitzuak servi) {
		return zerbitzuak_repository.save(servi);
	}
	
	/**
	 * Zerbitzu bat bilatzen du IDaren bidez.
	 *
	 * @param id Zerbitzuaren IDa.
	 * @return {@link Optional} Zerbitzu bilatzea, baldin badago.
	 */
	public Optional<Zerbitzuak> getById(Long id){
		return zerbitzuak_repository.findById(id);
	}
	
	/**
	 * Zerbitzu baten datuak eguneratzen ditu, baina soilik zehaztutakoak (patch).
	 * 
	 * @param request Eguneratutako datuak.
	 * @param id Zerbitzuaren IDa.
	 * @return {@link Zerbitzuak} Eguneratutako zerbitzua.
	 * @throws RuntimeException Si el servicio no se encuentra con el ID proporcionado.
	 */
	public Zerbitzuak patchById(Zerbitzuak request, Long id) {
	    Optional<Zerbitzuak> optionalZerbitzu = zerbitzuak_repository.findById(id);

	    if (optionalZerbitzu.isPresent()) {
	        Zerbitzuak existingZerbitzu = optionalZerbitzu.get();

	        // Solo actualiza los campos que no sean nulos en la petición
	        if (request.getIzena() != null) {
	            existingZerbitzu.setIzena(request.getIzena());
	        }
	        if (request.getKategoriak() != null) {
	            existingZerbitzu.setKategoriak(request.getKategoriak());
	        }
	        if (request.getEtxekoPrezioa() != null) {
	            existingZerbitzu.setEtxekoPrezioa(request.getEtxekoPrezioa());
	        }
	        if (request.getKanpokoPrezioa() != null) {
	            existingZerbitzu.setKanpokoPrezioa(request.getKanpokoPrezioa());
	        }

	        existingZerbitzu.setEguneratzeData(LocalDateTime.now()); // Eguneratzearen data

	        return zerbitzuak_repository.save(existingZerbitzu);
	    } else {
	        throw new RuntimeException("Zerbitzua ez da aurkitu IDarekin: " + id);
	    }
	}
	
	/**
	 * Zerbitzu baten datuak eguneratzen ditu IDaren bidez.
	 *
	 * @param request Eguneratutako zerbitzuaren datuak.
	 * @param id Zerbitzuaren IDa.
	 * @return {@link Zerbitzuak} Eguneratutako zerbitzua.
	 */
	public Zerbitzuak updateById(Zerbitzuak request, Long id) {
		Zerbitzuak zerbitzuak = zerbitzuak_repository.findById(id).get();

        // Eguneratu nahi diren datuak
        zerbitzuak.setIzena(request.getIzena());
        zerbitzuak.setKategoriak(request.getKategoriak());
        zerbitzuak.setEtxekoPrezioa(request.getEtxekoPrezioa());
        zerbitzuak.setKanpokoPrezioa(request.getKanpokoPrezioa());
        zerbitzuak.setEguneratzeData(LocalDateTime.now()); // Eguneratze data

        return zerbitzuak_repository.save(zerbitzuak);
	}
	
	/**
	 * Zerbitzu bat ezabatzen du, baina ezabatze data ezartzen du soilik (soft delete).
	 * 
	 * @param id Zerbitzuaren IDa.
	 * @return {@code true} Zerbitzua ezabatzea lortu bada, {@code false} bestela.
	 */
	public boolean softDeleteZerbitzuak(Long id) {
        Optional<Zerbitzuak> optionalZerbitzuak = zerbitzuak_repository.findById(id);
        if (optionalZerbitzuak.isPresent()) {
            Zerbitzuak zerbitzuak = optionalZerbitzuak.get();
            zerbitzuak.setEzabatzeData(LocalDateTime.now());  // Ezabatze data ezartzen du
            zerbitzuak_repository.save(zerbitzuak);
            return true;
        }
        return false;
    }
}
