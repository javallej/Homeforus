package main.java.homeforus.gui;

import javax.swing.*;
import java.awt.*;

public class Content extends JPanel {

    public SearchInput sI;
    private JPanel innerPanel;
    private JTextArea tA;
    private double totalPercentSize = 0.75;
    private ContentView contentView;

    public Content(BaseWindow baseWindow) {
        int totalVertSize = (int) (baseWindow.getWinHeight() * totalPercentSize);
        Dimension contentSize = new Dimension(baseWindow.getWinWidth(), totalVertSize);
        tA = new JTextArea();
        setPreferredSize(contentSize);

        innerPanel = new JPanel();
//        innerPanel.setPreferredSize(new Dimension(900,440));

        JScrollPane scrollPane = new JScrollPane(innerPanel);
        scrollPane.setPreferredSize(new Dimension(940,460));
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        add(scrollPane);

        ContentPanelListDisplay defaultDisplayList = new ContentPanelListDisplay();
        // We can populate this ContentPanelListDisplay with default Home listings when the user launches the program
        for (int i = 0; i < 9; i++) {
            ContentPanel c = new ContentPanel(baseWindow, "image");
            defaultDisplayList.getPanelList().add(c);
        }
        defaultDisplayList.buildDisplayList();
        ContentView contentView = new ContentSearchView(baseWindow, defaultDisplayList);
//        innerPanel.add(contentView);
        innerPanel.add(new TestingPanel(baseWindow));

    }

    public void setContentView(ContentView contentView) {
        this.contentView = contentView;
    }

    //    public void changeContent() {
//        tA.setText(sI.toString());
//    }

    public JPanel getInnerPanel() {
        return innerPanel;
    }

    public void setInnerPanel(JPanel innerPanel) {
        this.innerPanel = innerPanel;
    }

}
