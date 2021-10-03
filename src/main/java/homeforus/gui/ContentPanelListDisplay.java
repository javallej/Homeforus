package main.java.homeforus.gui;

import javax.swing.*;
import java.util.ArrayList;

public class ContentPanelListDisplay extends JPanel {

    private ArrayList<ContentPanel> panelList;

    public ContentPanelListDisplay(ArrayList<ContentPanel> panelList) {
        this.panelList = panelList;

        // code goes here to iterate through the list and adjust each panel's y position
        // to stack on top of each other
    }
}
