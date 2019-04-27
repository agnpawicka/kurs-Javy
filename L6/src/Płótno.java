import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Płótno extends Canvas {
    private DaneDlaLabiryntu daneDlaLabiryntu;
    private int rozmiar;
    private BufferedImage badacz;
    public Płótno(DaneDlaLabiryntu daneDlaLabiryntu, int rozmiar){
        super();
        try{
            badacz=null;
            badacz= ImageIO.read(getClass().getResource("/eksplorator.gif"));

        }
        catch (Exception e){
            System.out.println("Wystąpił problem z wczytaniem animacji");
            e.printStackTrace();
            return;
        }
        this.daneDlaLabiryntu=daneDlaLabiryntu;
        this.rozmiar=rozmiar;

        setSize(400, 400);
        setBackground(Color.DARK_GRAY);
    }
    public void paint (Graphics g) {
        for(int i=0; i<rozmiar; i++){
            dodajŚcianęPoziomą(-1, i);
        }
        for(int i=0; i<rozmiar-1; i++){
            for (int j=0; j<rozmiar; j++) {
                if (!daneDlaLabiryntu.czyIstniejePrzejście(i, j, i+1, j)) {
                    dodajŚcianęPoziomą(i, j);
                }
            }
        }
        for(int i=0; i<rozmiar; i++){
            dodajŚcianęPoziomą(rozmiar-1, i);
        }
        //linie pionowe
        for(int i=0; i<rozmiar-1; i++){
            dodajŚcianęPionową(i, -1);
        }
        for(int i=0; i<rozmiar; i++){
            for (int j=0; j<rozmiar-1; j++) {
                if (!daneDlaLabiryntu.czyIstniejePrzejście(i, j, i, j+1)) {
                    dodajŚcianęPionową(i, j);
                }
            }
        }
        for(int i=1; i<rozmiar; i++){
            dodajŚcianęPionową(i, rozmiar-1);
        }
        przemieśćObraz( rozmiar-1, -1, rozmiar-1, 0);
    }
    public void dodajŚcianęPoziomą(int wiersz, int kolumna){
        //(kolumna, wiersz+1) ->(kolumna+1, wiersz+1)
        //lewy górny róg to ma być 0, 0, czyli pierwsza pozioma kreska to (0, 0)->(1, 0), a pionowa: (0, 0)->(0, 1);
        Graphics gr = getGraphics();
        gr.setColor(Color.WHITE);
        gr.drawLine((kolumna)*35+20, (wiersz+1)*35+20, (kolumna+1)*35+20, (wiersz+1)*35+20);
    }
    public void dodajŚcianęPionową(int wiersz, int kolumna){
        //(kolumna+1, wiersz) ->(kolumna+1, wiersz+1)
        //lewy górny róg to ma być 0, 0, czyli pierwsza pozioma kreska to (0, 0)->(1, 0), a pionowa: (0, 0)->(0, 1);
        Graphics gr = getGraphics();
        gr.setColor(Color.WHITE);
        gr.drawLine((kolumna+1)*35+20, (wiersz)*35+20, (kolumna+1)*35+20, (wiersz+1)*35+20);
    }
    public void przemieśćObraz( int wiersz1, int kolumna1, int wiersz2, int kolumna2){
        Graphics g = getGraphics();
        g.setColor(Color.GREEN);
        int deltaX=0;
        int deltaY=0;
        int szer=26;
        int wys=26;
        if(kolumna1!=kolumna2){
            szer+=35;
            if(kolumna1<kolumna2) deltaX=1;
            else deltaX=-1;
        }
        else {
            wys+=35;
            if(wiersz1<wiersz2) deltaY=1;
            else deltaY=-1;
        }
        for (int i=1; i<35; i++){
            g.clearRect( Math.min(kolumna1, kolumna2)*35+25,Math.min(wiersz1, wiersz2)*35+25, szer, wys);
            g.drawImage(badacz, kolumna1 * 35 + 25 + deltaX * i, (wiersz1) * 35 + 25 + deltaY * i, null);
            try            {
                Thread.sleep(15);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        g.clearRect( Math.min(kolumna1,kolumna2)*35+25, Math.min(wiersz1, wiersz2)*35+25,  szer ,wys);
        g.drawImage(badacz, kolumna2 * 35 + 25, (wiersz2) * 35 + 25, null);
    }
}
