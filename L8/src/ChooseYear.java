import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ChooseYear extends JToolBar {
    private JButton nextYear;
    private JButton prevYear;
    private JButton nextMonth;
    private JButton prevMonth;
    private JScrollBar scrollYears;
    private JScrollBar scrollMonths;
    private JSpinner spinYears;
    private JSpinner spinMonths;
    private MainFrame mainFrame;

    public ChooseYear(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setSize(new Dimension(1200, 50));
        setPreferredSize(new Dimension(1200, 50));
        nextYear = new JButton("następny rok");
        prevYear = new JButton("poprzedni rok");
        nextMonth = new JButton("następny miesiąc");
        prevMonth = new JButton("poprzedni miesiąc");
        nextYear.addActionListener(e -> {
            mainFrame.setYear(mainFrame.getCurrentYear() + 1);
            mainFrame.setTopTab(1);
            spinYears.setValue(mainFrame.getCurrentYear());
            scrollYears.setValue(mainFrame.getCurrentYear());
        });
        prevYear.addActionListener(e -> {
            mainFrame.setYear(mainFrame.getCurrentYear() - 1);
            mainFrame.setTopTab(1);
            spinYears.setValue(mainFrame.getCurrentYear());
            scrollYears.setValue(mainFrame.getCurrentYear());
        });
        nextMonth.addActionListener(e -> {
            int i = mainFrame.getCurrentMonth() + 1;
            if (i == 12) {
                mainFrame.setYear(mainFrame.getCurrentYear() + 1);
                spinYears.setValue(mainFrame.getCurrentYear());
                scrollYears.setValue(mainFrame.getCurrentYear());
                i = 0;
            }
            mainFrame.setMonth(mainFrame.getCurrentYear(), i);
            mainFrame.setTopTab(0);
            spinMonths.setValue(spinMonths.getNextValue());
            scrollMonths.setValue(i);
        });
        prevMonth.addActionListener(e -> {
            int i = mainFrame.getCurrentMonth() - 1;
            if (i == -1) {
                mainFrame.setYear(mainFrame.getCurrentYear() - 1);
                spinYears.setValue(mainFrame.getCurrentYear());
                scrollYears.setValue(mainFrame.getCurrentYear());
                i = 11;
            }
            mainFrame.setMonth(mainFrame.getCurrentYear(), i);
            mainFrame.setTopTab(0);
            spinMonths.setValue(spinMonths.getPreviousValue());
            scrollMonths.setValue(i);
        });
        Calendar cal = new Calendar();
        scrollYears = new JScrollBar(Adjustable.HORIZONTAL, cal.yearToday(), 1, 0, 4000);
        scrollMonths = new JScrollBar(Adjustable.HORIZONTAL, cal.monthToday(), 1, 0, 12);
        scrollYears.addAdjustmentListener(e -> {
            mainFrame.setYear(e.getValue());
            mainFrame.setTopTab(1);
            spinYears.setValue(e.getValue());
        });
        scrollMonths.addAdjustmentListener(e -> {
            int x = mainFrame.getCurrentMonth();
            mainFrame.setMonth(mainFrame.getCurrentYear(), e.getValue());
            mainFrame.setTopTab(0);
            x = (e.getValue() + 12 - x) % 12;
            for (int i = 0; i < x; i++) spinMonths.setValue(spinMonths.getNextValue());
        });
        spinYears = new JSpinner(new SpinnerNumberModel(cal.yearToday(), 0, 4000, 1));
        spinYears.setSize(new Dimension(70, 15));
        spinYears.setPreferredSize(new Dimension(70, 15));
        spinMonths = new JSpinner(new SpinnerForMonths(Year.names));
        for (int i = 0; i < cal.monthToday(); i++) spinMonths.setValue(spinMonths.getNextValue());
        spinMonths.setSize(new Dimension(70, 15));
        spinMonths.setPreferredSize(new Dimension(70, 15));
        spinMonths.addChangeListener(e -> {
            String val = (String) spinMonths.getValue();
            int x = 0;
            switch (val) {
                case "Luty":
                    x = 1;
                    break;
                case "Marzec":
                    x = 2;
                    break;
                case "Kwiecień":
                    x = 3;
                    break;
                case "Maj":
                    x = 4;
                    break;
                case "Czerwiec":
                    x = 5;
                    break;
                case "Lipiec":
                    x = 6;
                    break;
                case "Sierpień":
                    x = 7;
                    break;
                case "Wrzesień":
                    x = 8;
                    break;
                case "Październik":
                    x = 9;
                    break;
                case "Listopad":
                    x = 10;
                    break;
                case "Grudzień":
                    x = 11;
                    break;
                default:
                    break;
            }
            int prev=mainFrame.getCurrentMonth();
            if(x==0 && prev==11){
                mainFrame.setYear(mainFrame.getCurrentYear()+1);
            }
            if(x==11 && prev==0){
                mainFrame.setYear(mainFrame.getCurrentYear()-1);
            }
            mainFrame.setMonth(mainFrame.getCurrentYear(), x);
            mainFrame.setTopTab(0);
        });
        spinYears.addChangeListener(e -> {
            scrollYears.setValue((Integer) spinYears.getValue());
            mainFrame.setYear((Integer) spinYears.getValue());
            mainFrame.setTopTab(1);
        });
        add(prevMonth, BorderLayout.NORTH);
        add(nextMonth, BorderLayout.NORTH);
        add(scrollMonths, BorderLayout.NORTH);
        add(spinMonths, BorderLayout.NORTH);
        add(prevYear, BorderLayout.SOUTH);
        add(nextYear, BorderLayout.SOUTH);
        add(scrollYears, BorderLayout.SOUTH);
        add(spinYears, BorderLayout.SOUTH);
    }
}
