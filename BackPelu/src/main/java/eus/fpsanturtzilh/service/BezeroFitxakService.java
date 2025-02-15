package eus.fpsanturtzilh.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Bezero_fitxak;
import eus.fpsanturtzilh.repository.BezeroFitxakRepository;

/**
 * {@link BezeroFitxakService} klaseak {@link Bezero_fitxak} entitatearekin 
 * lotutako zerbitzuak kudeatzen ditu, bezeroen datuak jasotzeko, gordetzeko, 
 * eguneratzeko eta ezabatzeko funtzionalitateak eskainiz.
 * 
 * <p>Klase honek {@link BezeroFitxakRepository} erabiltzen du datu-basean
 * bezeroekin lotutako operazioak egiteko. Bezeroak bilatzeko, gordetzeko, 
 * eguneratzeko eta ezabatzeko (logikoak) hainbat metodo eskaintzen ditu.</p>
 * 
 * <p>Metoduen deskribapena:</p>
 * <ul>
 *   <li><strong>getBezeroak()</strong>: Datu-basean gordetako bezeroen zerrenda guztia lortzen du.</li>
 *   <li><strong>saveBezeroa(Bezero_fitxak bezeroa)</strong>: Bezero berri bat gordetzen du, sortze data jarriz.</li>
 *   <li><strong>getById(Long id)</strong>: Bezero bat IDaren arabera bilatzen du.</li>
 *   <li><strong>updateById(Bezero_fitxak request, Long id)</strong>: Bezero bat eguneratzen du IDaren arabera, 
 *       datu berriekin.</li>
 *   <li><strong>softDeleteBezeroa(Long id)</strong>: Bezero bat ezabatzen du (logikoki) ezabatze data eguneratuz.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Service
public class BezeroFitxakService {
    
    @Autowired
    private BezeroFitxakRepository bezeroFitxakRepository;

    /**
     * Datu-basean gordetako bezeroen zerrenda guztia lortzen du.
     *
     * @return {@link ArrayList} Bezero guztiak.
     */
    public ArrayList<Bezero_fitxak> getBezeroak(){
        return (ArrayList<Bezero_fitxak>) bezeroFitxakRepository.findAll();
    }
    
    /**
     * Bezero berri bat gordetzen du. Bezeroak sortze data jartzen du automatikoki.
     *
     * @param bezeroa Bezeroaren datuak.
     * @return {@link Bezero_fitxak} Gordetako bezeroa.
     */
    public Bezero_fitxak saveBezeroa(Bezero_fitxak bezeroa) {
        bezeroa.setSortzeData(LocalDateTime.now());
        return bezeroFitxakRepository.save(bezeroa);
    }

    /**
     * IDaren arabera bezero bat bilatzen du.
     *
     * @param id Bezeroaren IDa.
     * @return {@link Optional} Bezeroa, baldin badago.
     */
    public Optional<Bezero_fitxak> getById(Long id){
        return bezeroFitxakRepository.findById(id);
    }
    
    /**
     * Bezero bat eguneratzen du IDaren arabera. Datu berriekin eguneratzen ditu
     * izena, abizena, telefonoa, azal sentikorra eta eguneratze data.
     *
     * @param request Bezeroaren datuak eguneratzeko.
     * @param id Bezeroaren IDa.
     * @return {@link Bezero_fitxak} Eguneratutako bezeroa.
     * @throws RuntimeException Bezeroa ez bada aurkitzen.
     */
    public Bezero_fitxak updateById(Bezero_fitxak request, Long id) {
        Bezero_fitxak bezeroa = bezeroFitxakRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Bezeroa ez da aurkitu IDarekin: " + id));
        
        bezeroa.setIzena(request.getIzena());
        bezeroa.setAbizena(request.getAbizena());
        bezeroa.setTelefonoa(request.getTelefonoa());
        bezeroa.setAzalSentikorra(request.getAzalSentikorra());
        bezeroa.setEguneratzeData(LocalDateTime.now());
        
        return bezeroFitxakRepository.save(bezeroa);
    }
    
    /**
     * Bezero bat logikoki ezabatzen du, ezabatze data eguneratuz.
     *
     * @param id Bezeroaren IDa.
     * @return {@code true} Bezeroa ezabatuta, {@code false} ez bada aurkitu.
     */
    public boolean softDeleteBezeroa(Long id) {
        Optional<Bezero_fitxak> bezeroaOptional = bezeroFitxakRepository.findById(id);
        if (bezeroaOptional.isPresent()) {
            Bezero_fitxak bezeroa = bezeroaOptional.get();
            bezeroa.setEzabatzeData(LocalDate.now()); // Establece la fecha de eliminación
            bezeroFitxakRepository.save(bezeroa); // Guarda los cambios en la BD
            return true;
        }
        return false;
    }
    
}
