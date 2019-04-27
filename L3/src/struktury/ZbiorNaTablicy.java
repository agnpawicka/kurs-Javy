package struktury;

/**
 * Klasa ZbiorNaTablicy jest klasą do przechowywania obiektów typu {@link Para} w tablicy statycznej.
 */
public class ZbiorNaTablicy extends Zbior {
    /**
     * tablica przechowująca zbiór
     */
    protected Para[] tablica;

    /**
     * Konstruktor klasy, tworzy tablicę.
     *
     * @param rozmiar Maksymalba liczba przechowywanych elementów
     */
    public ZbiorNaTablicy(int rozmiar)throws IllegalArgumentException {
        if(rozmiar<2) throw new IllegalArgumentException();
        przechowywane = 0;
        this.rozmiar = rozmiar;
        tablica = new Para[rozmiar];
    }

    @Override
    public Para szukaj(String k) {
        for (int i = 0; i < rozmiar; i++) if (tablica[i].equals(k)) return tablica[i];
        throw new IllegalArgumentException();
    }

    @Override
    public void wstaw(Para p) throws Exception {
        if (przechowywane < rozmiar) {
            tablica[przechowywane] = p;
            przechowywane++;
        } else throw new Exception("Za mała tablica\n");
    }

    @Override
    public double czytaj(String k) {
        try {
            return szukaj(k).getWartosc();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void ustaw(Para p) throws Exception {
        try {
            szukaj(p.klucz).setWartosc(p.getWartosc());
        } catch (Exception e) {
            try {
                wstaw(p);
            } catch (Exception ex) {
                throw ex;
            }
        }
    }

    @Override
    public void czysc() {
        for (int i = 0; i < przechowywane; i++) tablica[i] = null;
        przechowywane = 0;
    }
}
