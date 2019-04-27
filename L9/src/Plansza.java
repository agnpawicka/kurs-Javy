import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import static java.lang.Thread.sleep;

public class Plansza extends JFrame {
    private int N;
    private int M;
    private long dzieciZPrezentami;
    private int mikolajX = 0, mikolajY = 0;
    private int[] dzieciX = new int[10];
    private int[] dzieciY = new int[10];
    private int[][] plansza = new int[26][36];
    private Mikolaj mikolaj;
    private Dzieciak[] dzieciaki;
    private BufferedImage mikolajObraz;
    private BufferedImage[] dzieckoObraz = new BufferedImage[10];
    private BufferedImage spiace;
    private BufferedImage prezent;
    private Gra gra;
    private boolean odswiezanie;

    public boolean getOdswiezanie() {
        return odswiezanie;
    }

    public synchronized void ustawPozycje(int kt, int x, int y) {
        if (plansza[y % N][x] == 0) {
            plansza[dzieciY[kt] % N][dzieciX[kt]] = 0;
            dzieciX[kt] = x;
            dzieciY[kt] = y;
            plansza[y % N][x] = kt + 1;
        }

    }

    public synchronized int ktoNaPozycji(int x, int y) {
        return plansza[y % N][x] - 1;
    }


    private KeyAdapter klawisze = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent ev) {
            int dz;
            switch (ev.getKeyCode()) {
                case KeyEvent.VK_DOWN:

                    switch (gra.mozliwyRuchMikolajem(ktoNaPozycji(mikolajX, (mikolajY + 1) % N))) {

                        case 0:
                            zakoncz(0);
                            break;
                        case 2:
                            mikolaj.ruchPionowy(1);
                        default:
                            break;
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    switch (gra.mozliwyRuchMikolajem(ktoNaPozycji((mikolajX + M - 1) % M, mikolajY))) {

                        case 0:
                            zakoncz(0);
                            break;
                        case 2:
                            mikolaj.ruchPoziomy(-1);
                        default:
                            break;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    switch (gra.mozliwyRuchMikolajem(ktoNaPozycji((mikolajX + 1) % M, mikolajY))) {
                        case 0:
                            zakoncz(0);
                            break;
                        case 2:
                            mikolaj.ruchPoziomy(1);
                        default:
                            break;
                    }

                    break;
                case KeyEvent.VK_UP:
                    switch (gra.mozliwyRuchMikolajem(ktoNaPozycji(mikolajX, (mikolajY + N - 1) % N))) {
                        case 0:
                            zakoncz(0);
                            break;
                        case 2:
                            mikolaj.ruchPionowy(-1);
                        default:
                            break;
                    }
                    break;
                case KeyEvent.VK_SPACE:
                    dz = ktoNaPozycji(mikolajX, (mikolajY + 1) % N);
                    if (gra.moznaDacPrezent(dz)) break;
                    dz = ktoNaPozycji(mikolajX, (mikolajY + N - 1) % N);
                    if (gra.moznaDacPrezent(dz)) break;
                    dz = ktoNaPozycji((mikolajX + 1) % M, mikolajY);
                    if (gra.moznaDacPrezent(dz)) break;
                    dz = ktoNaPozycji((mikolajX + M - 1) % M, mikolajY);
                    if (gra.moznaDacPrezent(dz)) break;
                    break;
                default:
                    break;
            }
        }
    };


    private void zakoncz(int wynik) {
        try {
            sleep(500);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        setVisible(false);
        gra.zakoncz(wynik);
    }

    public Plansza(int n, int m, Mikolaj mikolaj, Dzieciak[] dzieciaki, Gra gra) {
        this.gra = gra;
        N = n;
        M = m;
        dzieciZPrezentami = 0;
        this.dzieciaki = dzieciaki;
        this.mikolaj = mikolaj;
        try {
            mikolajObraz = ImageIO.read(getClass().getResource("/mikolaj.png"));
            for (int i = 0; i < 10; i++) {
                dzieckoObraz[i] = ImageIO.read(getClass().getResource("/dziecko0.png"));
            }
            spiace = ImageIO.read(getClass().getResource("/zzz.png"));
            prezent = ImageIO.read(getClass().getResource("/prezent.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        setLocationRelativeTo(null);
        setTitle("GRA");
        setPreferredSize(new Dimension(30 * M, 30 * (N + 1)));
        setSize(new Dimension(30 * M, 30 * (N + 1)));
        setBackground(Color.gray);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {

                gra.zapisz();
            }
        });
        addKeyListener(klawisze);
        setVisible(true);
    }


    @Override
    public void paint(Graphics gr) {
        gr.setColor(Color.BLACK);
        mikolajX = mikolaj.getX();
        mikolajY = mikolaj.getY();
        for (int i = 0; i < 10; i++) {
            gr.drawImage(dzieckoObraz[i], dzieciX[i] * 30, dzieciY[i] * 30, null);
        }
        gr.drawImage(mikolajObraz, mikolajX * 30, mikolajY * 30, null);


    }

    public void odswiez() {
        odswiezanie = true;
        Graphics gr = getGraphics();
        gr.clearRect(0, 0, 35 * 30, 26 * 30);
        mikolajX = mikolaj.getX();
        mikolajY = mikolaj.getY();
        gr.drawImage(mikolajObraz, mikolajX * 30, mikolajY * 30, null);

        for (int i = 0; i < 10; i++) {
            if (dzieciaki[i].czyGoni() == 0) {
                gr.drawImage(spiace, dzieciX[i] * 30, dzieciY[i] * 30, null);
            } else if (dzieciaki[i].czyGoni() == 1) {
                gr.drawImage(prezent, dzieciX[i] * 30, dzieciY[i] * 30, null);
                dzieciZPrezentami |= (1 << i);
                if (dzieciZPrezentami == (0x3ff)) {
                    zakoncz(1);
                }
            } else {
                 gr.drawImage(dzieckoObraz[i], dzieciX[i] * 30, dzieciY[i] * 30, null);
                if (Math.abs((dzieciX[i] - mikolajX) % M) + Math.abs((dzieciY[i] - mikolajY) % N) <= 1) {
                    zakoncz(0);
                }
            }
            dzieciaki[i].setRuszylSie(false);
        }

        update(gr);
        odswiezanie = false;
    }
}
