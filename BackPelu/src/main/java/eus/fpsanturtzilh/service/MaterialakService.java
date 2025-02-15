package eus.fpsanturtzilh.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Materialak;
import eus.fpsanturtzilh.repository.MaterialakRepository;

/**
 * {@link MaterialakService} klaseak materialen datuak kudeatzeko zerbitzuak eskaintzen ditu.
 * Materialen datuak lortzeko, gordetzeko, eguneratzeko eta ezabatzeko funtzionalitateak eskaintzen ditu.
 *
 * <p>Klase honek {@link MaterialakRepository} erabiltzen du materialei buruzko operazioak egiteko.</p>
 *
 * <p>Metoduen deskribapena:</p>
 * <ul>
 *   <li><strong>getMaterialak()</strong>: Materialen datu guztiak lortzen ditu.</li>
 *   <li><strong>saveMateriala(Materialak materiala)</strong>: Material berri bat datu-basean gordetzen du.</li>
 *   <li><strong>getById(Long id)</strong>: Material bat bilatzen du identifikatzailearen bidez.</li>
 *   <li><strong>patchById(Materialak request, Long id)</strong>: Material baten datuak eguneratzen ditu, baina soilik
 *   nuloak ez diren datuak eguneratzen dira.</li>
 *   <li><strong>updateById(Materialak request, Long id)</strong>: Material baten datuak eguneratzen ditu identifikatzailearen bidez.</li>
 *   <li><strong>softDeleteMateriala(Long id)</strong>: Materiala ezabatzen du, baina ezabatze data ezartzen du soilik.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Service
public class MaterialakService {
    
    @Autowired
    private MaterialakRepository materialakRepository;
    
    /**
     * Materialen datu guztiak lortzen ditu.
     *
     * @return {@link ArrayList} Materialen zerrenda.
     */
    public ArrayList<Materialak> getMaterialak(){
        return (ArrayList<Materialak>) materialakRepository.findAll();
    }
    
    /**
     * Material berri bat datu-basean gordetzen du.
     *
     * @param materiala {@link Materialak} Gorde nahi den materialaren datuak.
     * @return {@link Materialak} Gorde den materiala.
     */
    public Materialak saveMateriala(Materialak materiala) {
        materiala.setSortzeData(LocalDateTime.now());
        return materialakRepository.save(materiala);
    }
    
    /**
     * Material bat bilatzen du identifikatzailearen bidez.
     *
     * @param id Materialaren identifikatzailea.
     * @return {@link Optional} Materialaren datuak, baldin badago.
     */
    public Optional<Materialak> getById(Long id){
        return materialakRepository.findById(id);
    }
    
    /**
     * Material baten datuak eguneratzen ditu, baina soilik nuloak ez diren datuak eguneratzen ditu.
     *
     * @param request {@link Materialak} Eguneratutako materialaren datuak.
     * @param id Materialaren identifikatzailea.
     * @return {@link Materialak} Eguneratutako materiala.
     * @throws RuntimeException Materiala ez bada aurkitzen identifikatzailearekin.
     */
    public Materialak patchById(Materialak request, Long id) {
        Optional<Materialak> optionalMaterial = materialakRepository.findById(id);

        if (optionalMaterial.isPresent()) {
            Materialak existingMaterial = optionalMaterial.get();

            // Solo actualiza los campos que no sean nulos en la petición
            if (request.getEtiketa() != null) {
                existingMaterial.setEtiketa(request.getEtiketa());
            }
            if (request.getIzena() != null) {
                existingMaterial.setIzena(request.getIzena());
            }
            if (request.getKategoriak() != null) {
                existingMaterial.setKategoriak(request.getKategoriak());
            }

            existingMaterial.setEguneratzeData(LocalDateTime.now());

            return materialakRepository.save(existingMaterial);
        } else {
            throw new RuntimeException("Material no encontrado con ID: " + id);
        }
    }
    
    /**
     * Material baten datuak eguneratzen ditu identifikatzailearen bidez.
     * 
     * <p>Metodo honek materialaren datuak eguneratzen ditu, eta eguneratze data automatikoki ezartzen du.</p>
     *
     * @param request {@link Materialak} Eguneratutako materialaren datuak.
     * @param id Materialaren identifikatzailea.
     * @return {@link Materialak} Eguneratutako materiala.
     * @throws RuntimeException Materiala ez bada aurkitzen identifikatzailearekin.
     */
    public Materialak updateById(Materialak request, Long id) {
        Materialak materiala = materialakRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Materiala no encontrado con ID: " + id));
        
        materiala.setEtiketa(request.getEtiketa());
        materiala.setIzena(request.getIzena());
        materiala.setKategoriak(request.getKategoriak());
        materiala.setEguneratzeData(LocalDateTime.now());
        
        return materialakRepository.save(materiala);
    }
    
    /**
     * Materiala ezabatzen du, ezabatzeko data ezarriz.
     * 
     * <p>Metodo honek materiala datu-basean ezabatzen du, baina ezabatze data ezartzen du soilik, datuak benetan
     * ezabatzen gabe.</p>
     *
     * @param id Materialaren identifikatzailea.
     * @return {@code true} Materiala ezabatu bada, {@code false} bestela.
     */
    public boolean softDeleteMateriala(Long id) {
        Optional<Materialak> optionalMateriala = materialakRepository.findById(id);
        if (optionalMateriala.isPresent()) {
            Materialak materiala = optionalMateriala.get();
            materiala.setEzabatzeData(LocalDateTime.now());  // Ezabatze data ezartzen du
            materialakRepository.save(materiala);
            return true;
        }
        return false;
    }
}
