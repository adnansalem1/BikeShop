package BikeShop;

public class Anzeige {
    String name;
    String beschreibung;
    double preis;

    public Anzeige(String name, String beschreibung, double preis){
        this.name = name;
        this.beschreibung = beschreibung;
        this.preis = preis;
    }
    public String getName() {
        return name;
    }
    public String getBeschreibung() {
        return beschreibung;
    }
    public double getPreis() {
        return preis;
    }
}
