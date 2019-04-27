import obliczenia.*;

public class Main {
    public static void main(String[] args){
        Zmienna.dodajZmienna("x", 1.0);
        Zmienna.dodajZmienna("y", 1.0);
        Zmienna.dodajZmienna("z", 1.0);
        //3+5
        Wyrazenie w1=new Dodawanie(new Liczba(3.0),new Liczba(5.0));
        System.out.println(w1.toString()+"="+w1.oblicz());
        //2+x*7
        Wyrazenie w2=new Dodawanie(
                new Liczba(2.0),
                new Mnozenie(
                        new Zmienna("x"),
                        new Liczba(7.0)
                )
        );
        System.out.println(w2.toString()+"="+w2.oblicz());
        //(3*11-1)/(7+5)
        Wyrazenie w3=new Dzielenie(
                new Odejmowanie(
                        new Mnozenie(
                                new Liczba(3.0),
                                new Liczba(11.0)),
                        new Liczba(1.0)),
                new Dodawanie(
                        new Liczba(7.0),
                        new Liczba(5.0)
                ));
        System.out.println(w3.toString()+"="+w3.oblicz());

        //arctan(((x+13)*x)/2)
        Wyrazenie w4=new Dzielenie(
                new Mnozenie(
                        new Dodawanie(
                                new Zmienna("x"),
                                new Liczba(13)),
                        new Zmienna("x")),
                new Liczba(2.0));
        System.out.println(w4.toString()+"="+w4.oblicz());

        //pow(2,5)+x*log(2,y)
        Wyrazenie w5=new Dodawanie(
                new Potega(
                        new Liczba(2.0),
                        new Liczba(5.0)),
                new Mnozenie(
                        new Zmienna("x"),
                        new Logarytm(
                                new Liczba(2.0),
                                new Zmienna("y"))));
        System.out.println(w5.toString()+"="+w5.oblicz());
        System.out.println("Suma poprzednich: "+Wyrazenie.suma(w1, w2, w3, w4, w5));
        System.out.println("Iloczyn poprzednich: "+Wyrazenie.iloczyn(w1, w2, w3, w4, w5));
        System.out.println("czy w5 równe 32.0? "+new Liczba(32.0).equals(w5));
        System.out.println("czy w3 równe 32.0? "+new Liczba(32.0).equals(w3));
    }
}
