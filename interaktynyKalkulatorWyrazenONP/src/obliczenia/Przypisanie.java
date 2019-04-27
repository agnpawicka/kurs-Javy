package obliczenia;

public class Przypisanie extends Symbol {
    private String zm="";
    private double war=0.0;
    public Przypisanie(){

    }
    public void dodajNazwe(String a){
        zm=a;
    }
    public String nazwa(){
        return zm;
    }
    public void dodajWart(double a){
        war=a;
    }
    public double oblicz(){
        return war;
    }
}
