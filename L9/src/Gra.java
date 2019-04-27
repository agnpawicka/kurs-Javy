import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Timer;

public class Gra {
    private Plansza plansza;
    private Mikolaj mikolaj;
    private java.util.Timer timer;
    private Menu menu;
    private int N = 20, M = 35;
    private Dzieciak[] dzieciaki;

    public Gra(boolean wznow, Menu menu) {
        if (!wznow) new Gra(menu); //???
        else {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("data.bin"))) {
                boolean saved = (Boolean) inputStream.readObject();
                if (!saved) {
                   // System.out.println(saved+" zapisano!");
                    new Gra(menu);
                    return;
                }
                this.menu = menu;
                dzieciaki = (Dzieciak[]) inputStream.readObject();
                mikolaj = (Mikolaj) inputStream.readObject();


                plansza = new Plansza(N, M, mikolaj, dzieciaki, this);
                for (int i = 0; i < 10; i++) dzieciaki[i].setPlansza(plansza);
                for (int i = 0; i < 10; i++) {
                    dzieciaki[i].start();
                }
                timer = new Timer();
                timer.schedule(new Zadanie(plansza), 50, 50);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public Gra(Menu menu) {
        mikolaj = new Mikolaj(N, M);
        this.menu = menu;
        dzieciaki = new Dzieciak[10];
        for (int i = 0; i < 10; i++) dzieciaki[i] = new Dzieciak(N, M, mikolaj, i);
        plansza = new Plansza(N, M, mikolaj, dzieciaki, this);
        for (int i = 0; i < 10; i++) dzieciaki[i].setPlansza(plansza);
        for (int i = 0; i < 10; i++) {
            dzieciaki[i].start();
        }
        timer = new Timer();
        timer.schedule(new Zadanie(plansza), 50, 50);

    }

    public int mozliwyRuchMikolajem(int dz) {

        if (dz >= 0) {
            if (dzieciaki[dz].czyGoni() == 2 && !dzieciaki[dz].getRuszylSie())
                return 0;
            return 1;
        }
        return 2;
    }

    public boolean moznaDacPrezent(int dz) {
        if (dz >= 0 && dzieciaki[dz].czyGoni() == 0) {
            dzieciaki[dz].dajPrezent();
            return true;
        }
        return false;
    }

    public void zakoncz(int wynik) {
        if(wynik!=5){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
            outputStream.writeObject(false);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }}
        plansza.dispose();
        mikolaj = null;
        // timer.purge();
        timer.cancel();
        Wynik wynik1;
        if (wynik <= 1)
             wynik1 = new Wynik(wynik);
        menu.zakoncz(wynik);
    }

    public void zapisz() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
            outputStream.writeObject(true);
            outputStream.writeObject(dzieciaki);
            outputStream.writeObject(mikolaj);
            zakoncz(5);
          //  System.out.println("zapisuje");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            zakoncz(2);
        }
    }
}
