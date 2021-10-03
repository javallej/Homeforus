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

        row1 = new JLabel("Default Row 1");
        row1.setFont(new Font("Sans_Serif",Font.BOLD,20));
        row2 = new JLabel("Default Row 2");
        row2.setFont(new Font("Sans_Serif",Font.BOLD,14));
        row3 = new JLabel( "Default Row 3");
        row3.setFont(new Font("Sans_Serif", Font.PLAIN,14));
        row4 = new JLabel("Default Row 4");
        row4.setFont(new Font("Sans_Serif", Font.PLAIN,14));
        row5 = new JLabel("Default Row 5");
        row5.setFont(new Font("Sans_Serif", Font.PLAIN,14));

        setPreferredSize(new Dimension(500,130));
        setLayout(new GridLayout(5,0));
        add(row1);
        add(row2);
        add(row3);
        add(row4);
        add(row5);
    }

    public JLabel getRow1() {
        return row1;
    }

    public JLabel getRow2() {
        return row2;
    }

    public JLabel getRow3() {
        return row3;
    }

    public JLabel getRow4() {
        return row4;
    }

    public JLabel getRow5() {
        return row5;
    }

    public static MatteBorder debugBorder() {
        return new MatteBorder(3, 3, 3, 3, Color.CYAN);
    }

}
