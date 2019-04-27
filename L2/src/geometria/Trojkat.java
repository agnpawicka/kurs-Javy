package geometria;

public class Trojkat {
    private Punkt a;
    private  Punkt b;
    private  Punkt c;
    public Trojkat(Punkt a, Punkt b, Punkt c) throws Exception{
        if(((a.getX()-b.getX()==b.getX()-c.getX()) && (a.getY()-b.getY()==b.getY()-c.getY()) ) ||
                ((a.getX()-b.getX()==c.getX()-b.getX()) && (a.getY()-b.getY()==c.getY()-b.getY()) ))throw  new  Exception("podane punkty są współliniowe: nie można skonstruować trójkąta\n");
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public void przesun(Wektor w){
        a.przesun(w);
        b.przesun(w);
        c.przesun(w);
    }
    public void obroc(Punkt p, double kat){
        a.obroc(p, kat);
        b.obroc(p, kat);
        c.obroc(p, kat);
    }
    public void odbij(Prosta p){
        a.odbij(p);
        b.odbij(p);
        c.odbij(p);
    }
    public String toString(){
        return "ABC= " + a.toString() + ", "+ b.toString() +", "+ c.toString();
    }
}
