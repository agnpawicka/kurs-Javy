package obliczenia;

import main.Wyrażenie;
import wyjątki.DzieleniePrzez0;
import wyjątki.WyjatekONP;
import wyjątki.ZaMałoArgumentów;

public class Dzielenie extends Funkcja2arg {
    /**
     * Konstruktor wywołuje konstruktor klasy nadrzędnej {@link Funkcja2arg}
     */
    public Dzielenie() {
        super();
    }

    /**
     @return  argument/argument2
     */
    @Override
    public double oblicz()throws WyjatekONP {
        if(brakujace>0) throw new ZaMałoArgumentów();
        if(argument2==0.0 || argument2==-0.0) throw  new DzieleniePrzez0();
        Wyrażenie.info("obliczono wartość /");
        return argument / argument2;
    }
}
