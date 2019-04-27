package obliczenia;

import main.Wyrażenie;
import wyjątki.DzieleniePrzez0;
import wyjątki.FunkcjaNieokreślona;
import wyjątki.WyjatekONP;
import wyjątki.ZaMałoArgumentów;

public class Logarytm extends Funkcja2arg {
    /**
     * Konstruktor wywołuje konstruktor klasy nadrzędnej {@link Funkcja2arg}
     */
    public Logarytm() {
        super();
    }
    /**
     * @return log(argument, argument2), */
    @Override
    public double oblicz()throws WyjatekONP {
        if (brakujace > 0) throw new ZaMałoArgumentów();
        if(argument<0.0 || argument2<0.0) throw new FunkcjaNieokreślona();
        if(argument==1.0) throw new DzieleniePrzez0();
        Wyrażenie.info("Obliczono wartość lOG");
        return Math.log(argument2)/Math.log(argument);
    }
}
