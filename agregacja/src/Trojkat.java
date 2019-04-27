import javax.swing.*;

import static java.util.Collections.swap;

public class Trojkat {
    private double a, b, c;
    public Trojkat(double a, double b, double c){
        if(a>b+c || b>a+c || c>a+b) throw new IllegalArgumentException("Warunek trójkąta niespełniony");
            this.a=a;
            this.b=b;
            this.c=c;

    }
    public double getA(){
        return a;

    }
    public double getB(){
        return b;
    }
    public double getC(){
        return c;
    }
    public String toString(){
        return "("+a+"  "+b+"  "+c+")";
    }
    public Double obwod(){
        return new Double(a+b+c);
    }
    public boolean jestProstokatne(){
        double A=Math.max(a, Math.max(b, c));
        double B=b;
        double C=c;
        if(A==c)C=a;
        else if(A==b) B=a;
        return Math.abs(A*A-B*B-C*C)<0.000000001;

    }
    public Double pole(){
        double p=(a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}
