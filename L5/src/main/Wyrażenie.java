package main;

import narzędzia.Kolejka;
import narzędzia.Stos;
import obliczenia.*;
import wyjątki.*;

import java.io.IOException;
import java.util.logging.*;
/**
 * Klasa wyrażenie, klasa obliczająca wartość onp oraz konwertująca dane z wejścia do kolejki operacji*/
public class Wyrażenie {
    private static final Logger logger = Logger.getLogger(Wyrażenie.class.getName());
    public static void info(String message ){
        logger.log(Level.INFO, message);
    }
    public static void błąd(String message ){
        logger.log(Level.SEVERE, message);
    }
    public static void ostrzeżenie(String message ){
        logger.log(Level.WARNING, message);
    }
    private Kolejka kolejka; // kolejka symboli wyrażenia ONP (elementy typu Symbol)
    private Stos stos; // stos z wynikami pośrednimi obliczeń (elementy typu Double)

    public Wyrażenie(String onp) throws WyjatekONP {

        kolejka = new Kolejka<Symbol>();
        stos = new Stos();
        if (logger.getHandlers().length == 0) {
            try {
                Handler handler = new FileHandler("calc.log", true);
                handler.setFormatter(new SimpleFormatter());
                logger.addHandler(handler);
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.entering(Wyrażenie.class.getName(), "Wyrazenie");
        }

        int index = 0;
        onp = " " + onp;
        while (index < onp.length()) {
            int end = onp.indexOf(' ', index + 1);
            if (end == -1) end = onp.length();
            if (end - index == 1) {
                index = end;
                continue;
            }
            // System.out.println(onp.substring(index + 1, end));
            kolejka.push(Symbol.Typ(onp.substring(index + 1, end)));
            index = end;
        }
        logger.log(Level.INFO, "String na wejściu został przekonwertowanu do kolejki symboli");
    }
/**
 * @return wartość wyrażenia*/
    public Double oblicz() {
        try {
            logger.log(Level.INFO, "Rozpoczęto obliczanie wartości");
            while (!kolejka.empty()) {
                Symbol s = (Symbol) kolejka.pop();
                //System.out.println("kolejka out");
                if (s instanceof Przypisanie) {

                    Zmienna.dodaj(((Przypisanie) s).nazwa(), stos.pop());
                } else if (s instanceof Operand) {

                    if (s instanceof Zmienna) {
                        if (!kolejka.empty()) {
                            Symbol nas = (Symbol) kolejka.pop();
                            if (nas instanceof Przypisanie) {
                                Zmienna.dodaj(((Zmienna) s).getNazwa(), stos.pop());
                                stos.push(s.oblicz());
                            } else {
                                kolejka.pushFront(nas);
                                try {
                                    stos.push(s.oblicz());
                                } catch (WyjatekONP w) {
                                    błąd("nie można obliczyć wartości zmiennej");
                                    throw new BłędneWyrażenie();
                                }
                            }
                        } else {
                            try {
                                stos.push(s.oblicz());
                            } catch (WyjatekONP w) {
                                błąd("nie można obliczyć wartości zmiennej");
                                throw new BłędneWyrażenie();
                            }
                        }
                    }
                    else{
                        stos.push(s.oblicz());
                    }
                } else if (s instanceof Funkcja) {
                    Funkcja f = (Funkcja) s;
                    while (f.brakująceArgumenty() > 0) {
                        double arg = stos.pop();
                        System.out.println(arg);
                        f.dodajArgument(arg);
                    }


                    stos.push(f.oblicz());
                }
            }
            Double wyn = stos.pop();
            if (stos.empty()) {
                logger.log(Level.INFO, "Wynik: " + wyn);
                return wyn;
            } else {
                ZaDużoArgumentów w = new ZaDużoArgumentów();
                logger.log(Level.WARNING, "Błąd w obliczeniach " + w);
                return null;
            }
        } catch (
                WyjatekONP wyjatekONP) {
            logger.log(Level.WARNING, "Błąd w obliczeniach " + wyjatekONP.getMessage());
            wyjatekONP.printStackTrace();
        }
        return null;

    }

}
