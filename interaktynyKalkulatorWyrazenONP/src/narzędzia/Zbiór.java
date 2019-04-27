package narzędzia;

import wyjątki.NieznanySymbol;
import wyjątki.WyjatekONP;

import java.util.TreeMap;
/**
 * Klasa implementuje zbiór*/
public class Zbiór {
    private TreeMap<String, Double> zbiór;

    public Zbiór(){
        zbiór=new TreeMap<String, Double>();
    }
    public Double znajdz(String x)throws WyjatekONP {
        Double a= zbiór.get(x);
        if(a==null) throw new NieznanySymbol();
        return  a;
    }
    public void dodaj(String a, Double b){
        if(zbiór.containsKey(a)) zbiór.remove(a);

        zbiór.put(a, b);
    }
    public void usuń(String a){
        if(zbiór.containsKey(a)) zbiór.remove(a);
    }


}
