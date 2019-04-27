import javax.swing.*;
import java.awt.*;
import java.util.GregorianCalendar;

public class MainFrame extends JFrame{
    private JTabbedPane tabs;
    private Month month;
    private Year year;
    private Color background=new Color(54, 54, 49);
    private ChooseYear chooseYear;
    private int currentYear;
    private int currentMonth;
    public MainFrame(){
        setTitle("Kalendarz");
        setSize(new Dimension(1200, 700));
        setPreferredSize(new Dimension(1200, 700));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(background);
        tabs=new JTabbedPane();
        tabs.setPreferredSize(new Dimension(1200, 650));
        tabs.setSize(new Dimension(1200, 650));
        Calendar cal=new Calendar();
        currentMonth=cal.monthToday();
        currentYear=cal.yearToday();
        month=new Month(currentYear, currentMonth);
        year=new Year(currentYear, this);
        tabs.add(Year.names[currentMonth], month);
        tabs.add(((Integer)currentYear).toString(), year);
        tabs.setBackground(Color.GRAY);
        add(tabs, BorderLayout.CENTER);
        chooseYear=new ChooseYear(this);
        add(chooseYear, BorderLayout.SOUTH);
        pack();
        setVisible(true);

    }
    public void setYear(int nr){
        currentYear=nr;
        year=new Year(nr, this);
        setMonth(nr, currentMonth);
    }
    public void setMonth(int yearNr, int nr){
        currentYear=yearNr;
        currentMonth=nr;
        month=new Month(yearNr, nr);
        tabs.remove(1);
        tabs.remove(0);
        tabs.add(Year.names[currentMonth], month);
        tabs.add(((Integer)currentYear).toString(), year);
        tabs.setVisible(true);
        revalidate();
        repaint();
        setVisible(true);
    }
    public void  setTopTab(int index){
        tabs.setSelectedIndex(index);
    }
    public int getCurrentYear(){
        return currentYear;
    }
    public int getCurrentMonth(){
        return currentMonth;
    }
}