package obliczenia;

import main.Wyrażenie;
import wyjątki.WyjatekONP;
import wyjątki.ZaMałoArgumentów;

public class Maksimum extends Funkcja2arg {
    /**
     * Konstruktor wywołuje konstruktor klasy nadrzędnej {@link Funkcja2arg}
     */
    public Maksimum(){
        super();
    }
    /**
     * @return max(argument, argument2)*/
    @Override
    public double oblicz()throws WyjatekONP {
        if (brakujace > 0) throw new ZaMałoArgumentów();
        Wyrażenie.info("Obliczono wartość max");
        return Math.max(argument, argument2);
    }
}
