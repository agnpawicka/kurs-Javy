import javax.swing.*;
import java.awt.*;

public class Year extends JPanel {
    private MonthsInYearPanel[] months = new MonthsInYearPanel[12];
    private Calendar calendar=new Calendar();
    public static String[] names={"Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec", "Lipiec", "Sierpień", "Wrzesień", "Październik", "Listopad", "Grudzień"};
    public Year(int year,MainFrame mainFrame) {
        setPreferredSize(new Dimension(1200, 650));
        setLayout(new GridLayout(3, 4));
        for (int i = 0; i < 12; i++) {
            months[i] = new MonthsInYearPanel(i,  calendar.daysInMonth(i, year), calendar.getFirst(i, year), mainFrame);
            add(months[i]);
        }
        setVisible(true);
    }
}
