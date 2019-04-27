package wyjątki;

public class WyjatekONP extends Exception {
    /**
     * Domyślna wiadoość wyjątku.
     */
    protected String message = "";

    public WyjatekONP() {
    }

    /**
     * Konstruktor.
     */
    public WyjatekONP(String message) {
        this.message = message;
    }

    /**
     * Metoda zwracająca wiadomość.
     */
    @Override
    public String getMessage() {
        return message;
    }
}
