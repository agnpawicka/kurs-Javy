package obliczenia;

import main.Wyrażenie;
import wyjątki.WyjatekONP;
import wyjątki.ZaDużoArgumentów;
import wyjątki.ZaMałoArgumentów;
/**
 * Klasa dziedzicząca po klasie Funkcja*/
public class Funkcja2arg extends Funkcja1Arg {
    protected double argument2;
    /**Konstruktor przypisuje arność oraz liczbę brakujących argumentów*/
    public Funkcja2arg(){
        arn=2;
        brakujace=2;
        Wyrażenie.info("Konstrukcja nowej funkcji dwuargumentowej");
    }



    @Override
    public void dodajArgument(double arg) throws WyjatekONP {
        if(brakujace==0) throw new ZaDużoArgumentów();
        if(brakujace==1)
            argument2=arg;
        else argument=arg;
        brakujace--;

    }
    @Override
    public double oblicz() throws WyjatekONP{
        if(brakujace>0) throw new ZaMałoArgumentów();
        return argument;
    }
}