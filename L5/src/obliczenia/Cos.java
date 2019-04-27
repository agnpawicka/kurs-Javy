package obliczenia;

import main.Wyrażenie;
import wyjątki.FunkcjaNieokreślona;
import wyjątki.WyjatekONP;
import wyjątki.ZaMałoArgumentów;

public class Cos extends Funkcja1Arg {
    /**
     * Konstruktor wywołuje konstruktor klasy nadrzędnej {@link Funkcja1Arg}
     */
    public Cos() {
        super();
    }

    /**
     *@return  cos(argument)
     */
    @Override
    public double oblicz() throws WyjatekONP {
        if(brakujace>0) throw new ZaMałoArgumentów();
        Wyrażenie.info("obliczono wartość cos");
        return Math.cos(argument);
    }


}



