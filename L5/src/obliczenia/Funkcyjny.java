package obliczenia;
import wyjątki.*;
public interface Funkcyjny extends Obliczalny {
    int arność ();
    int brakująceArgumenty ();
    void dodajArgument (double arg) throws WyjatekONP;
}
