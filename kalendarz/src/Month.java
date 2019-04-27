import javax.swing.*;
import java.awt.*;

public class Month extends JPanel {
    private JLabel prevName;
    private JLabel thisName;
    private JLabel nextName;
    private JList<String> prevMonth;
    private JList<String> thisMonth;
    private JList<String> nextMonth;
    private JPanel namesOfSelectedMonths;
    private JPanel lists;
    public static String[] namesOfDays={"Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela"};
    //name {0, 1, 2, ..11}?
    public Month(int year, int name){
        new BoxLayout(this, BoxLayout.PAGE_AXIS);
        namesOfSelectedMonths=new JPanel();
        namesOfSelectedMonths.setLayout(new GridLayout(1 ,3));
        namesOfSelectedMonths.setPreferredSize(new Dimension(1200,25));
        namesOfSelectedMonths.setSize(new Dimension(1200,25));

        prevName=new JLabel();
        prevName.setText(Year.names[(name+11)%12]);
        thisName=new JLabel();
        thisName.setText(Year.names[name]);
        nextName=new JLabel();
        nextName.setText(Year.names[(name+1)%12]);
        namesOfSelectedMonths.add(prevName);
        namesOfSelectedMonths.add(thisName);
        namesOfSelectedMonths.add(nextName);
        int prevYear=year;
        if(name==0) prevYear=year-1;
        MyListModel listModel=new MyListModel((name+11)%12, prevYear );
        prevMonth=new JList<>(listModel);
        prevMonth.setCellRenderer(new Renderer());
        int nextYear=year;
        if(name==11) nextYear=year+1;
        MyListModel listModel3=new MyListModel((name+1)%12, nextYear);
        nextMonth=new JList<>(listModel3);
        nextMonth.setCellRenderer(new Renderer());

        MyListModel listModel2=new MyListModel(name, year);
        thisMonth=new JList<>(listModel2);
        thisMonth.setCellRenderer(new Renderer());

        lists=new JPanel();
        lists.setLayout(new GridLayout(1 ,3));
        lists.setPreferredSize(new Dimension(1200,700));
        lists.setSize(new Dimension(1200,700));

        lists.add(prevMonth);
        lists.add(thisMonth);
        lists.add(nextMonth);


        add(namesOfSelectedMonths);
        add(lists);
        setVisible(true);
    }
}
