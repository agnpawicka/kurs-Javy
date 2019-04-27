package struktury;

/**
 * Klasa Para, służy do przechowywania par typu <String, double>, jako klucz oraz wartość
 */
public class Para {
    public final String klucz;
    private double wartosc;

    /**
     * Konstruktor klasy, ustawia klucz oraz wartość
     *
     * @throws IllegalArgumentException podany klucz nie może byś wskaźnikiem null ani słowem pustym
     */
    public Para(String klucz, double wartosc) throws IllegalArgumentException {
        if (klucz == null || klucz == "") throw new IllegalArgumentException();
        this.klucz = klucz;
        this.wartosc = wartosc;
    }

    /**
     * Getter wartości
     */
    public double getWartosc() {
        return wartosc;
    }

    /**
     * Setter wartości
     */
    public void setWartosc(double wartosc) {
        this.wartosc = wartosc;
    }

    /**
     * metoda udostępniająca informacje o obiekcie w postaci słownej
     */
    public String toString() {
        return klucz + " ---> " + wartosc + "\n";
    }

    /**
     * metoda sprawdzająca równość instancji obiektu z parametrem
     */
    public boolean equals(Object o) {
        return (o.equals(this.klucz) || o.equals(this));
    }

}
