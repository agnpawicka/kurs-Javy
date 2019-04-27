package obliczenia;

import main.Wyrażenie;
import wyjątki.DzieleniePrzez0;
import wyjątki.WyjatekONP;
import wyjątki.ZaMałoArgumentów;

public class Przeciwienstwo extends Funkcja1Arg {
    /**
     * Konstruktor wywołuje konstruktor klasy nadrzędnej {@link Funkcja1Arg}
     */
    public Przeciwienstwo() {
        super();
    }

    /**
     @return  -argument
     */
    @Override
    public double oblicz()throws WyjatekONP {
        if(brakujace>0) throw new ZaMałoArgumentów();
        Wyrażenie.info("Obliczono wartość -x");
        return -argument;
    }


}
