package geometria;

public class Wektor {
    public final double dx;
    public final double dy;
    public Wektor(double dx, double dy){
        this.dx=dx;
        this.dy=dy;
    }
    //musi przyjmować dwa argumenty, gdyż metoda jest statyczna i nie ma dostępu do niestatycznych pól instancji klasy
    public static Wektor zlozWektory(Wektor w, Wektor v){
        return new Wektor(v.dx+w.dx, v.dy+w.dy);
    }
    public String toString(){
        return "["+dx+", "+dy+"]";
    }
}
