package eus.fpsanturtzilh.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Txandak;
import eus.fpsanturtzilh.repository.TxandakRepository;

/**
 * {@link TxandakService} klaseak txandaren kudeaketa eskaintzen du.
 * Klase honek txandako datu guztiak kudeatzen ditu, hau da, txandak lortzea,
 * gordetzea, eguneratzea eta ezabatzea ahalbidetzen du.
 *
 * <p>Klase honek {@link TxandakRepository} erabiltzen du txandako datuak datu-basean kudeatzeko.</p>
 *
 * <p>Metoduen deskribapena:</p>
 * <ul>
 *   <li><strong>getTxandak()</strong>: Txanda guztiak lortzen ditu.</li>
 *   <li><strong>saveTxanda(Txandak txanda)</strong>: Txanda berri bat gordetzen du datu-basean.</li>
 *   <li><strong>getTurnosDelDia()</strong>: Gaur egungo txandak lortzen ditu.</li>
 *   <li><strong>getTurnosDelDia(LocalDate fecha)</strong>: Zehaztutako datako txandak lortzen ditu.</li>
 *   <li><strong>getById(Long id)</strong>: Txanda bat bilatzen du IDaren bidez.</li>
 *   <li><strong>updateById(Txandak request, Long id)</strong>: Txanda baten datuak eguneratzen ditu IDaren bidez.</li>
 *   <li><strong>softDeleteTxanda(Long id)</strong>: Txanda bat ezabatzen du, baina ezabatze data ezartzen du soilik.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Service
public class TxandakService {
    @Autowired
    private TxandakRepository txandakRepository;
    
    /**
     * Txanda guztiak lortzen ditu.
     *
     * @return {@link ArrayList} Txandaren zerrenda.
     */
    public ArrayList<Txandak> getTxandak(){
        return (ArrayList<Txandak>) txandakRepository.findAll();
    }
    
    /**
     * Txanda berri bat gordetzen du datu-basean.
     *
     * @param txanda Gordetzeko txanda.
     * @return {@link Txandak} Gordetako txanda.
     */
    public Txandak saveTxanda(Txandak txanda) {
        txanda.setSortzeData(LocalDateTime.now());  // Sortze data ezartzen du
        return txandakRepository.save(txanda);
    }
    
    /**
     * Gaur egungo txandak lortzen ditu.
     *
     * @return {@link List} Gaur egungo txandaren zerrenda.
     */
    public List<Txandak> getTurnosDelDia() {
        LocalDate today = LocalDate.now();
        return txandakRepository.findByData(today);
    }

    /**
     * Zehaztutako datako txandak lortzen ditu.
     *
     * @param fecha Zehaztutako data.
     * @return {@link List} Datu horretako txandak.
     */
    public List<Txandak> getTurnosDelDia(LocalDate fecha) {
        return txandakRepository.buscarTurnosPorFecha(fecha);
    }

    /**
     * Txanda bat bilatzen du IDaren bidez.
     *
     * @param id Txandaren IDa.
     * @return {@link Optional} Txanda bilatzea, baldin badago.
     */
    public Optional<Txandak> getById(Long id){
        return txandakRepository.findById(id);
    }
    
    /**
     * Txanda baten datuak eguneratzen ditu IDaren bidez.
     *
     * @param request Eguneratutako datuak.
     * @param id Txandaren IDa.
     * @return {@link Txandak} Eguneratutako txanda.
     * @throws RuntimeException If txanda ez bada aurkitzen IDarekin.
     */
    public Txandak updateById(Txandak request, Long id) {
        Txandak txanda = txandakRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Txanda ez da aurkitu IDarekin: " + id));
        
        // Eguneratu nahi diren datuak
        txanda.setMota(request.getMota());
        txanda.setData(request.getData());
        txanda.setLangilea(request.getLangilea());
        txanda.setEguneratzeData(LocalDateTime.now());  // Eguneratzearen data ezartzen du
        
        return txandakRepository.save(txanda);
    }
    
    /**
     * Txanda bat ezabatzen du, baina ezabatze data ezartzen du soilik.
     * 
     * @param id Txandaren IDa.
     * @return {@code true} Txanda ezabatzea lortu bada, {@code false} bestela.
     */
    public boolean softDeleteTxanda(Long id) {
        Optional<Txandak> optionalTxanda = txandakRepository.findById(id);
        if (optionalTxanda.isPresent()) {
            Txandak txanda = optionalTxanda.get();
            txanda.setEzabatzeData(LocalDateTime.now());  // Ezabatze data ezartzen du
            txandakRepository.save(txanda);
            return true;
        }
        return false;
    }
}
