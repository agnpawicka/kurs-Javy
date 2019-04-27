package geometria;

import static java.lang.Math.abs;

public class Prosta {
    public final double a;
    public final double b;
    public final double c;
    public static final double epsilon = 0.00000000001;

    public Prosta(double a, double b, double c) throws Exception {
        if (a == 0.0 && b == 0.0) throw new Exception("podane współczynniki nie definiują prostej\n");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static Prosta przesun(Wektor w, Prosta p) throws Exception{
        try {
            return new Prosta(p.a, p.b, p.c + p.a * w.dx + p.b * w.dy);
        } catch (Exception e) {
            throw e;
        }
    }

    public static boolean czyRownolegle(Prosta p, Prosta k) {
        if ((p.a == 0 && k.a == 0 && p.b == k.b) || (p.a != 0 && k.a != 0 && abs(p.b / p.a - k.b / k.a) < epsilon))
            return true;
        return false;
    }

    public static boolean czyProstopadle(Prosta p, Prosta k) {
        if ((p.b == 0 && k.a == 0) || (p.b != 0 && k.a != 0 && abs(p.a / p.b + k.b / k.a) < epsilon)) return true;
        return false;
    }

    public static Punkt punktPrzeciecia(Prosta p, Prosta k) throws Exception {
        if (czyRownolegle(p, k))
            throw new Exception("podane proste są równoległe:; nie można wyznaczyć ich punktu przecięcia\n");
        if (p.a == 0) {
            Prosta l = p;
            p = k;
            k = l;
        }
        double py = (p.c - k.c * p.a) / (k.a * p.b - p.a * k.b);
        double px = -(p.b * py + p.c) / p.a;
        return (new Punkt(px, py));
    }

    public String toString() {
        return a + "x+ " + b + "y+ " + c + "=0";
    }
}
