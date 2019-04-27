package narzędzia;

import main.Wyrażenie;
import obliczenia.Liczba;
import obliczenia.Operand;
import obliczenia.*;
import wyjątki.PustaKolejka;
import wyjątki.WyjatekONP;

import java.util.ArrayDeque;
/**
 * Klasa implementuje kolejkę*/
public class Kolejka <T>  {
    private ArrayDeque<T> kolejka;
    public Kolejka(){
        kolejka=new ArrayDeque<T>();
    }
    public void push(T a){
        this.kolejka.addLast(a);
        /*System.out.println("Dodaję nowe do kolejki, teraz czyliczba, czyostatni liczba, czypierwszyliczba");
        System.out.println(a instanceof Liczba);
        System.out.println(kolejka.getLast() instanceof Liczba);
        System.out.println(kolejka.getFirst() instanceof Liczba);*/

    }
    public void pushFront(T a) {
        this.kolejka.addFirst(a);
    }
    public T pop() throws WyjatekONP {
        if(kolejka.isEmpty()){
            Wyrażenie.ostrzeżenie("próba wzięcia elementu z pustego stosu");
            throw new PustaKolejka();
        }
       T a =kolejka.getFirst();
       kolejka.removeFirst();
       /*System.out.println("kolejka pop");
        System.out.println(a instanceof Liczba);
        System.out.println(a instanceof Operand);
        System.out.println(a instanceof Symbol);*/
       return a;
    }
    public boolean empty(){
        return kolejka.isEmpty();
    }

}
