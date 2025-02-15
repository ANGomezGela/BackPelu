package eus.fpsanturtzilh.controller;

import eus.fpsanturtzilh.service.Erabiltzaileak_service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * {@code Erabiltzaileak_controller} klasea erabiltzaileen datuak kudeatzeko kontrolatzailea da.
 * <p>
 * API honek erabiltzaile guztiak itzultzen ditu, beharrezko eremuak soilik barne hartuz.
 * </p>
 *
 * @author [Zure Izena]
 * @version 1.0
 * @since 2025-02-15
 */
@RestController
@RequestMapping("/api/erabiltzaileak")
@CrossOrigin(origins = "http://localhost:8100")
public class Erabiltzaileak_controller {

    /**
     * Erabiltzaileen zerbitzu-klasea injektatzen du.
     */
    private final Erabiltzaileak_service erabiltzaileakService;

    /**
     * Erabiltzaileak_controller klasearen eraikitzailea.
     *
     * @param erabiltzaileakService Erabiltzaileen datuak kudeatzeko zerbitzua.
     */
    public Erabiltzaileak_controller(Erabiltzaileak_service erabiltzaileakService) {
        this.erabiltzaileakService = erabiltzaileakService;
    }

    /**
     * Erabiltzaile guztiak lortzen ditu, beharrezko eremuak soilik itzuliz.
     *
     * @return Erabiltzaileen zerrenda, non erabiltzaile bakoitza mapa (Map) batean gordetzen den.
     */
    @GetMapping
    public List<Map<String, String>> getAll() {
        return erabiltzaileakService.findAll()
                .stream()
                .map(user -> Map.of(
                        "username", user.getUsername(),
                        "pasahitza", user.getPasahitza(),
                        "rola", user.getRola()))
                .toList();
    }
}
