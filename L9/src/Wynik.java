import javax.swing.*;

import java.awt.*;

import static java.lang.Thread.sleep;

public class Wynik extends JFrame {
    private JLabel wynik;

    public Wynik(int wyn) {
        super("wynik");
        if (wyn == 0) wynik = new JLabel("Gra zakończona. Przegrałeś");
        else wynik = new JLabel("Gra zakończona. Gratulacje, udało się uziemić dziciaki!");
        add(wynik);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(600, 200));
        setSize(new Dimension(600, 200));
        setBackground(Color.BLUE);
        setVisible(true);
        try {
            sleep(2500);
            setVisible(false);
            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
