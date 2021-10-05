package main.java.homeforus.gui;

import main.java.homeforus.core.ApplicationListObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// This class contains the elements that are in the top part of the Header class:
//
// Manage Buttons                          Logo                               Sign In/Out
//
public class TopHeader extends JPanel {

    double logoPercentSize = 0.70;
    public int headerHeight;
    public int topHeaderHeight;
    public Dimension topHeaderDim;
    TopPanels manageBox;
    ManageApplicationPanel manage;
    SignInPanel signInPanel;
    private JButton manageApplications;
    private JButton manageListings;
    private JButton signInButton;
    private JButton signOutButton;
    private SignInWindow signInWindow;
    private CreateAccountWindow createAccountWindow;
    private BaseWindow window;

    public TopHeader(Dimension headerSize, BaseWindow window) {
            buildTopHeader(headerSize);
            this.window = window;
    }

    public void LoggedInConsumer(boolean state) {
        manage.setVisible(true);
        manageListings.setVisible(false);
        manageApplications.setVisible(state);
        toggleSignIn(state);
    }

    public void LoggedInRealtor(boolean state) {
        LoggedInConsumer(state);
        manageListings.setVisible(state);
    }

    public void toggleSignIn(boolean state) {
        if (state) {
            signInButton.setVisible(false);
            signOutButton.setVisible(true);
        } else {
            signOutButton.setVisible(false);
            signInButton.setVisible(true);
            manage.setVisible(false);
            window.getQueryConnector().setCurrentlyLoggedInUser(null);
            window.setContentWindowWithRandomHouses();
        }
    }

    public void setCreateAccountWindow(CreateAccountWindow createAccountWindow) {
        this.createAccountWindow = createAccountWindow;
    }

    public void hideCreateAccount() {
        createAccountWindow.dispose();
//        createAccountWindow.setVisible(false);
    }

    public void hideSignIn() {
        signInWindow.dispose();
//        signInWindow.setVisible(false);
    }

    // This class determines the size for the top 3 sections of the top portion of the header.
    public class TopPanels extends JPanel {
        int fractionalSize = 5;
        public TopPanels() {
            int innerPanelWidth = (int) topHeaderDim.getSize().getWidth()/fractionalSize;
            setLayout(new GridBagLayout());
            setPreferredSize(new Dimension(innerPanelWidth,(int) topHeaderDim.getHeight()));
        }
    }

    // This class is in charge of toggling the buttons in the upper left part of the screen,
    // depending on if a Consumer or Realtor is logged in at the time.
    public class ManageApplicationPanel extends TopPanels {
        public ManageApplicationPanel() {
            JPanel buttons = new JPanel();
            JPanel appPanel = new JPanel();
            appPanel.setLayout(new GridLayout());
            JPanel listPanel = new JPanel();
            listPanel.setLayout(new GridLayout());
            buttons.setLayout(new BoxLayout(buttons,BoxLayout.PAGE_AXIS));
            manageApplications = addButton("Manage Applications");

            manageApplications.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("applications clicked");
                    QueryConnector q = window.getQueryConnector();
                    ArrayList<ApplicationContentPanel> userApplications = null;
//                    try {
//                        realtorsHouses = q.getRealtorHouses(q.getCurrentlyLoggedInUser().getUserID());
//                    } catch (SQLException ex) {
//                        ex.printStackTrace();
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
//                    if (userApplications != null) {
//                        ArrayList<ContentPanel> cH = new ArrayList<>(realtorsHouses);
//                        ContentPanelListDisplay h = new ContentPanelListDisplay(cH);
//                        RealtorListingsView r = new RealtorListingsView(window, h);
//                        window.setContentView(r);
//                    }


                    List<ApplicationListObject> appListObjs = null;
                    try {
                        appListObjs = window.getQueryConnector().getAppListObjs();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    ApplicationInfo appInfo = null;

                    try {
                        appInfo = window.getQueryConnector().getAppInfoFromAppListObj(appListObjs.get(0));
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    ApplicationDetailPanel appDetail = new ApplicationDetailPanel(appInfo, window);

                    ApplicationContentPanel panel1 = new ApplicationContentPanel(window, appDetail, appListObjs.get(0), appInfo);

                    ArrayList<ContentPanel> panels = new ArrayList<>();
                    panels.add(panel1);

                    ContentPanelListDisplay contentPanelListDisplay = new ContentPanelListDisplay(panels);

                    ApplicationsView a = new ApplicationsView(window, contentPanelListDisplay);
                    window.setContentView(a);
                }
            });



            manageListings = addButton("Manage Listings");

            manageListings.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    QueryConnector q = window.getQueryConnector();
                    ArrayList<HouseContentPanel> realtorsHouses = null;
                    try {
                        realtorsHouses = q.getRealtorHouses(q.getCurrentlyLoggedInUser().getUserID());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    if (realtorsHouses != null) {
                        ArrayList<ContentPanel> cH = new ArrayList<>(realtorsHouses);
                        ContentPanelListDisplay h = new ContentPanelListDisplay(cH);
                        RealtorListingsView r = new RealtorListingsView(window, h);
                        window.setContentView(r);
                    }
                }
            });

            appPanel.add(manageApplications);
            listPanel.add(manageListings);
            buttons.add(appPanel);
            buttons.add(listPanel);
            add(buttons);
            manageApplications.setVisible(false);
            manageListings.setVisible(false);
        }

        public JButton addButton(String text) {
            JButton newButt = new JButton(text);
            newButt.setMinimumSize(new Dimension(170,40));
            return newButt;
        }
    }

    // This class is in charge of housing (heh) the top HomeForUs logo
    public class LogoImagePanel extends TopPanels {
        public LogoImagePanel() {
            BufferedImage logoImg = null;
            try {
                logoImg = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/homeforus/gui/logo.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            JLabel logoHolder = null;
            if (logoImg != null) {
                logoHolder = new JLabel(new ImageIcon(logoImg));
                add(logoHolder);
            }
        }
    }

    // This class is in charge of the Sign In/Out buttons at the top right
    // of the screen, and toggling them.
    public class SignInPanel extends TopPanels {
        public SignInPanel() {
            signInButton = createSignInButton();
            signOutButton = createSignOutButton();
            add(signInButton);
            add(signOutButton);
            signOutButton.setVisible(false);
        }

        public JButton createSignOutButton() {
            JButton btn = new JButton(new AbstractAction("Sign Out") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    toggleSignIn(false);
                }
            });
            return btn;
        }

        public JButton createSignInButton() {
            JButton btn = new JButton(new AbstractAction("Sign In") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (signInWindow == null) {
                        signInWindow = new SignInWindow(TopHeader.this, window);
                        signInWindow.setVisible(true);
                    } else {
                        signInWindow.setVisible(true);
                    }
                }
            });
            btn.setBackground(new BrandGreen().color);
            btn.setForeground(Color.white);
            btn.setBorderPainted(false);
            return btn;
        }
    }

    // This class is called in the constructor to build the elements that are contained within
    // the Top Header.
    private void buildTopHeader(Dimension headerSize) {
        this.headerHeight = (int)headerSize.getSize().getHeight();
        topHeaderHeight = (int) (headerSize.getSize().getHeight() * logoPercentSize);
        topHeaderDim = new Dimension((int)headerSize.getSize().getWidth(), topHeaderHeight);
        setPreferredSize(topHeaderDim);

        this.setLayout(new BorderLayout());

        manage = new ManageApplicationPanel();
        manageBox = new TopPanels();
        manageBox.add(manage);
        LogoImagePanel logo = new LogoImagePanel();
        signInPanel = new SignInPanel();

        add(manageBox, BorderLayout.LINE_START);
        add(logo, BorderLayout.CENTER);
        add(signInPanel, BorderLayout.LINE_END);
    }
}
