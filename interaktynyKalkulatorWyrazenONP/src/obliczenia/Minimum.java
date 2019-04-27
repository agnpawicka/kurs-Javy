package obliczenia;

import main.Wyrażenie;
import wyjątki.WyjatekONP;
import wyjątki.ZaMałoArgumentów;

public class Minimum extends Funkcja2arg {
    /**
     * Konstruktor wywołuje konstruktor klasy nadrzędnej {@link Funkcja2arg}
     */
    public Minimum(){
        super();
    }
    /**
     * @return min(argument, argument2)*/
    @Override
    public double oblicz()throws WyjatekONP {
        if (brakujace > 0) throw new ZaMałoArgumentów();
        Wyrażenie.info("Obliczono wartość min");
        return Math.min(argument, argument2);
    }
}
