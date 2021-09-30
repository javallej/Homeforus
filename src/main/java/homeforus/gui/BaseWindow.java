package main.java.homeforus.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Objects;

// This class houses the main window that the GUI elements will be added to
public class BaseWindow extends JFrame {

    private BaseWindow baseWindow;
    private JLayeredPane layers;
    private Header header;
    private int winHeight = 700;
    private int winWidth = 1000;

    public BaseWindow() {
        baseWindow = this;
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

        basePanel.add(new Content(baseWindow));

        baseWindow.pack();
        setLocationRelativeTo(null);
        setVisible(true);
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

            Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
                @Override
                public void eventDispatched(AWTEvent event) {

                    if (event instanceof MouseEvent) {
                        MouseEvent me = (MouseEvent) event;
                        int buttonsDownMask = MouseEvent.BUTTON1_DOWN_MASK;
                        int dragged = MouseEvent.MOUSE_DRAGGED;

                        if ((((MouseEvent) event).getModifiersEx() & buttonsDownMask) != 0) {
                            SearchBar.SearchPopup open = header.searchBar.currentlyOpen;
                            if (open != null && open.isVisible()) {
                                int maxX = (int) open.getBounds().getMaxX() + 6;
                                int maxY = (int) open.getBounds().getMaxY() + 30;
                                int minX = (int) open.getBounds().getMinX();
                                int minY = (int) open.getBounds().getMinY();

                                if ((me.getX() > maxX || me.getY() > maxY
                                        || me.getY() < minY || me.getX() < minX)
                                && !me.getComponent().toString().contains("JTextField")
                                && !me.getComponent().toString().contains("WindowsComboBoxUI")
                                && !me.getComponent().toString().contains("BasicComboPopup")
                                && !me.getComponent().toString().contains("BasicComboPopup")
                                && (((MouseEvent) event).getModifiersEx() & dragged) == 0) {
                                    if (me.getComponent() != open.caller) {
                                        header.searchBar.setOpenNull();
                                    }
                                }
                            }
                        }
                    }


                }
            }, AWTEvent.MOUSE_EVENT_MASK);
        }
    }
}

