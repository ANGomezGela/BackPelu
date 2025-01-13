package eus.fpsanturtzilh.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "erabiltzaileak")
public class Erabiltzaileak {
    @Id
    @Column(name = "username", length = 15, nullable = false)
    private String username; 

    @Column(name = "pasahitza", length = 100, nullable = false)
    private String pasahitza; 

    @Column(name = "rola", length = 2, nullable = false)
    private String rola; 

    @Column(name = "sortze_data")
    private LocalDateTime sortzeData; 

    @Column(name = "eguneratze_data")
    private LocalDateTime eguneratzeData; 

    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData; 

    public Erabiltzaileak() {
    }

    public Erabiltzaileak(String username, String pasahitza, String rola, LocalDateTime sortzeData, LocalDateTime eguneratzeData, LocalDateTime ezabatzeData) {
        this.username = username;
        this.pasahitza = pasahitza;
        this.rola = rola;
        this.sortzeData = sortzeData;
        this.eguneratzeData = eguneratzeData;
        this.ezabatzeData = ezabatzeData;
    }

    // Getters y Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasahitza() {
        return pasahitza;
    }

    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    public LocalDateTime getSortzeData() {
        return sortzeData;
    }

    public void setSortzeData(LocalDateTime sortzeData) {
        this.sortzeData = sortzeData;
    }

    public LocalDateTime getEguneratzeData() {
        return eguneratzeData;
    }

    public void setEguneratzeData(LocalDateTime eguneratzeData) {
        this.eguneratzeData = eguneratzeData;
    }

    public LocalDateTime getEzabatzeData() {
        return ezabatzeData;
    }

    public void setEzabatzeData(LocalDateTime ezabatzeData) {
        this.ezabatzeData = ezabatzeData;
    }

    @Override
    public String toString() {
        return "Erabiltzaileak{" +
                "username='" + username + '\'' +
                ", pasahitza='" + pasahitza + '\'' +
                ", rola='" + rola + '\'' +
                ", sortzeData=" + sortzeData +
                ", eguneratzeData=" + eguneratzeData +
                ", ezabatzeData=" + ezabatzeData +
                '}';
    }
}
