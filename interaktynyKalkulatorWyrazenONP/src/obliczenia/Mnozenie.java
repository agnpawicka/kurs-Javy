package obliczenia;

import main.Wyrażenie;
import wyjątki.DzieleniePrzez0;
import wyjątki.WyjatekONP;
import wyjątki.ZaMałoArgumentów;

public class Mnozenie extends Funkcja2arg {
    /**
     * Konstruktor wywołuje konstruktor klasy nadrzędnej {@link Funkcja2arg}
     */
    public Mnozenie() {
        super();
    }

    /**
     @return  argument*argument2
     */
    @Override
    public double oblicz()throws WyjatekONP {
        if(brakujace>0) throw new ZaMałoArgumentów();
        Wyrażenie.info("Obliczono wartość *");
        return argument * argument2;
    }
}