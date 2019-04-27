package obliczenia;

import main.Wyrażenie;
import wyjątki.DzieleniePrzez0;
import wyjątki.WyjatekONP;
import wyjątki.ZaMałoArgumentów;

public class Podłoga extends Funkcja1Arg {
    /**
     * Konstruktor wywołuje konstruktor klasy nadrzędnej {@link Funkcja1Arg}
     */
    public Podłoga() {
        super();
    }

    /**
     @return  1/argument
     */
    @Override
    public double oblicz()throws WyjatekONP {
        if(brakujace>0) throw new ZaMałoArgumentów();
        if(argument==0.0) throw new DzieleniePrzez0();
        Wyrażenie.info("Obliczono wartość floor(x)");
        return Math.floor(argument);
    }
}
