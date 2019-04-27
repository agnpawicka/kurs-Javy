package obliczenia;


import main.Wyrażenie;
import wyjątki.FunkcjaNieokreślona;
import wyjątki.WyjatekONP;
import wyjątki.ZaMałoArgumentów;

public class Arctan extends Funkcja1Arg {
    /**
     * Konstruktor wywołuje konstruktor klasy nadrzędnej {@link Funkcja1Arg}
     */
    public Arctan() {
        super();
    }

    /**
     @return  arctan(argument)
     */
    @Override
    public double oblicz() throws WyjatekONP {
        if(brakujace>0){
            throw new ZaMałoArgumentów();
        }
        if((argument*2/Math.PI)-Math.floor((argument*2/Math.PI))<Funkcja.epsilon) throw new FunkcjaNieokreślona();
        Wyrażenie.info("obliczono wartość atan");
        return Math.atan(argument);
    }


}



