package obliczenia;

public abstract class Symbol implements Obliczalny {

    public static Symbol Typ(String s){
        if(s.equals("+"))
            return new Dodawanie();
        if(s.equals("-"))
            return new Odejmowanie();
        if(s.equals("*"))
            return new Mnozenie();
        if(s.equals("/"))
            return new Dzielenie();

        try{
            double num = Double.parseDouble(s);
            return new Liczba(num);
        } catch (NumberFormatException e) {
        }

        if(s.equals("="))
            return new Przypisanie();
        if(s.equals("Pi")|| s.equals("E") || s.equals("Fi"))
            return new Stala(s);
        if(s.equals("Abs"))
            return new WartBezwzgl();
        if(s.equals("Acot"))
            return new Acos();
        if(s.equals("Atan"))
            return new Arctan();
        if(s.equals("Ceil"))
            return new Sufit();
        if(s.equals("Cos"))
            return new Cos();
        if(s.equals("Exp"))
            return new Exp();
        if(s.equals("Floor"))
            return new Podłoga();
        if(s.equals("Frac"))
            return new CzęśćUłamkowa();
        if(s.equals("Ln"))
            return new Ln();
        if(s.equals("Log"))
            return new Logarytm();
        if(s.equals("Max"))
            return new Maksimum();
        if(s.equals("Min"))
            return new Minimum();
        if(s.equals("Pow"))
            return new Potega();
        if(s.equals("Sgn"))
            return new Znak();
        if(s.equals("Sin"))
            return new Sin();
        return new Zmienna(s);
    }
}
