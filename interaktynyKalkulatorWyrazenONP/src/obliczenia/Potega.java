package obliczenia;

import main.Wyrażenie;
import wyjątki.DzieleniePrzez0;
import wyjątki.WyjatekONP;
import wyjątki.ZaMałoArgumentów;

public class Potega extends Funkcja2arg {
    /**
     * Konstruktor wywołuje konstruktor klasy nadrzędnej {@link Funkcja2arg}
     */
    public  Potega() {
        super();
    }

    /**
     @return  argument^argument2
     */
    @Override
    public double oblicz()throws WyjatekONP {
        if(brakujace>0) throw new ZaMałoArgumentów();
        Wyrażenie.info("Obliczono wartość a^b");
        return Math.pow(argument2, argument);
    }
}
