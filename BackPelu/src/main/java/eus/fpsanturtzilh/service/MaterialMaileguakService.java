package eus.fpsanturtzilh.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.entity.Material_maileguak;
import eus.fpsanturtzilh.repository.MaterialMaileguakRepository;

/**
 * {@link MaterialMaileguakService} klaseak materialen maileguen kudeaketa egiten du.
 * Maileguen datuak lortzeko, gordetzeko, eguneratzeko eta ezabatzeko funtzionalitateak eskaintzen ditu.
 *
 * <p>Klase honek {@link MaterialMaileguakRepository} erabiltzen du material maileguen operazioak egiteko.</p>
 *
 * <p>Metoduen deskribapena:</p>
 * <ul>
 *   <li><strong>getMaterialMaileguak()</strong>: Materialen maileguen datuak guztiak lortzen ditu.</li>
 *   <li><strong>saveMaterialMailegua(Material_maileguak materialMailegua)</strong>: Material mailegu berri bat gordetzen du.</li>
 *   <li><strong>getById(Long id)</strong>: Material mailegu bat bilatzen du identifikatzailearen bidez.</li>
 *   <li><strong>updateById(Material_maileguak request, Long id)</strong>: Material mailegu baten datuak eguneratzen ditu identifikatzailearen bidez.</li>
 *   <li><strong>softDeleteMaterialMailegua(Long id)</strong>: Material mailegua ezabatzen du, baina ezabatze data ezartzen du soilik.</li>
 * </ul>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@Service
public class MaterialMaileguakService {
    
    @Autowired
    private MaterialMaileguakRepository materialMaileguakRepository;
    
    /**
     * Materialen maileguen datu guztiak lortzen ditu.
     *
     * @return {@link ArrayList} Material maileguen zerrenda.
     */
    public ArrayList<Material_maileguak> getMaterialMaileguak(){
        return (ArrayList<Material_maileguak>) materialMaileguakRepository.findAll();
    }
    
    /**
     * Material mailegu berri bat datu-basean gordetzen du.
     *
     * @param materialMailegua {@link Material_maileguak} Gorde nahi den material mailegua.
     * @return {@link Material_maileguak} Gorde den material mailegua.
     */
    public Material_maileguak saveMaterialMailegua(Material_maileguak materialMailegua) {
        materialMailegua.setSortzeData(LocalDateTime.now());
        return materialMaileguakRepository.save(materialMailegua);
    }
    
    /**
     * Material mailegu bat bilatzen du identifikatzailearen bidez.
     *
     * @param id Material maileguaren identifikatzailea.
     * @return {@link Optional} Material maileguaren datuak, baldin badago.
     */
    public Optional<Material_maileguak> getById(Long id){
        return materialMaileguakRepository.findById(id);
    }
    
    /**
     * Material mailegu baten datuak eguneratzen ditu identifikatzailearen bidez.
     * 
     * <p>Metodo honek material maileguaren datuak eguneratzen ditu, eta eguneratze data automatikoki ezartzen du.</p>
     *
     * @param request {@link Material_maileguak} Eguneratutako material maileguaren datuak.
     * @param id Material maileguaren identifikatzailea.
     * @return {@link Material_maileguak} Eguneratutako material mailegua.
     * @throws RuntimeException Material mailegua ez bada aurkitzen identifikatzailearekin.
     */
    public Material_maileguak updateById(Material_maileguak request, Long id) {
        Material_maileguak materialMailegua = materialMaileguakRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Material mailegua no encontrado con ID: " + id));
        
        materialMailegua.setMaterialak(request.getMaterialak());
        materialMailegua.setLangilea(request.getLangilea());
        materialMailegua.setHasieraData(request.getHasieraData());
        materialMailegua.setAmaieraData(request.getAmaieraData());
        materialMailegua.setEguneratzeData(LocalDateTime.now());
        
        return materialMaileguakRepository.save(materialMailegua);
    }
    
    /**
     * Material mailegua ezabatzen du, ezabatzeko data ezarriz.
     * 
     * <p>Metodo honek material mailegua datu-basean ezabatzen du, baina ezabatze data ezartzen du soilik, datuak benetan
     * ezabatzen gabe.</p>
     *
     * @param id Material maileguaren identifikatzailea.
     * @return {@code true} Material mailegua ezabatu bada, {@code false} bestela.
     */
    public boolean softDeleteMaterialMailegua(Long id) {
        Optional<Material_maileguak> optionalMaterialMailegua = materialMaileguakRepository.findById(id);
        if (optionalMaterialMailegua.isPresent()) {
            Material_maileguak materialMailegua = optionalMaterialMailegua.get();
            materialMailegua.setEzabatzeData(LocalDateTime.now());  // Ezabatze data ezartzen du
            materialMaileguakRepository.save(materialMailegua);
            return true;
        }
        return false;
    }
}
