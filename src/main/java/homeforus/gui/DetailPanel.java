package main.java.homeforus.gui;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class DetailPanel extends JPanel {

    private JLabel row1;
    private JLabel row2;
    private JLabel row3;
    private JLabel row4;
    private JLabel row5;


    public DetailPanel() {

        row1 = new JLabel("$123,000");
        row1.setFont(new Font("Sans_Serif",Font.BOLD,20));
        row2 = new JLabel("2 bds 1 ba 2 floors 1,500 sqft");
        row2.setFont(new Font("Sans_Serif",Font.BOLD,14));
        row3 = new JLabel( "742 Evergreen Terrace, Springfield, OR 12345");
        row3.setFont(new Font("Sans_Serif", Font.PLAIN,14));
        row4 = new JLabel("Year built: 1969");
        row4.setFont(new Font("Sans_Serif", Font.PLAIN,14));
        row5 = new JLabel("52 days on HomeForUs");
        row5.setFont(new Font("Sans_Serif", Font.PLAIN,14));

        setPreferredSize(new Dimension(500,130));
        setLayout(new GridLayout(5,0));
        add(row1);
        add(row2);
        add(row3);
        add(row4);
        add(row5);

        setBorder(debugBorder());

    }


    public static MatteBorder debugBorder() {
        return new MatteBorder(3, 3, 3, 3, Color.CYAN);
    }

}
