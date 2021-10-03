package main.java.homeforus.gui;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class Header extends JPanel {

    public SearchBar searchBar;
    private double totalPercentSize = 0.25;

    // This constructor sets up both parts of the Header: The top part with the logo, login, and
    // "manage" buttons, and the bottom part with the search bar. It also puts a line between them.
    public Header(BaseWindow baseWindow) {
        int totalVertSize = (int) (baseWindow.getWinHeight() * totalPercentSize);
        Dimension headerDimension = new Dimension(baseWindow.getWinWidth(), totalVertSize);

        setPreferredSize(new Dimension((int)headerDimension.getWidth(), totalVertSize));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        TopHeader topHeader = new TopHeader(headerDimension,baseWindow);
        searchBar = new SearchBar(headerDimension, topHeader, baseWindow);
        add(topHeader);
        addLine();
        add(searchBar);
        addLine();
    }

    // This creates a JSeparator line for use between the two sections of the Header.
    public void addLine() {
        JSeparator line = new JSeparator();
        line.setBorder( new MatteBorder(5, 0, 5, 0, Color.GRAY) );
        add(line);
    }

}
