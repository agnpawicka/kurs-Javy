package obliczenia;

import main.Wyrażenie;
import wyjątki.WyjatekONP;
import wyjątki.ZaMałoArgumentów;

public class Sufit extends Funkcja1Arg {
    /**
     * Konstruktor wywołuje konstruktor klasy nadrzędnej {@link Funkcja1Arg}
     */
    public Sufit() {
        super();
    }

    /**
     @return  ceil(argument)
     */
    @Override
    public double oblicz()throws WyjatekONP {
        if(brakujace>0) throw new ZaMałoArgumentów();
        Wyrażenie.info("Obliczono wartość ceil(x)");
        return Math.ceil(argument);
    }
}
