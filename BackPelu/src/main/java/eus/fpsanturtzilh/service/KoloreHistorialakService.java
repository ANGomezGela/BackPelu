package eus.fpsanturtzilh.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Kolore_historialak;
import eus.fpsanturtzilh.repository.KoloreHistorialakRepository;

/**
 * {@link KoloreHistorialakService} klaseak kolorearen historialarekin lotutako zerbitzuak eskaintzen ditu.
 * Kolorearen historiak kudeatzeko funtzionalitateak eskaintzen ditu, hala nola lortu, gorde, eguneratu eta ezabatu.
 *
 * <p>Klase honek {@link KoloreHistorialakRepository} erabiltzen du kolorearen historialarekin lotutako
 * operazioak egiteko.</p>
 *
 * <p>Metoduen deskribapena:</p>
 * <ul>
 *   <li><strong>getKoloreHistorialak()</strong>: Kolorearen historiaren datu guztiak lortzen ditu.</li>
 *   <li><strong>saveKoloreHistoriala(Kolore_historialak koloreHistoriala)</strong>: Kolorearen historial berri bat
 *       datu-basean gordetzen du.</li>
 *   <li><strong>getById(Long id)</strong>: Kolorearen historial bat bilatzen du identifikatzailearen bidez.</li>
 *   <li><strong>updateById(Kolore_historialak request, Long id)</strong>: Kolorearen historial bat eguneratzen du,
 *       datuak eguneratuz, eta eguneratze data automatikoki ezartzen du.</li>
 *   <li><strong>softDeleteKoloreHistoriala(Long id)</strong>: Kolorearen historial bat ezabatzen du, baina ezabatze
 *       data ezartzen du soilik, datu-basean benetan ezabatzen gabe.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Service
public class KoloreHistorialakService {
    
    @Autowired
    private KoloreHistorialakRepository koloreHistorialakRepository;

    /**
     * Kolorearen historiako datu guztiak lortzen ditu.
     *
     * @return {@link ArrayList} Kolorearen historialaren zerrenda.
     */
    public ArrayList<Kolore_historialak> getKoloreHistorialak() {
        return (ArrayList<Kolore_historialak>) koloreHistorialakRepository.findAll();
    }

    /**
     * Kolorearen historial berri bat datu-basean gordetzen du.
     *
     * @param koloreHistoriala {@link Kolore_historialak} Gorde nahi den historial kolorearen datuak.
     * @return {@link Kolore_historialak} Gorde den historial kolorea.
     */
    public Kolore_historialak saveKoloreHistoriala(Kolore_historialak koloreHistoriala) {
        koloreHistoriala.setSortzeData(LocalDateTime.now());
        return koloreHistorialakRepository.save(koloreHistoriala);
    }

    /**
     * Kolorearen historial bat bilatzen du identifikatzailearen bidez.
     *
     * @param id Kolorearen historialaren identifikatzailea.
     * @return {@link Optional} Kolorearen historiala, baldin bada.
     */
    public Optional<Kolore_historialak> getById(Long id) {
        return koloreHistorialakRepository.findById(id);
    }

    /**
     * Kolorearen historial bat eguneratzen du identifikatzailearen bidez.
     * 
     * <p>Metodo honek historialaren datuak eguneratzen ditu, eta eguneratze data automatikoki ezartzen du.
     * Halaber, ezabatze data eskatuz gero, hori ere eguneratzen da.</p>
     *
     * @param request {@link Kolore_historialak} Eguneratutako historial kolorearen datuak.
     * @param id Kolorearen historialaren identifikatzailea.
     * @return {@link Kolore_historialak} Eguneratutako historial kolorea.
     * @throws RuntimeException Historial kolorea ez bada aurkitzen identifikatzailearekin.
     */
    public Kolore_historialak updateById(Kolore_historialak request, Long id) {
        Kolore_historialak koloreHistoriala = koloreHistorialakRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Historial de color no encontrado con ID: " + id));
        
        koloreHistoriala.setBezeroa(request.getBezeroa());
        koloreHistoriala.setProduktua(request.getProduktua());
        koloreHistoriala.setData(request.getData());
        koloreHistoriala.setKantitatea(request.getKantitatea());
        koloreHistoriala.setBolumena(request.getBolumena());
        koloreHistoriala.setOharrak(request.getOharrak());
        koloreHistoriala.setEguneratzeData(LocalDateTime.now());
        
        return koloreHistorialakRepository.save(koloreHistoriala);
    }

    /**
     * Kolorearen historial bat ezabatzen du, ezabatzeko data ezarriz.
     * 
     * <p>Metodo honek historialaren datu-basean ezabatzeko data ezartzen du, baina ezabatutako datuak benetan
     * ezabatzen gabe.</p>
     *
     * @param id Kolorearen historialaren identifikatzailea.
     * @return {@code true} Historiala ezabatu bada, {@code false} bestela.
     */
    public boolean softDeleteKoloreHistoriala(Long id) {
        Optional<Kolore_historialak> optionalKoloreHistoriala = koloreHistorialakRepository.findById(id);
        if (optionalKoloreHistoriala.isPresent()) {
            Kolore_historialak koloreHistoriala = optionalKoloreHistoriala.get();
            koloreHistoriala.setEzabatzeData(LocalDateTime.now());  // Ezabatze data ezartzen du
            koloreHistorialakRepository.save(koloreHistoriala);
            return true;
        }
        return false;
    }
}
