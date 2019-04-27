package geometria;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Punkt {
    private double x;
    private double y;


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Punkt(double wspX, double wspY) {
        x = wspX;
        y = wspY;
    }

    public void przesun(Wektor w) {
        x += w.dx;
        y += w.dy;
    }

    public void obroc(Punkt p, double kat) {
        double x0 = x - p.x;
        double y0 = y - p.y;
        //z macierzy obrotu znanej z algebry
        x = cos(kat) * x0 - sin(kat) * y0 + p.x;
        y = sin(kat) * x0 + cos(kat) * y0 + p.y;

    }

    public void odbij(Prosta p) {
        //d - trzeci współczynnik równania ogólnego prostej prostopadłej do p przechodzącej przez punkt
        double d = p.b * x - p.a * y;
        double x0;
        double y0;
        if (p.b == 0) {//jeśli wyznaczane równania nie są pprawne przez dzielenie przez  0
                y0=-d/p.a;
                x0=(-2*p.c-p.a*x)/p.a;
        } else {

            // szukany punkt : x=(Ay+D)/B y=-B*(Ax+By+2c+Ad/b)/(A^2+B^2)
             y0 = -p.b * (p.a * x + p.b * y + 2 * p.c + p.a * d / p.b) / (p.a * p.a + p.b * p.b);
             x0 = (p.a * y0 + d) / p.b;
            x = x0;
            y = y0;
        }
        x=x0;
        y=y0;
    }
    public String toString(){
        return "("+x+", "+y+")";
    }
}
