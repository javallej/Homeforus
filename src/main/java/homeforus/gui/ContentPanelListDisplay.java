package main.java.homeforus.gui;

import javax.swing.*;
import java.util.ArrayList;

public class ContentPanelListDisplay extends JPanel {

    private ArrayList<ContentPanel> panelList;
    private JPanel holder;

    public ContentPanelListDisplay(ArrayList<ContentPanel> panels) {
        panelList = panels;
        buildHolder();
    }

    private void buildHolder() {
        holder = new JPanel();
        holder.setLayout(new BoxLayout(holder, BoxLayout.PAGE_AXIS));
        add(holder);
        buildDisplayList();
    }

    public void buildDisplayList() {
        // code goes here to iterate through the list and adjust each panel's y position
        // to stack on top of each other
        for (ContentPanel c:panelList) {
            holder.add(c);
        }
    }

    public ArrayList<ContentPanel> getPanelList() {
        return panelList;
    }

    public void setPanelList(ArrayList<ContentPanel> panelList) {
        this.panelList = panelList;
    }
}
