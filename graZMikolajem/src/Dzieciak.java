import java.io.Serializable;
import java.util.Random;

public class Dzieciak extends Thread implements Serializable {
    private int N, M;
    private int pozX;
    private int pozY;
    private int kt;
    private boolean spi;
    private boolean mamPrezent;
    private Mikolaj mikolaj;
    private int krokiZanimPojdeSpac;
    private int ileSpie;
    transient private  Plansza plansza;
    private boolean ruszylSie = false;

    public void setRuszylSie(boolean ruszylSie) {
        this.ruszylSie = ruszylSie;
    }

    public boolean getRuszylSie() {
        return ruszylSie;
    }

    public Dzieciak(int N, int M, Mikolaj mikolaj, int kt) {
        this.N = N;

        this.M = M;
        this.kt = kt;
        this.mikolaj = mikolaj;
        mamPrezent = false;
        Random rand = new Random();
        spi = false;
        pozX = Math.abs(rand.nextInt()) % M;
        pozY = kt * 2 + 1;
        if ((pozY == N / 2 + 1 || pozY == N / 2 - 1) && pozX == (M - 1) / 2) pozX = 2;

    }


    private boolean widzeMikolaja() {
        int a = (Math.abs(mikolaj.getX() - pozX)) % M;

        int b = (Math.abs(mikolaj.getY() - pozY)) % N;

        if (a + b <= 5) return true;

        return false;
    }

    public void dajPrezent() {
        mamPrezent = true;

    }

    public int czyGoni() {
        if (mamPrezent) return 1;
        if (spi) return 0;

        else return 2;
    }


    private void idzWLewo() {
        if (plansza.ktoNaPozycji((pozX + M - 1) % M, pozY) == -1)
            pozX += M - 1;
        pozX %= M;
        ruszylSie = true;
        plansza.ustawPozycje(kt, pozX, pozY);
    }

    private void idzWPrawo() {
        if (plansza.ktoNaPozycji((pozX + 1) % M, pozY) == -1)
            pozX++;
        pozX %= M;
        ruszylSie = true;
        plansza.ustawPozycje(kt, pozX, pozY);
    }

    private void idzWDol() {
        if (plansza.ktoNaPozycji(pozX, (pozY + 1) % N) == -1)
            pozY++;
        pozY %= N;
        if (pozY == 0) pozY = N;
        ruszylSie = true;
        plansza.ustawPozycje(kt, pozX, pozY);
    }

    private void idzWGore() {
        if (plansza.ktoNaPozycji(pozX, (pozY + N - 1) % N) == -1)
            pozY += N - 1;
        pozY %= N;
        if (pozY == 0) pozY = N;
        ruszylSie = true;
        plansza.ustawPozycje(kt, pozX, pozY);
    }
    public  void  setPlansza(Plansza pl){
        plansza=pl;
        plansza.ustawPozycje(kt, pozX, pozY);
    }

    @Override
    public void run() {
        super.run();
        Random random = new Random();
        while (!mamPrezent) {

            if(spi) spi=false;
            if (widzeMikolaja()) krokiZanimPojdeSpac = Math.abs(random.nextInt()) % 8 + 2;
            if (krokiZanimPojdeSpac > 0) {
                while (krokiZanimPojdeSpac > 0) {
                    if (Math.abs(mikolaj.getX() - pozX) > 10) {
                        if (mikolaj.getX() < pozX)
                            idzWPrawo();
                        else idzWLewo();

                    } else if (Math.abs(mikolaj.getX() - pozX) > Math.abs(mikolaj.getY() - pozY)) {
                        if (mikolaj.getX() > pozX) {
                            idzWPrawo();
                        } else idzWLewo();


                    } else if (Math.abs(mikolaj.getY() - pozY) > 10) {
                        if (mikolaj.getY() < pozY)
                            idzWDol();
                        else idzWGore();
                    } else {
                        if (mikolaj.getY() > pozY)
                            idzWDol();
                        else idzWGore();
                    }



                    krokiZanimPojdeSpac--;
                    try {
                        while (ruszylSie) {
                            Thread.sleep(100);
                        }
                        while (plansza.getOdswiezanie()) {

                            Thread.sleep(50);
                        }

                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                ileSpie = Math.abs(random.nextInt()) % 3 + 3;
                try {
                    spi = true;
                    Thread.sleep(ileSpie * 1000);//ileSpie to sekundy
                    spi = false;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else {
                int krok = Math.abs(random.nextInt()) % 4;
                switch (krok) {
                    case 0:
                        idzWDol();
                        break;
                    case 1:
                        idzWGore();
                        break;
                    case 2:
                        idzWLewo();
                        break;
                    default:
                        idzWPrawo();
                        break;
                }
            }
            try {
                sleep(1000);
            } catch (
                    Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }


}
