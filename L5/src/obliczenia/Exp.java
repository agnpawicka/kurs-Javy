package obliczenia;

import main.Wyrażenie;
import wyjątki.WyjatekONP;
import wyjątki.ZaMałoArgumentów;

public class Exp extends  Funkcja1Arg {

    /**
     * Konstruktor wywołuje konstruktor klasy nadrzędnej {@link Funkcja2arg}
     */
    public Exp(){
        super();
    }
    /**
     * @return e^argument
     * */
    @Override
    public double oblicz()throws WyjatekONP {
        if (brakujace > 0) throw new ZaMałoArgumentów();
        Wyrażenie.info("obliczono wartość exp");
        return Math.exp(argument);
    }
}
