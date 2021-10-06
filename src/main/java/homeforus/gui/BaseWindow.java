package main.java.homeforus.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

// This class houses the main window that the GUI elements will be added to
public class BaseWindow extends JFrame {

    private BaseWindow baseWindow;
    private JLayeredPane layers;
    private Content content;
    private Header header;
    private SearchInput searchInput;
    private QueryConnector queryConnector;
    private SignInManager signInManager;
    private Image appIcon;
    private int panelID;
    private int clickedOnOutside;

    private int winHeight = 700;
    private int winWidth = 1000;

    public BaseWindow() {
        baseWindow = this;
        queryConnector = new QueryConnector(this);
        signInManager = new SignInManager(this);
        panelID = 0;
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Image appIcon = null;
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    appIcon = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/homeforus/gui/Icon32.png")));
                    setIconImage(appIcon);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | IOException ex) {
                }
                buildBaseWindow();
            }
        });
    }

    public int incrementPanelID() {
        panelID += 1;
        return panelID;
    }

    public Image getAppIcon() {
        return appIcon;
    }

    public void buildBaseWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("HomeForUs");
        Dimension size = new Dimension(winWidth, winHeight);
        setMinimumSize(size);

        setLayers(new JLayeredPane());
        add(getLayers());
        JPanel basePanel = new BasePanel(size);

        getLayers().add(basePanel, JLayeredPane.DEFAULT_LAYER);
        header = new Header(baseWindow);
        basePanel.add(header);

        content = new Content(baseWindow);
        searchInput = new SearchInput();
        content.sI = searchInput;
        basePanel.add(content);
        setContentWindowWithRandomHouses();
        baseWindow.pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setContentWindowWithRandomHouses() {
        ArrayList<HouseContentPanel> randomHouses = null;
        try {
            randomHouses = getQueryConnector().getRandomHouses(10);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setContentWindowWithHouses(randomHouses);
    }

    public void setContentWindowWithHouses(ArrayList<HouseContentPanel> houses) {
        ArrayList<ContentPanel> contents = new ArrayList<>(houses);
        ContentPanelListDisplay contentPanelListDisplay = new ContentPanelListDisplay(contents);
        ContentView contentSearchView = new ContentView(this, contentPanelListDisplay);
        setContentView(contentSearchView);
    }

    public void setContentView(ContentView contentView) {
        content.setContentView(contentView);
    }


    public SignInManager getSignInManager() {
        return signInManager;
    }

    public void setSignInManager(SignInManager signInManager) {
        this.signInManager = signInManager;
    }

    public int getWinHeight() {
        return winHeight;
    }

    public int getWinWidth() {
        return winWidth;
    }

    public JLayeredPane getLayers() {
        return layers;
    }

    public void setLayers(JLayeredPane layers) {
        this.layers = layers;
    }

    public class BasePanel extends JPanel {

        public BasePanel(Dimension size) {
            setLocation(0, 0);
            setSize(size);
            setOpaque(false);
            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            clickedOnOutside = 0;

            Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
                @Override
                public void eventDispatched(AWTEvent event) {

                    if (event instanceof MouseEvent) {
                        MouseEvent me = (MouseEvent) event;
                        int buttonsDownMask = MouseEvent.BUTTON1_DOWN_MASK;
                        int dragged = MouseEvent.MOUSE_DRAGGED;

                        if ((((MouseEvent) event).getModifiersEx() & buttonsDownMask) != 0) {

                            if((MouseEvent.BUTTON1 & ((MouseEvent) event).getModifiersEx()) != 0) {
                                System.out.println("clicked");
                            }

                            SearchBar.SearchPopup open = header.searchBar.currentlyOpen;
                            if (open != null && open.isVisible()) {
                                int maxX = (int) open.getBounds().getMaxX();
                                int maxY = (int) open.getBounds().getMaxY();
                                int minX = (int) open.getBounds().getMinX() - 38;
                                int minY = (int) open.getBounds().getMinY() - 100;


//                                System.out.println("max x: " + maxX);
//                                System.out.println("min x: " + minX);
//                                System.out.println("max y: " + maxY);
//                                System.out.println("min y: " + minY);
//                                System.out.println("event x: " + me.getX());
//                                System.out.println("event y: " + me.getY());
//                                System.out.println(me.getSource().toString());


                                if (me.getComponent().toString().contains("JScrollPane")
                                        || me.getComponent().toString().contains("HouseContentPanel")) {
                                    if (clickedOnOutside >= 2) {
                                        header.searchBar.setOpenNull();
                                        clickedOnOutside = 0;
                                    } else {
                                        clickedOnOutside++;
                                    }
                                } else if ((me.getX() > maxX || me.getY() > maxY
                                        || me.getY() < minY || me.getX() < minX)
                                && !me.getComponent().toString().contains("JTextField")
                                && !me.getComponent().toString().contains("WindowsComboBoxUI")
                                && !me.getComponent().toString().contains("BasicComboPopup")) {
                                    if (me.getComponent() != open.caller) {
                                        header.searchBar.setOpenNull();
                                        clickedOnOutside = 0;
                                    }
                                }

                            }
                        }
                    }


                }
            }, AWTEvent.MOUSE_EVENT_MASK);
        }
    }

    public QueryConnector getQueryConnector() {
        return queryConnector;
    }


}

