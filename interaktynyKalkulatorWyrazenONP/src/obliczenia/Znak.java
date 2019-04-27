package obliczenia;

import main.Wyrażenie;
import wyjątki.WyjatekONP;
import wyjątki.ZaMałoArgumentów;

public class Znak extends Funkcja1Arg {
    /**
     * Konstruktor wywołuje konstruktor klasy nadrzędnej {@link Funkcja1Arg}
     */
    public Znak() {
        super();
    }

    /**
     @return  sign(argument)
     */
    @Override
    public double oblicz()throws WyjatekONP {
        if(brakujace>0) throw new ZaMałoArgumentów();
        Wyrażenie.info("Obliczono wartość sign(x)");
        return Math.signum(argument);
    }
}