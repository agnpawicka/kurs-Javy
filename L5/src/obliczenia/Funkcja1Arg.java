package obliczenia;

import main.Wyrażenie;
import wyjątki.WyjatekONP;
import wyjątki.ZaDużoArgumentów;
import wyjątki.ZaMałoArgumentów;
/**
 * Klasa dziedzicząca po klasie Funkcja*/
public class Funkcja1Arg extends Funkcja {
   protected double argument;
/**Konstruktor przypisuje arność oraz liczbę brakujących argumentów*/
    public Funkcja1Arg(){
        arn=1;
        brakujace=arn;
        Wyrażenie.info("Konstrukcja nowej funkcji jednoargumentowej");
    }
    @Override
    public void dodajArgument(double arg) throws WyjatekONP {
        if(brakujace==0) throw new ZaDużoArgumentów();
        brakujace--;
        argument=arg;
    }
    @Override
    public double oblicz() throws WyjatekONP{
        if(brakujace>0) throw new ZaMałoArgumentów();
        return argument;
    }

}
