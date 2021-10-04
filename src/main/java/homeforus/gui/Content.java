package main.java.homeforus.gui;

import javax.swing.*;
import java.awt.*;
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


        ArrayList<ContentPanel> panels = new ArrayList<>();
        // We can populate this ContentPanelListDisplay with default Home listings when the user launches the program
        for (int i = 0; i < 9; i++) {
            ContentPanel c = new ContentPanel(baseWindow, "image");
            panels.add(c);
        }
        ContentPanelListDisplay defaultDisplayList = new ContentPanelListDisplay(panels);
        contentView = new ContentSearchView(baseWindow, defaultDisplayList);
//        innerPanel.add(contentView);
        innerPanel.add(new TestingPanel(baseWindow));

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
        innerPanel.revalidate();
        window.pack();
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
