package geometria;

public class Odcinek {
    private Punkt a;
    private Punkt b;

    public Odcinek(Punkt a, Punkt b)throws Exception{
        if(a==b) throw new Exception("podano dwa jednakowe punkty: nie można zbudować odcinka\n");
        this.a=a;
        this.b=b;
    }
    public void przesun(Wektor w){
        a.przesun(w);
        b.przesun(w);
    }
    public void obroc(Punkt p, double kat){
        a.obroc(p, kat);
        b.obroc(p, kat);
    }
    public void odbij(Prosta p){
        a.odbij(p);
        b.odbij(p);
    }

    public String toString() {
        return a.toString() + "<->" + b.toString();
    }
}
