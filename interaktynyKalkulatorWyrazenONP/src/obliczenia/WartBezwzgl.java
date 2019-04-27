package obliczenia;

import main.Wyrażenie;
import wyjątki.WyjatekONP;
import wyjątki.ZaMałoArgumentów;

public class WartBezwzgl extends Funkcja1Arg {
    /**
     * Konstruktor wywołuje konstruktor klasy nadrzędnej {@link Funkcja1Arg}
     */
    public WartBezwzgl() {
        super();
    }

    /**
     @return  |argument|
     */
    @Override
    public double oblicz()throws WyjatekONP {
        if(brakujace>0) throw new ZaMałoArgumentów();
        Wyrażenie.info("Obliczono wartość |x|");
        return Math.abs(argument);
    }
}
