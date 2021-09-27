package main.java.homeforus.gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SearchBar extends JPanel {

    private BaseWindow window;
    private Dimension searchBarSize;
    private TopHeader topHeader;
    private SearchInput searchInput;
    private SearchTextBoxes searchTextBoxes;
    private SearchPopup pricePopUp;
    private SearchPopup bedsAndBathsPopUp;
    private SearchPopup moreOptionsPopUp;
    private JButton beginSearch;
    public JPanel currentlyOpen;
    private double searchPercentSize = 0.30;

    public SearchBar(Dimension headerSize, TopHeader topHeader, BaseWindow window) {
        this.window = window;
        this.topHeader = topHeader;
        int searchVertSize = (int) (headerSize.getSize().getHeight() * searchPercentSize) + 2;
        searchBarSize = new Dimension((int)headerSize.getSize().getWidth(), searchVertSize);
        setPreferredSize(searchBarSize);
        buildSearchBar();
    }

    public void buildSearchBar() {
        JPanel bar = new JPanel();
        bar.setLayout(new FlowLayout());
        bar.setPreferredSize(new Dimension((int)(searchBarSize.getWidth()/5)*4,(int)searchBarSize.getHeight()));
        add(bar);
        searchTextBoxes = new SearchTextBoxes(bar);
        beginSearch = new JButton("Search");
        bar.add(beginSearch);

        pricePopUp = new PricePopUp();
        SearchButton price = new SearchButton("Price", pricePopUp);
        bar.add(price);

        bedsAndBathsPopUp = new BedsAndBathsPopUp();
        SearchButton bedbaths = new SearchButton("Beds & Baths", bedsAndBathsPopUp);
        bar.add(bedbaths);

        moreOptionsPopUp = new MoreOptionsPopUp();
        SearchButton more = new SearchButton("More", moreOptionsPopUp);
        bar.add(more);
    }

    public class SearchButton extends JButton {

        public SearchPopup searchPopup;

        public SearchButton(String text, SearchPopup searchPopup) {
            this.searchPopup = searchPopup;
            setText(text);
            setVisible(true);
            int vertOffsetPanelPos = topHeader.headerHeight - 15;
            JButton thisButton = this;

            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Point panelPos = new Point((int) (thisButton.getBounds().getMaxX() - 10), (int) thisButton.getLocation().getY() + vertOffsetPanelPos);

                    searchPopup.setVisible(true);
                    searchPopup.setBounds(0, 0, searchPopup.width, searchPopup.height);
                    searchPopup.setLocation(panelPos);
                    searchPopup.setFocusTo();
                    currentlyOpen = searchPopup;
                }
            });
        }
    }

    public class SearchPopup extends JPanel {

        public JPanel inner;
        public int width;
        public int height;

        public SearchPopup() {
            setLayout(new BorderLayout());
            setMaximumSize(new Dimension(width, height));
            setBorder(new LineBorder(Color.gray));
            setVisible(false);
            window.layers.add(this, JLayeredPane.POPUP_LAYER);

            // remove this later
            JButton popupCloseButton = new JButton("Close");
            inner = new JPanel();
            inner.setVisible(true);
            inner.setLayout(new GridLayout(2,1));
            inner.setMaximumSize(new Dimension(50,50));
            add(inner);


            popupCloseButton.addActionListener(e -> {
                setVisible(false);
            });
        }

        public void setFocusTo() {

        }
    }

    public class PricePopUp extends SearchPopup {

        public InputField min;
        public InputField max;

        public PricePopUp() {
            width = 200;
            height = 200;
            min = new InputField("Min");
            inner.add(min);


        }

        @Override
        public void setFocusTo() {
            min.getTextField().requestFocusInWindow();
        }
    }


    public class BedsAndBathsPopUp extends SearchPopup {

        public JComboBox<Integer> beds;
        public JComboBox<Integer> baths;

        public BedsAndBathsPopUp() {
            width = 200;
            height = 200;
            beds = newBox();
            baths = newBox();
            inner.add(new JLabel(""));
            inner.add(beds);
            inner.add(new JLabel(""));
            inner.add(baths);
        }

        public JComboBox<Integer> newBox() {
           JComboBox<Integer> b = new JComboBox<>();
            for (int i = 1; i < 5; i++) {
                b.addItem(i);
            }
            return b;
        }

        @Override
        public void setFocusTo() {
            beds.requestFocusInWindow();
        }

    }

    public class MoreOptionsPopUp extends SearchPopup {

        public MoreOptionsPopUp() {

            width = 200;
            height = 200;
        }
    }

    public static class SearchTextBoxes {

        public SearchTextBox address;
        public SearchTextBox city;
        public SearchTextBox state;
        public SearchTextBox zip;

        public SearchTextBoxes(JPanel bar) {
            int height = 27;
            address = new SearchTextBox("Address", 50);
            address.setPreferredSize(new Dimension(150,height));
            bar.add(address);

            city = new SearchTextBox("City", 30);
            city.setPreferredSize(new Dimension(100,height));
            bar.add(city);

            state = new SearchTextBox("State", 2);
            state.setPreferredSize(new Dimension(50,height));
            bar.add(state);


            zip = new SearchTextBox("Zip", 5);
            zip.setPreferredSize(new Dimension(70,height));
            bar.add(zip);
        }
    }


    public static class SearchTextBox extends JTextField {

        public String dummyText;
        private int limit;

        public SearchTextBox(String dummy, int charLimit) {
            this.dummyText = dummy;
            this.limit = charLimit;

            setText(dummyText);
            setForeground(Color.GRAY);

            addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (getText().equals(dummyText)) {
                        setText("");
                        setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (getText().isEmpty()) {
                        setForeground(Color.GRAY);
                        setText(dummyText);
                    }
                }
            });

            addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if (getText().length() >= limit)
                        e.consume();
                }
            });
        }

    }
    public static class SearchInput {
        public int houseNum;
        public String street;
        public String city;
        public String state;
        public int zip;
        public int priceMin;
        public int priceMax;
        public int beds;
        public int baths;
        public int sqftMin;
        public int sqftMax;
        public int floors;
        public int yearBuiltMin;
        public int yearBuiltMax;
        public int daysListedMin;
        public int daysListedMax;

        public SearchInput(int houseNum, String street, String city, String state, int zip,
                           int priceMin, int priceMax, int beds, int baths, int sqftMin, int sqftMax,
                           int floors, int yearBuiltMin, int yearBuiltMax, int daysListedMin, int daysListedMax) {
            this.houseNum = houseNum;
            this.street = street;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.priceMin = priceMin;
            this.priceMax = priceMax;
            this.beds = beds;
            this.baths = baths;
            this.sqftMin = sqftMin;
            this.sqftMax = sqftMax;
            this.floors = floors;
            this.yearBuiltMin = yearBuiltMin;
            this.yearBuiltMax = yearBuiltMax;
            this.daysListedMin = daysListedMin;
            this.daysListedMax = daysListedMax;
        }
    }
}
