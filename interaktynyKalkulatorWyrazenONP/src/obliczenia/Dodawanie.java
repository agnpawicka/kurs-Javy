package obliczenia;

import main.Wyrażenie;
import wyjątki.WyjatekONP;
import wyjątki.ZaDużoArgumentów;
import wyjątki.ZaMałoArgumentów;

public class Dodawanie extends Funkcja2arg {
    /**
     * Konstruktor wywołuje konstruktor klasy nadrzędnej {@link Funkcja2arg}
     */
    public Dodawanie() {
        super();
    }
    @Override
    public void dodajArgument(double arg) throws WyjatekONP {

        if(brakujace==0) throw new ZaDużoArgumentów();

        if(brakujace==1)
            argument2=arg;
        else argument=arg;
        brakujace--;

    }
    /**
     @return  argument+argument2
     */
    @Override
    public double oblicz()throws WyjatekONP {
        if(brakujace>0) throw new ZaMałoArgumentów();
        Wyrażenie.info("obliczono wartość +");
        return argument + argument2;
    }

}