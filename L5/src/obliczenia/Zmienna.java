package obliczenia;

import narzędzia.Zbiór;
import struktury.Para;
import struktury.ZbiorNaTablicyDynamicznej;
import wyjątki.WyjatekONP;

import java.util.TreeMap;

public class Zmienna extends Operand {
   private static Zbiór zbiór=new Zbiór();
   private  String nazwa;
   public Zmienna(String nazwa){
       this.nazwa=nazwa;
   }
   public String getNazwa(){
       return  nazwa;
   }
    public static void czysc(){
        zbiór=new Zbiór();
    }
    public static void dodaj(String a, Double b){

        zbiór.dodaj(a, b);
    }
    public static void usuń(String a){
        zbiór.usuń(a);
    }
    @Override
    public double oblicz() throws  WyjatekONP{
       try{
           return zbiór.znajdz(nazwa);
       }catch (WyjatekONP w){
           throw w;
       }
    }
}
