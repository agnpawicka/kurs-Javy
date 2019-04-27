package obliczenia;


import main.Wyrażenie;

public class Liczba extends Operand {
    private final double wartosc;

    /**
     * Konstruktor przpisuje wartość.
     */
    public Liczba(double wartosc) {
        this.wartosc = wartosc;
        Wyrażenie.info("Konstrukcja nowej liczby");
    }

    /**
     * @return wartość
     */
    @Override
    public double oblicz() {
        Wyrażenie.info("Obliczono wartość liczby");
        return wartosc;
    }

}
