package eus.fpsanturtzilh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * {@link BackPeluApplication} Spring Boot aplikazioaren hasierako klasea da.
 * 
 * <p>Spring Boot-en aplikazioa abiarazteko konfigurazio eta inicializazio lanak egiten ditu.
 * Aplikazioaren hasierako funtzionalitatea SpringApplication.run() metodoak kudeatzen du, 
 * eta honen bidez aplikazioaren zerbitzua abian jartzen da.</p>
 * 
 * <p>Erabiltzaileak Swagger bidez aplikazioaren APIa ikusi eta probatu ahal izango du:
 * {@code http://localhost:8080/swagger-ui/index.html#/}</p>
 * 
 * @author [Zure Izena]
 * @since [Data]
 */
@SpringBootApplication
public class BackPeluApplication {

    /**
     * Aplikazioa abiarazten duen metodo nagusia.
     * @param args Komando-lerroko argumentuak.
     */
    public static void main(String[] args) {
        SpringApplication.run(BackPeluApplication.class, args);
        //Hau da Swagger: http://localhost:8080/swagger-ui/index.html#/
    }
}
