package struktury;

/**
 * Klasa ZbiorNaTablicy jest klasą do przechowywania obiektów typu {@link Para} w tablicy dynamicznej.
 */
public class ZbiorNaTablicyDynamicznej extends ZbiorNaTablicy {

    /**
     * Konstruktor klasy, tworzy tablicę.
     */
    public ZbiorNaTablicyDynamicznej() {
        super(2);
    }


    @Override
    public void wstaw(Para p) {
        if (przechowywane < rozmiar) {
            tablica[przechowywane] = p;
            przechowywane++;
        } else {
            Para[] nowaTablica = new Para[2 * rozmiar];
            System.arraycopy(tablica, 0, nowaTablica, 0, przechowywane);
            tablica = nowaTablica;
            rozmiar *= 2;
            wstaw(p);
        }
    }


    @Override
    public void czysc() {
        tablica = new Para[2];
        przechowywane = 0;
    }
}
