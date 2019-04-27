import javax.swing.*;
public class MyListModel extends DefaultListModel<String> {
    private int month;
    private int year;
    private int days;
    private Calendar data;
    public MyListModel(int month, int year){
        data=new Calendar();
        this.month=month;
        this.year=year;
        int first= data.getFirst(month, year);
        days=data.daysInMonth(month, year);
        if(year==1582 && month==9){
         for(int i=0; i<4; i++){
             addElement(Month.namesOfDays[first]+ "    "+ ((Integer)(i+1)).toString());
             first=(first+1)%7;
         }
         for(int i=15; i<days; i++){
             addElement(Month.namesOfDays[first]+ "    "+ ((Integer)(i+1)).toString());
             first=(first+1)%7;
         }
        }
        else for(int i=0; i<days; i++){
            addElement(Month.namesOfDays[first]+ "    "+ ((Integer)(i+1)).toString());
            first=(first+1)%7;
        }
    }
    @Override
    public String getElementAt(int i) {
        return elementAt(i)+"   "+Year.names[month];
    }

    @Override
    public int getSize() {
        return days;
    }
}
