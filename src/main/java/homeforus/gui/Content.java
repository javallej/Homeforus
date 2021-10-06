package main.java.homeforus.gui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Content extends JPanel {

    private BaseWindow window;
    public SearchInput sI;
    private JPanel innerPanel;
    private JTextArea tA;
    private double totalPercentSize = 0.75;
    private ContentView contentView;
    private JScrollPane scrollPane;

    public Content(BaseWindow baseWindow) {
        window = baseWindow;
        int totalVertSize = (int) (baseWindow.getWinHeight() * totalPercentSize);
        Dimension contentSize = new Dimension(baseWindow.getWinWidth(), totalVertSize);
        tA = new JTextArea();
        setPreferredSize(contentSize);

        innerPanel = new JPanel();
        scrollPane = new JScrollPane(innerPanel);
        scrollPane.setPreferredSize(new Dimension(940,460));
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        add(scrollPane);

    }

    public ContentView getContentView() {
        return contentView;
    }

    public void setContentView(ContentView contentView) {
        this.contentView = contentView;
        innerPanel = new JPanel();
        remove(scrollPane);
        scrollPane = new JScrollPane(innerPanel);
        scrollPane.setPreferredSize(new Dimension(940,460));
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        add(scrollPane);
        innerPanel.add(contentView);
        window.pack();
    }


    public JPanel getInnerPanel() {
        return innerPanel;
    }

    public void setInnerPanel(JPanel innerPanel) {
        this.innerPanel = innerPanel;
    }

}
