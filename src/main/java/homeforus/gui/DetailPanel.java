package main.java.homeforus.gui;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class DetailPanel extends JPanel {

    private JLabel topRow = new JLabel("Price");
    private JLabel secondRow = new JLabel("HouseInfo");
    private JLabel lastRow = new JLabel( "some other stuff");

    JPanel picSpace = new JPanel();
    JPanel infoSpace = new JPanel();
    JPanel btnSpace = new JPanel();

    public DetailPanel() {
        //picSpace.setPreferredSize(new Dimension(130,130));
        //picSpace.add(new JLabel("picSpace"));
//        infoSpace.setPreferredSize(new Dimension(540,130));
//        infoSpace.setLayout(new GridLayout(3,0));
//        infoSpace.add(topRow);
//        infoSpace.add(secondRow);
//        infoSpace.add(lastRow);
        setPreferredSize(new Dimension(540,130));
        setLayout(new GridLayout(3,0));
        add(topRow);
        add(secondRow);
        add(lastRow);

        setBorder(debugBorder());

    }


    public static MatteBorder debugBorder() {
        return new MatteBorder(3, 3, 3, 3, Color.CYAN);
    }

}
