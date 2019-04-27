package narzędzia;

import main.Wyrażenie;
import wyjątki.BłędneWyrażenie;
import wyjątki.PustyStos;
import wyjątki.WyjatekONP;

import java.util.ArrayDeque;
/**
 * Klasa implementuje stos*/
public class Stos   {
    private ArrayDeque<Double> stos;
    public Stos(){
        stos=new ArrayDeque<Double>();
    }
    public void push(double a){
        stos.addLast(a);
        //System.out.println("Dodałem do stosu "+stos.getLast());
    }
    public double pop() throws WyjatekONP {
        if(stos.isEmpty()) {
            Wyrażenie.ostrzeżenie("próba wzięcia elementu z pustego stosu");
            throw new PustyStos();
        }
       double x= stos.getLast();
       stos.removeLast();
       //System.out.println("tu stos, oddaję "+x);
       //stos.pop();
       return x;
    }
    public boolean empty(){
        return stos.isEmpty();
    }
}
