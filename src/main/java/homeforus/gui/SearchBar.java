package main.java.homeforus.gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class SearchBar extends JPanel {

    private static BaseWindow window;
    private Dimension searchBarSize;
    private TopHeader topHeader;
    private SearchButton price;
    private SearchButton bedsBaths;
    private SearchPopup pricePopUp;
    private SearchButton more;
    private SearchPopup bedsAndBathsPopUp;
    private SearchPopup moreOptionsPopUp;
    private JButton beginSearch;
    public static SearchPopup currentlyOpen;
    private double searchPercentSize = 0.30;

    public SearchBar(Dimension headerSize, TopHeader topHeader, BaseWindow window) {
        this.window = window;
        this.topHeader = topHeader;
        buildSearchBar(headerSize);
    }

    public void buildSearchBar(Dimension headerSize) {
        int searchVertSize = (int) (headerSize.getSize().getHeight() * searchPercentSize) + 2;
        searchBarSize = new Dimension((int)headerSize.getSize().getWidth(), searchVertSize);
        setPreferredSize(searchBarSize);
        JPanel bar = new JPanel();
        bar.setLayout(new FlowLayout());
        bar.setPreferredSize(new Dimension((int)(searchBarSize.getWidth()/5)*4,(int)searchBarSize.getHeight()));
        add(bar);
        SearchTextBoxes searchTextBoxes = new SearchTextBoxes(bar);
        beginSearch = new JButton("Search");
        beginSearch.setBackground(new BrandGreen().color);
        beginSearch.setForeground(Color.white);
        beginSearch.setBorderPainted(false);
        bar.add(beginSearch);

        pricePopUp = new PricePopUp();
        price = new SearchButton("Price", pricePopUp);
        bar.add(price);

        bedsAndBathsPopUp = new BedsAndBathsPopUp();
        bedsBaths = new SearchButton("Beds & Baths", bedsAndBathsPopUp);
        bar.add(bedsBaths);

        moreOptionsPopUp = new MoreOptionsPopUp();
        more = new SearchButton("More", moreOptionsPopUp);
        more.horOffsetPanelPos = 300;
        bar.add(more);
    }

    public class SearchButton extends JButton {

        public SearchPopup searchPopup;
        public int vertOffsetPanelPos;
        public int horOffsetPanelPos;
        public SearchButton thisButton;

        public SearchButton(String text, SearchPopup searchPopup) {
            this.searchPopup = searchPopup;
            setText(text);
            setVisible(true);
            vertOffsetPanelPos = topHeader.headerHeight - 15;
            horOffsetPanelPos = 10;
            thisButton = this;
            addListeners();
        }

        public void addListeners() {
            ActionListener aL = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Point panelPos = new Point((int) (thisButton.getBounds().getMaxX() - horOffsetPanelPos), (int) thisButton.getLocation().getY() + vertOffsetPanelPos);
                    thisButton.setBackground(new BrandGreen().color);
                    thisButton.setForeground(new BrandGreen().color);
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
        currentlyOpen.caller.setForeground(Color.BLACK);
        currentlyOpen.setVisible(false);
        currentlyOpen = null;
    }

    public class SearchPopup extends JPanel {

        public SearchButton caller;
        public JPanel inner;
        public Dimension size;
        public int width;
        public int height;

        public SearchPopup() {
            setLayout(new BorderLayout());
            setMaximumSize(new Dimension(width, height));
            setBorder(new MatteBorder(2,2,2,2, new BrandGreen().color));
            setVisible(false);
            window.getLayers().add(this, JLayeredPane.POPUP_LAYER);

            inner = new JPanel();
            inner.setVisible(true);
            inner.setLayout(new FlowLayout());
            size = new Dimension(width,height);
            inner.setMaximumSize(size);
            add(inner);
        }

        public void setFocusTo() {

        }
    }

    public class MoreOptionsPopUp extends SearchPopup {

        public SearchInputField minSqFt;
        public SearchInputField maxSqFt;
        public JComboBox<Object> floors;
        public SearchInputField yrMin;
        public SearchInputField yrMax;
        public SearchInputField daysMin;
        public SearchInputField daysMax;

        public MoreOptionsPopUp() {
            width = 300;
            height = 200;
            inner.add(buildGrid());

            addComponentListener(cA());

        }



        private JPanel buildGrid() {
            JPanel grid = new JPanel();
            SpringLayout layout = new SpringLayout();
            grid.setLayout(layout);
            grid.setPreferredSize(new Dimension(280,180));

            JPanel sqFtL = labelHolder("Sq Ft");
            grid.add(sqFtL);
            MinMaxBoxes mmbSqFt = new MinMaxBoxes();
            minSqFt = mmbSqFt.min;
            maxSqFt = mmbSqFt.max;
            grid.add(mmbSqFt);
            layout.putConstraint(SpringLayout.EAST, mmbSqFt,
                    5,
                    SpringLayout.EAST, grid);
            layout.putConstraint(SpringLayout.NORTH, mmbSqFt,
                    5,
                    SpringLayout.NORTH, grid);

            layout.putConstraint(SpringLayout.NORTH, sqFtL,
                    5,
                    SpringLayout.NORTH, grid);

            JPanel fL = labelHolder("Floors");
            grid.add(fL);
            floors = newBox();
//            grid.add(floors);


//            layout.putConstraint(SpringLayout.EAST, floors,
//                    5,
//                    SpringLayout.EAST, grid);
//            layout.putConstraint(SpringLayout.NORTH, floors,
//                    5,
//                    SpringLayout.NORTH, mmbSqFt);
            layout.putConstraint(SpringLayout.NORTH, fL,
                    5,
                    SpringLayout.NORTH, mmbSqFt);
//
//            grid.add(labelHolder("Year Built"));
//            MinMaxBoxes mmbYr = new MinMaxBoxes();
//            yrMin = mmbYr.min;
//            yrMax = mmbYr.max;
//            grid.add(mmbYr);
//
//            grid.add(labelHolder("Days Listed"));
//            MinMaxBoxes mmbDays = new MinMaxBoxes();
//            daysMin = mmbDays.min;
//            daysMax = mmbDays.max;
//            grid.add(mmbDays);

            return grid;
        }

        private JPanel labelHolder(String text) {
            JPanel h = new JPanel();
            h.setPreferredSize(new Dimension(75,50));
//            h.setLayout(new FlowLayout(FlowLayout.LEFT));
            h.setLayout(new BoxLayout(h, BoxLayout.PAGE_AXIS));
            h.add(Box.createVerticalGlue());
            JLabel l = new JLabel(text);
            h.add(l);
//            l.setHorizontalAlignment(SwingConstants.LEFT);
            h.add(Box.createVerticalGlue());

//            h.setBorder(debugBorder());


            return h;
        }

        public ComponentAdapter cA() {
            ComponentAdapter c = new ComponentAdapter() {
                @Override
                public void componentHidden(ComponentEvent e) {
                    super.componentHidden(e);
                }
            };
            return c;
        }
    }

    public JComboBox<Object> newBox() {
        JComboBox<Object> b = new JComboBox<>();
        b.addItem("Any");
        for (int i = 1; i < 5; i++) {
            b.addItem(i);
        }
        return b;
    }

    public class BedsAndBathsPopUp extends SearchPopup {

        public JComboBox<Object> beds;
        public JComboBox<Object> baths;

        public BedsAndBathsPopUp() {
            width = 110;
            height = 80;
            size.setSize(width, height);
            beds = newBox();
            baths = newBox();

            JPanel boxHolder = new JPanel();
            boxHolder.setPreferredSize(new Dimension(90,60));
            boxHolder.setLayout(new GridLayout(3,3));
            boxHolder.add(new JLabel("Beds"));
            boxHolder.add(beds);
            boxHolder.add(Box.createVerticalGlue());
            boxHolder.add(Box.createVerticalGlue());
            boxHolder.add(new JLabel("Baths"));
            boxHolder.add(baths);
            inner.add(boxHolder);

            addComponentListener(whenPopUpCloses());
        }

        private ComponentAdapter whenPopUpCloses() {
            ComponentAdapter cA = new ComponentAdapter() {
                @Override
                public void componentHidden(ComponentEvent e) {
                    super.componentHidden(e);
                    if (beds.getSelectedIndex() != 0) {
                        caller.setText("Beds: " + beds.getSelectedItem() + " - Baths: Any");
                        SearchBar.setBtnActive(caller, true);
                    }
                    if (baths.getSelectedIndex() != 0) {
                        caller.setText("Beds: Any - Baths: " + baths.getSelectedIndex());
                        SearchBar.setBtnActive(caller, true);
                    }
                    if (baths.getSelectedIndex() != 0
                        && beds.getSelectedIndex() !=0) {
                        caller.setText("Beds: " + beds.getSelectedItem() + " - Baths: " + baths.getSelectedItem());
                        SearchBar.setBtnActive(caller, true);
                    }
                    if (baths.getSelectedIndex() == 0
                        && beds.getSelectedIndex() == 0){
                        caller.setText("Beds & Baths");
                        SearchBar.setBtnActive(caller, false);
                    }
                }
            };
            return cA;
        }

        @Override
        public void setFocusTo() {
            beds.requestFocusInWindow();
        }
    }

    public class MinMaxBoxes extends JPanel {

        public SearchInputField min;
        public SearchInputField max;

        public MinMaxBoxes() {
            setMaximumSize(new Dimension(240,70));
            setVisible(true);
            setLayout(new FlowLayout());

            min = new SearchInputField("Min");
            max = new SearchInputField("Max");
            add(min);
            JPanel dashHolder = new JPanel();
            dashHolder.setLayout(new BoxLayout(dashHolder, BoxLayout.PAGE_AXIS));
            dashHolder.setMaximumSize(new Dimension(10, 30));
            dashHolder.add(new JLabel("-"));
            dashHolder.add(new JLabel(" "));
            add(dashHolder);
            add(max);
        }
    }

    public class PricePopUp extends SearchPopup {

        public SearchInputField min;
        public SearchInputField max;

        public PricePopUp() {
            width = 240;
            height = 70;

            MinMaxBoxes mmb = new MinMaxBoxes();
            inner.add(mmb);
            min = mmb.min;
            max = mmb.max;

            addComponentListener(whenPopUpCloses());
        }

        private ComponentAdapter whenPopUpCloses() {
            ComponentAdapter cA = new ComponentAdapter() {
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
                        if (minT.isEmpty() && maxT.isEmpty()) {
                            price.setText("Price");
                            SearchBar.setBtnActive(price, false);
                        }

                        if (isNumMin) {
                            pMin = formatPrice(minT);
                            if (!pMin.equalsIgnoreCase("null")) {
                                price.setText(pMin + "+");
                                SearchBar.setBtnActive(price, true);
                            }
                        }
                        if (isNumMax) {
                            pMax = formatPrice(maxT);
                            if (!pMax.equalsIgnoreCase("null")) {
                                price.setText("< " + pMax);
                                SearchBar.setBtnActive(price, true);
                            }
                        }
                        if (isNumMin && isNumMax) {
                            if (pMin.compareTo(pMax) < 0) {
                                price.setText(pMin + " - " + pMax);
                                SearchBar.setBtnActive(price, true);
                            } else {
                                price.setText("Price");
                                SearchBar.setBtnActive(price, false);
                            }
                        }
                    } catch (Exception ex) {

                    }
                }
            };
            return cA;
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

    public static void setBtnActive(JButton btn, boolean state) {
        if (state) {
            btn.setBackground(new BrandGreen().color);
        } else {
            btn.setBackground(window.getBackground());
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
                        setBorder(new MatteBorder(1,1,1,1,Color.GRAY));
                    } else {
                        setBorder(new MatteBorder(1,1,1,1,new BrandGreen().color));
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

    public static MatteBorder debugBorder() {
        return new MatteBorder(3, 3, 3, 3, Color.CYAN);
    }
}
