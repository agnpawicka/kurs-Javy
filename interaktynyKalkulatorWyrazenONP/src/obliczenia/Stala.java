package obliczenia;

import main.Wyrażenie;

public class Stala extends Funkcja {
    private final double wartosc;
    private final String nazwa;

    /**
     * Konstruktor przyjmuje w argumencie łańcuch znaków - nazwę stałej, wartość przypisuje w zależości od nazwy
     */
    public Stala(String nazwa) {
        Wyrażenie.info("Konstrukcja nowej stałej");
        this.nazwa = nazwa;
        switch (nazwa) {
            case "pi":
            case "Pi":
            case "PI":
                wartosc = Math.PI;
                break;
            case "fi":
            case "Fi":
            case "FI":
            case "phi":
            case "Phi":
            case "PHI":
                wartosc = 1.0 + Math.sqrt(5.0) / 2.0;
                break;
            case "e":
            case "E":
                wartosc = 2.71828182846;
                break;
            default:
                wartosc = 0.0;
                break;
        }
    }

    /**
     * @return wartość stałej z {@link Math}
     */
    @Override
    public double oblicz() {
        return wartosc;
    }

}
