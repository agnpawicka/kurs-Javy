import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MonthsInYearPanel extends JPanel {
    private JLabel name;
    private JLabel[][] daysNumbers;
    private static String[] daysOfTheWeek = {"Pn", "Wt", "Śr", "Cz", "Pt", "So", "Nd"};
    private int weeks;
    private JPanel panelForDays;
    private static int rowsInMonth(int days, int firstDay) {
        int ret = 1;
        days -= 8 - firstDay;
        ret += days / 7;
        days -= days / 7;
        if (days > 0) ret++;
        return ret;
    }

    public MonthsInYearPanel(int name, int days, int firstDay, MainFrame mainFrame) {
        weeks = rowsInMonth(days, firstDay);
        setPreferredSize(new Dimension(200, 175));
        setSize(new Dimension(200, 175));
        this.name = new JLabel();
        this.name.setPreferredSize(new Dimension(200, 25));
        this.name.setBackground(Color.GRAY);
        this.name.setText(Year.names[name]);
        this.name.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //System.out.println("Tu ma być jeszcze przekierowanie");
                mainFrame.setMonth(mainFrame.getCurrentYear(), name);
                mainFrame.setTopTab(0);
            }
        });
        add(this.name, BorderLayout.NORTH);
        panelForDays=new JPanel();
        panelForDays.setPreferredSize(new Dimension(200, 150));
        panelForDays.setSize(new Dimension(200, 150));
        panelForDays.setLayout(new GridLayout(weeks+1, 7 ));
        add(panelForDays, BorderLayout.CENTER);
        daysNumbers = new JLabel[weeks][7];
        Integer x = 1;
        for(int i=0; i<7; i++) panelForDays.add(new JLabel(daysOfTheWeek[i]));
        for(int i=0; i<firstDay; i++) panelForDays.add(new JLabel(" "));
        for (int j = firstDay; j < 7; j++) {
            daysNumbers[0][j]=new JLabel();
            daysNumbers[0][j].setText(x.toString());
            panelForDays.add(daysNumbers[0][j]);
            x++;
            if(mainFrame.getCurrentYear()==1582 && name==9 && x==5) x+=10;
        }
        daysNumbers[0][6].setForeground(Color.RED);
        for (int i = 1; i < weeks; i++) {
            for (int j = 0; j <7; j++){
                daysNumbers[i][j]=new JLabel();
                daysNumbers[i][j].setText(x.toString());
                if(j==6) daysNumbers[i][j].setForeground(Color.RED);
                x++;
                if(mainFrame.getCurrentYear()==1582 && name==9 && x==5) x+=10;
                panelForDays.add(daysNumbers[i][j]);
                if( x>days) {
                    for(int k=j+1; k<7; k++) panelForDays.add(new JLabel(" "));
                    break;
                }
            }
        }
       // for(int i=0; i<weeks; i++) daysNumbers[i][6].setBackground(Color.RED);


        setVisible(true);
    }
}
