package main.java.homeforus.gui;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class Content extends JPanel {

    private double totalPercentSize = 0.75;

    public Content(BaseWindow baseWindow) {
        int totalVertSize = (int) (baseWindow.getWinHeight() * totalPercentSize);
        Dimension contentSize = new Dimension(baseWindow.getWinWidth(), totalVertSize);

        setPreferredSize(contentSize);



        add(new JLabel("Content"));
    }
}
