package main.java.homeforus.gui;

import javax.swing.*;
import java.util.ArrayList;

public class ContentView extends JPanel {

    private BaseWindow window;
    private ContentPanelListDisplay contentPanelListDisplay;

    public ContentView(BaseWindow window) {
        this.window = window;
    }

    public ContentView(BaseWindow window, ContentPanelListDisplay c) {
        this.window = window;
        this.contentPanelListDisplay = c;
    }

    public ContentPanelListDisplay getContentPanelListDisplay() {
        return contentPanelListDisplay;
    }


}
