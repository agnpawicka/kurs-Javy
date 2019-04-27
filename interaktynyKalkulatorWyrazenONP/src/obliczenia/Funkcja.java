package obliczenia;

import wyjątki.WyjatekONP;
/**
 * Klasa funkcja implementująca ifteerfejs Funkcyjny*/
public class Funkcja extends Symbol implements Funkcyjny {
    protected static double epsilon=0.0000000001;
    protected int arn=0;
    /**
     * @return  arność funkcji*/
    public int arność(){
        return arn;
    }
    protected int brakujace;
    /**
     * @return liczba brakujących argumentów*/
    public int brakująceArgumenty(){
        return brakujace;
    }/**
     Metoda pozwalająca dodać argument*/
    public void dodajArgument(double arg) throws WyjatekONP {
       if(brakujace==0) throw new WyjatekONP();

    }

    public  double oblicz() throws WyjatekONP{
        return 0.0;
    }
    public Funkcja(){
        brakujace=arn;
    }
}
