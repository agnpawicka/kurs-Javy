import java.awt.*;
import java.awt.event.*;

public class Gra extends Frame {
    private DaneDlaLabiryntu daneDlaLabiryntu;
    private Płótno płótno;
    private static final int rozmiar=19;
    private int eksploratorX=0;
    private int eksploratorY=rozmiar-1;


    private KeyAdapter klawisze=new KeyAdapter() {
        @Override
        public void keyPressed (KeyEvent ev)
        {
            switch (ev.getKeyCode())
            {
                case KeyEvent.VK_DOWN:
                    //System.out.println("v");
                    if(daneDlaLabiryntu.czyIstniejePrzejście(eksploratorY, eksploratorX, eksploratorY+1, eksploratorX)){
                        płótno.przemieśćObraz(eksploratorY, eksploratorX, eksploratorY+1, eksploratorX);
                        eksploratorY++;
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    //System.out.println("<");
                    if(daneDlaLabiryntu.czyIstniejePrzejście(eksploratorY, eksploratorX, eksploratorY, eksploratorX-1)){
                        płótno.przemieśćObraz(eksploratorY, eksploratorX, eksploratorY, eksploratorX-1);
                        eksploratorX--;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    //System.out.println(">");
                    if(daneDlaLabiryntu.czyIstniejePrzejście(eksploratorY, eksploratorX, eksploratorY, eksploratorX+1)){
                        płótno.przemieśćObraz( eksploratorY, eksploratorX, eksploratorY, eksploratorX+1);
                        eksploratorX++;
                    }
                    else if(eksploratorX==rozmiar-1 && eksploratorY==0){
                        płótno.przemieśćObraz( eksploratorY, eksploratorX, eksploratorY, eksploratorX+1);
                        eksploratorX++;
                        Graphics g=płótno.getGraphics();
                        g.clearRect(0, 0, 740, 740);
                        g.setColor(Color.WHITE);
                        g.drawString("Labirynt pokonany", 50, 200);
                        try   {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                        Gra.this.dispose();

                    }
                    break;
                case  KeyEvent.VK_UP:
                    //System.out.println("^");
                    if(daneDlaLabiryntu.czyIstniejePrzejście(eksploratorY, eksploratorX, eksploratorY-1, eksploratorX)){
                        płótno.przemieśćObraz( eksploratorY, eksploratorX, eksploratorY-1, eksploratorX);
                        eksploratorY--;
                    }
                    break;
                default: // inne klawisze
                    break;
            }
        }
    };
    private WindowListener ramki = new WindowAdapter()
    {
        @Override
        public void windowClosing (WindowEvent ev)
        {
            Gra.this.dispose();
        }
    };



    public Gra() {
        super("Labirynt");
        daneDlaLabiryntu = new DaneDlaLabiryntu(rozmiar);

        płótno=new Płótno(daneDlaLabiryntu, rozmiar);
        setSize(740, 740);
        setLocation(100, 100);
        setMaximumSize(new Dimension(800, 800));



        add(płótno, BorderLayout.CENTER);
        płótno.addKeyListener(klawisze);
        płótno.setFocusable(true);
        płótno.requestFocus();
        addWindowListener(ramki);

        setVisible(true);
    }

}
