package obliczenia;

import main.Wyrażenie;
import wyjątki.*;

public class Acos extends Funkcja1Arg {
    /**
     * Konstruktor wywołuje konstruktor klasy nadrzędnej {@link Funkcja1Arg}
     */
    public Acos(){
        super();
    }
    /**
     @return  arccos(argument)
     */
    @Override
    public double oblicz() throws WyjatekONP{
        if(brakujace>0) throw new ZaMałoArgumentów();
        if(argument<-1 || argument>1) throw  new  FunkcjaNieokreślona();
        Wyrażenie.info("obliczono wartość acos");
        return Math.acos(argument);
    }

}
