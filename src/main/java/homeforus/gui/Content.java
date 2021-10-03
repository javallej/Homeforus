package main.java.homeforus.gui;

import javax.swing.*;
import java.awt.*;

public class Content extends JPanel {

    public SearchInput sI;
    private JPanel innerPanel;
    private JTextArea tA;
    private double totalPercentSize = 0.75;

    public Content(BaseWindow baseWindow) {
        int totalVertSize = (int) (baseWindow.getWinHeight() * totalPercentSize);
        Dimension contentSize = new Dimension(baseWindow.getWinWidth(), totalVertSize);
        tA = new JTextArea();
        setPreferredSize(contentSize);

        innerPanel = new JPanel();
        innerPanel.setPreferredSize(new Dimension(900,440));

        JScrollPane scrollPane = new JScrollPane(innerPanel);
        scrollPane.setPreferredSize(new Dimension(940,460));
        add(scrollPane);

        ContentPanel contentPanel = new ContentPanel(baseWindow, "test");
        innerPanel.add(contentPanel);
    }

    public void changeContent() {
        tA.setText(sI.toString());
    }

    public JPanel getInnerPanel() {
        return innerPanel;
    }

    public void setInnerPanel(JPanel innerPanel) {
        this.innerPanel = innerPanel;
    }

}
