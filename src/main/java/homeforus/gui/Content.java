package main.java.homeforus.gui;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import main.java.homeforus.core.HouseListObject;

import java.awt.*;
import java.util.List;

public class Content extends JPanel {

    public SearchInput sI;
    public String testString;
    private JTextArea tA;
    private double totalPercentSize = 0.75;

    public Content(BaseWindow baseWindow) {
        int totalVertSize = (int) (baseWindow.getWinHeight() * totalPercentSize);
        Dimension contentSize = new Dimension(baseWindow.getWinWidth(), totalVertSize);
        tA = new JTextArea();
        add(tA);
        setPreferredSize(contentSize);
    }

    public void changeContent() {
        tA.setText(sI.toString());
    }
    
    public void change(String house) {
        tA.setText(house);
    }
}
