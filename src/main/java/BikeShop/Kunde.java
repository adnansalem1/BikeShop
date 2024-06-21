package BikeShop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Kunde {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String adresse;
    private String telefonnummer;
    private double kontoGuthaben;

    public Kunde() {
    }

    public Kunde(String name, String email, String adresse, String telefonnummer, double kontoGuthaben) {
        this.name = name;
        this.email = email;
        this.adresse = adresse;
        this.telefonnummer = telefonnummer;
        this.kontoGuthaben = kontoGuthaben;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public double getKontoGuthaben() {
        return kontoGuthaben;
    }

    public void setKontoGuthaben(double kontoGuthaben) {
        this.kontoGuthaben = kontoGuthaben;
    }
}