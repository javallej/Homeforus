package main.java.homeforus.gui;

import main.java.homeforus.core.HouseListObject;

import javax.swing.*;

public class ContentSearchView extends ContentView {

    private ContentPanelListDisplay contentPanelListDisplay;

    public ContentSearchView(BaseWindow window, ContentPanelListDisplay c) {
        super(window);
        this.contentPanelListDisplay = c;
        // literally just put in the listDisplayObject panel and display it here in this panel
        add(c);
    }
}
