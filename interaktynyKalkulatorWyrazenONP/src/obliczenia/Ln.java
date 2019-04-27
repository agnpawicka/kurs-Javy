package obliczenia;

import main.Wyrażenie;
import wyjątki.FunkcjaNieokreślona;
import wyjątki.WyjatekONP;
import wyjątki.ZaMałoArgumentów;

public class Ln extends Funkcja1Arg {
    /**
     * Konstruktor wywołuje konstruktor klasy nadrzędnej {@link Funkcja2arg}
     */
    public Ln(){
        super();
    }
    /**
     * @return ln(argument)
     * */
    @Override
    public double oblicz()throws WyjatekONP {
        if (brakujace > 0) throw new ZaMałoArgumentów();
        if(argument<0.0 ) throw new FunkcjaNieokreślona();
        Wyrażenie.info("Obliczono wartość ln");
        return Math.log(argument);
    }
}
