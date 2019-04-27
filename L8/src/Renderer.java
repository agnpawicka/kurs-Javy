import javax.swing.*;
import java.awt.*;

public class Renderer extends JLabel implements ListCellRenderer<String> {

    @Override
    public Component getListCellRendererComponent(JList<? extends String> list, String text, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        int lastChar;
        for (lastChar =text.length()-1; lastChar>=0; lastChar--) if(text.charAt(lastChar)==' ')break;
        String printed="";
        for(int i=0; i<lastChar; i++) printed+=text.charAt(i);
        if(text.charAt(0)=='N') setForeground(Color.RED);
        else setForeground(Color.BLACK);
        setText(printed);

        return this;
    }
}