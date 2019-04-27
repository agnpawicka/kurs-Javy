import javax.swing.*;
import java.awt.*;
import java.util.Timer;

public class Menu extends JFrame {
    private JButton nowa;
    private JButton wznów;
    private JButton wyjdz;
    private Gra gra;
    public Menu(){

        super("Menu");
        nowa=new JButton("NOWA GRA");
        wznów=new JButton("WZNÓW GRĘ");
        wyjdz=new JButton("WYJŚCIE");
        wyjdz.addActionListener(e-> wyjscie());
        nowa.addActionListener(e -> nowaGra());
        wznów.addActionListener(e ->wznowGre());
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(300, 300));
        setSize(new Dimension(300, 300));
        setBackground(Color.RED);
        setLayout(new BorderLayout());
        add(nowa, BorderLayout.NORTH);
        add(wznów, BorderLayout.CENTER);
        add(wyjdz, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void nowaGra(){
        setVisible(false);
        gra = new Gra( this);
    }
    private void wznowGre(){
        gra=new Gra(true, this);
    }
    private void wyjscie(){
        setVisible(false);
        System.exit(0);

    }
    public void zakoncz(int wynik){
        if(wynik==2);//nie udalo sie zapisac
        if(wynik==5);//zapisano gra

        setVisible(true);
    }

}
