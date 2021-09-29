package main.java.homeforus.gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class SearchBar extends JPanel {

    private BaseWindow window;
    private Dimension searchBarSize;
    private TopHeader topHeader;
    private SearchInput searchInput;
    private SearchTextBoxes searchTextBoxes;
    private SearchButton price;
    private SearchPopup pricePopUp;
    private SearchPopup bedsAndBathsPopUp;
    private SearchPopup moreOptionsPopUp;
    private JButton beginSearch;
    public static SearchPopup currentlyOpen;
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
        beginSearch.setBackground(new BrandGreen().color);
        beginSearch.setForeground(Color.white);
        beginSearch.setBorderPainted(false);
        bar.add(beginSearch);

        pricePopUp = new PricePopUp();
        price = new SearchButton("Price", pricePopUp);
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
        int vertOffsetPanelPos;
        SearchButton thisButton;

        public SearchButton(String text, SearchPopup searchPopup) {
            this.searchPopup = searchPopup;
            setText(text);
            setVisible(true);
            vertOffsetPanelPos = topHeader.headerHeight - 15;
            thisButton = this;
            addListeners();
        }

        public void addListeners() {
            ActionListener aL = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Point panelPos = new Point((int) (thisButton.getBounds().getMaxX() - 10), (int) thisButton.getLocation().getY() + vertOffsetPanelPos);

                    if (currentlyOpen == null) {
                        searchPopup.setVisible(true);
                        searchPopup.setBounds(0, 0, searchPopup.width, searchPopup.height);
                        searchPopup.setLocation(panelPos);
                        searchPopup.setFocusTo();
                        currentlyOpen = searchPopup;
                        currentlyOpen.caller = thisButton;
                        window.getRootPane().setDefaultButton(thisButton);
                    } else {
                        setOpenNull();
                    }
                }
            };
            this.addActionListener(aL);
        }
    }


    public static void setOpenNull() {
        currentlyOpen.setVisible(false);
        currentlyOpen = null;
    }

    public class SearchPopup extends JPanel {

        public SearchButton caller;
        public JPanel inner;
        public int width;
        public int height;

        public SearchPopup() {
            setLayout(new BorderLayout());
            setMaximumSize(new Dimension(width, height));
            setBorder(new LineBorder(Color.gray));
            setVisible(false);
            window.layers.add(this, JLayeredPane.POPUP_LAYER);

            inner = new JPanel();
            inner.setVisible(true);
            inner.setLayout(new FlowLayout());
            inner.setMaximumSize(new Dimension(width,height));
            add(inner);

        }

        public void setFocusTo() {

        }


    }

    public static MatteBorder debugBorder() {
        return new MatteBorder(3, 3, 3, 3, Color.CYAN);
    }

    public class PricePopUp extends SearchPopup {

        public SearchInputField min;
        public SearchInputField max;

        public PricePopUp() {
            width = 240;
            height = 70;
            min = new SearchInputField("Min");
            max = new SearchInputField("Max");
            inner.add(min);
            JPanel dashHolder = new JPanel();
            dashHolder.setLayout(new BoxLayout(dashHolder, BoxLayout.PAGE_AXIS));
            dashHolder.setMaximumSize(new Dimension(10, 30));
            dashHolder.add(new JLabel("-"));
            dashHolder.add(new JLabel(" "));
            inner.add(dashHolder);
            inner.add(max);


            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentHidden(ComponentEvent e) {
                    super.componentHidden(e);
                    try {
                        String minT = min.textField.getText();
                        String maxT = max.textField.getText();
                        boolean isNumMin = !minT.isEmpty() && Character.isDigit(minT.toCharArray()[0]);
                        boolean isNumMax = !maxT.isEmpty() && Character.isDigit(maxT.toCharArray()[0]);
                        String pMin = null;
                        String pMax = null;
                        if (isNumMin) {
                            pMin = formatPrice(minT);
                            if (!pMin.equalsIgnoreCase("null")) {
                                price.setText(pMin + "+");
                            }
                        }
                        if (isNumMax) {
                            pMax = formatPrice(maxT);
                            if (!pMax.equalsIgnoreCase("null")) {
                                price.setText("< " + pMax);
                            }
                        }
                        if (isNumMin && isNumMax) {
                            if (pMin.compareTo(pMax) < 0) {
                                price.setText(pMin + " - " + pMax);
                            } else {
                                price.setText("Price");
                            }
                        }
                    } catch (Exception ex) {

                    }
                }
            });
        }

        public String formatPrice(String text) {
            DecimalFormat dollars = new DecimalFormat("$###K");
            Double price = null;
            String ps = "";
            try {
                price = Double.parseDouble(text);
                if (price < 10000) {
                    ps = "null";
                } else {
                    price = price/1000;
                    ps = dollars.format(price);
                }
            } catch (NumberFormatException ex) {

            }
            return ps;
        }

        @Override
        public void setFocusTo() {
            min.textField.requestFocusInWindow();
        }


    }


    public static class SearchInputField extends JPanel {
        public JLabel label;
        public JTextField textField;

        public SearchInputField(String labelText) {
            label = new JLabel(labelText);
            JPanel labelHolder = new JPanel();
            labelHolder.setPreferredSize(new Dimension(100,15));
            labelHolder.setLayout(new FlowLayout());
            labelHolder.add(label);
            textField = new JTextField();
            JPanel textHolder = new JPanel();
            textHolder.setPreferredSize(new Dimension(100,40));
            textHolder.setBorder(new MatteBorder(0,0,2,0,this.getBackground()));
            textHolder.add(textField);
            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            setPreferredSize(new Dimension(100, 50));
            textField.setPreferredSize(new Dimension(80, 27));
            label.setPreferredSize(new Dimension(80,15));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            add(textHolder);
            add(labelHolder);

            textField.addKeyListener(SearchBar.limitListener(textField, 6));

//            setBorder(debugBorder());
//            textField.setBorder(debugBorder());
//            label.setBorder(debugBorder());
//            labelHolder.setBorder(debugBorder());
//            textHolder.setBorder(debugBorder());

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

            addKeyListener(SearchBar.limitListener(this, limit));
        }

    }


    public static KeyListener limitListener(JTextField textfield, int limit) {
        return new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (textfield.getText().length() >= limit) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    SearchBar.setOpenNull();
                }
            }
        };
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
