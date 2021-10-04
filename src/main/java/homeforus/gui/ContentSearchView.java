package main.java.homeforus.gui;

import main.java.homeforus.core.HouseListObject;

import javax.swing.*;
import java.util.ArrayList;

public class ContentSearchView extends ContentView {

    public ContentSearchView(BaseWindow window, ContentPanelListDisplay defaultDisplayList) {
        super(window, defaultDisplayList);
        add(getContentPanelListDisplay());
    }

}
