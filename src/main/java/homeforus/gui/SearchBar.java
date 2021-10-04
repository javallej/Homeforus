package main.java.homeforus.gui;

import main.java.homeforus.core.HouseList;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

public class SearchBar extends JPanel {

    private static BaseWindow window;
    private Dimension searchBarSize;
    private TopHeader topHeader;
    private SearchTextBoxes searchTextBoxes;
    private SearchButton price;
    private SearchButton bedsBaths;
    private SearchPopup pricePopUp;
    private SearchButton more;
    private SearchPopup bedsAndBathsPopUp;
    private SearchPopup moreOptionsPopUp;
    private SearchInput searchInput;
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
        searchTextBoxes = new SearchTextBoxes(bar);
        beginSearch = new JButton("Search");
        beginSearch.setBackground(new BrandGreen().color);
        beginSearch.setForeground(Color.white);
        beginSearch.setBorderPainted(false);
        bar.add(beginSearch);
        applySearchTerms();

        pricePopUp = new PricePopUp();
        price = new SearchButton("Price", pricePopUp);
        bar.add(price);

        bedsAndBathsPopUp = new BedsAndBathsPopUp();
        bedsBaths = new SearchButton("Beds & Baths", bedsAndBathsPopUp);
        bar.add(bedsBaths);

        moreOptionsPopUp = new MoreOptionsPopUp();
        more = new SearchButton("More", moreOptionsPopUp);
        more.horOffsetPanelPos = 200;
        bar.add(more);
    }

    public Object oNotNull(Object o) {
        if (o != null) {
            return o;
        }
        return "";
    }

    public static int toNum(String n) {
        int num;
        try {
            num = Integer.parseInt(n);
        } catch (NumberFormatException nfe) {
            return -1;
        }
        return num;
    }

    private void applySearchTerms() {
        beginSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int houseNo = -1;
                String houseNum = "";
                String street = "";
                String city = "";
                String state = "";
                String zip = "";

                houseNum = oNotNull(searchTextBoxes.address.getContent()).toString();
                houseNum = houseNum.split(" ")[0];
                houseNo = toNum(houseNum);
                street = oNotNull(searchTextBoxes.address.getContent()).toString();
                if (street.length() > 1) {
                    if (houseNo != -1) {
                        if (houseNum.split(" " ).length > 1) {
                            street = street.substring(houseNum.length() + 1, street.length()).trim();
                        } else {
                            street = "";
                        }
                    }
                }
                city = oNotNull(searchTextBoxes.city.getContent()).toString();
                city = city.trim();
                state = oNotNull(searchTextBoxes.state.getContent()).toString();
                state = state.trim();
                zip = oNotNull(searchTextBoxes.zip.getContent()).toString();
                zip = zip.trim();

                int zipNo = -1;
                PricePopUp pricePop = (PricePopUp) pricePopUp;
                int priceMin = -1;
                int priceMax = -1;
                BedsAndBathsPopUp bedPop = (BedsAndBathsPopUp) bedsAndBathsPopUp;
                int beds = bedPop.beds.getSelectedIndex();
                int baths = bedPop.baths.getSelectedIndex();
                MoreOptionsPopUp morePop = (MoreOptionsPopUp) moreOptionsPopUp;
                int sqMin = -1;
                int sqMax = -1;
                int floors = morePop.floors.getSelectedIndex();
                int yrMin = -1;
                int yrMax = -1;
                int dMin = -1;
                int dMax = -1;

                zipNo = toNum(oNotNull(zip).toString());
                JTextField t = (JTextField) oNotNull(pricePop.min.textField);
                priceMin = toNum(t.getText().trim());
                t = (JTextField) oNotNull(pricePop.max.textField);
                priceMax = toNum(t.getText().trim());
                t = (JTextField) oNotNull(morePop.minSqFt.textField);
                sqMin = toNum(t.getText().trim());
                t = (JTextField) oNotNull(morePop.maxSqFt.textField);
                sqMax = toNum(t.getText().trim());
                t = (JTextField) oNotNull(morePop.yrMin.textField);
                yrMin = toNum(t.getText().trim());
                t = (JTextField) oNotNull(morePop.yrMax.textField);
                yrMax = toNum(t.getText().trim());
                t = (JTextField) oNotNull(morePop.daysMin.textField);
                dMin = toNum(t.getText().trim());
                t = (JTextField) oNotNull(morePop.daysMax.textField);
                dMax = toNum(t.getText().trim());


                searchInput = new SearchInput(houseNo, street, city, state, zipNo, priceMin, priceMax,
                                                 beds, baths, sqMin, sqMax, floors, yrMin, yrMax, dMin, dMax);

                QueryConnector query = new QueryConnector(window);


                window.setSearchInput(searchInput);
                try {
                    query.getSearchList(searchInput);
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }


            }
        });
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
        ArrayList<SearchInputField> fields;

        public MoreOptionsPopUp() {
            width = 300;
            height = 260;
            inner.add(buildGrid());
            fields = fields();
            addComponentListener(whenPopUpCloses());
        }

        private ArrayList<SearchInputField> fields() {
            ArrayList<SearchInputField> f = new ArrayList<>();
            f.add(minSqFt);
            f.add(maxSqFt);
            f.add(yrMin);
            f.add(yrMax);
            f.add(daysMin);
            f.add(daysMax);
            return f;
        }

        private JPanel buildGrid() {
            JPanel grid = new JPanel();
            SpringLayout layout = new SpringLayout();
            grid.setLayout(layout);
            grid.setPreferredSize(new Dimension(280,240));

            JPanel sqFtL = labelHolder("Sq Ft");
            grid.add(sqFtL);
            MinMaxBoxes mmbSqFt = new MinMaxBoxes();
            int boxHeights = (int)mmbSqFt.getMaximumSize().getHeight();
            int halfOfBoxes = (int)mmbSqFt.getMaximumSize().getWidth()/2 - 42;
            int north = 15;
            minSqFt = mmbSqFt.min;
            maxSqFt = mmbSqFt.max;
            grid.add(mmbSqFt);
            setConstraints(layout, grid, sqFtL, mmbSqFt, 5, 5, north);

            JPanel fL = labelHolder("Floors");
            grid.add(fL);
            floors = newBox();
            JPanel boxHolder = new JPanel();
            boxHolder.add(floors);
            grid.add(boxHolder);
            setConstraints(layout, grid, fL, boxHolder, -halfOfBoxes, boxHeights, boxHeights);

            JPanel yrHolder= labelHolder("Year Built");
            grid.add(yrHolder);
            MinMaxBoxes mmbYr = new MinMaxBoxes();
            boxHeights += mmbYr.getMaximumSize().getHeight() - + north - 20;
            yrMin = mmbYr.min;
            yrMax = mmbYr.max;
            grid.add(mmbYr);
            setConstraints(layout, grid, yrHolder, mmbYr, 5, boxHeights, boxHeights);

            JPanel daysHolder = labelHolder("Days Listed");
            grid.add(daysHolder);
            MinMaxBoxes mmbDays = new MinMaxBoxes();
            boxHeights += mmbDays.getMaximumSize().getHeight();
            daysMin = mmbDays.min;
            daysMax = mmbDays.max;
            grid.add(mmbDays);
            setConstraints(layout, grid, daysHolder, mmbDays, 5, boxHeights, boxHeights);

            return grid;
        }

        private ComponentAdapter whenPopUpCloses() {
            ComponentAdapter cA = new ComponentAdapter() {
                @Override
                public void componentHidden(ComponentEvent e) {
                    super.componentHidden(e);
                    int changed = 0;
                    for (SearchInputField s:fields) {
                        if (!s.textField.getText().isEmpty()) {
                            changed++;
                        }
                    }
                    if (floors.getSelectedIndex() != 0) {
                        changed++;
                    }
                    if (changed != 0) {
                        more.setText("More: " + changed);
                        SearchBar.setBtnActive(more, true);
                    } else {
                        more.setText("More");
                        SearchBar.setBtnActive(more, false);
                    }
                }
            };
            return cA;
        }

        private void setConstraints(SpringLayout layout, JPanel grid, JPanel left, JPanel right, int i1, int i2, int i3) {
            layout.putConstraint(SpringLayout.EAST, right,
                    i1,
                    SpringLayout.EAST, grid);
            layout.putConstraint(SpringLayout.NORTH, right,
                    i2,
                    SpringLayout.NORTH, grid);
            layout.putConstraint(SpringLayout.NORTH, left,
                    i3,
                    SpringLayout.NORTH, grid);
        }

        private JPanel labelHolder(String text) {
            JPanel h = new JPanel();
            h.setPreferredSize(new Dimension(70,40));
            h.setLayout(new BoxLayout(h, BoxLayout.PAGE_AXIS));
            h.add(Box.createVerticalGlue());
            JLabel l = new JLabel(text);
            h.add(l);
            h.add(Box.createVerticalGlue());
            return h;
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
        public String helloooooo;

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
            address = new SearchTextBox(" Address", 50);
            address.setPreferredSize(new Dimension(150,height));
            bar.add(address);

            city = new SearchTextBox(" City", 30);
            city.setPreferredSize(new Dimension(100,height));
            bar.add(city);

            state = new SearchTextBox(" State", 2);
            state.setPreferredSize(new Dimension(50,height));
            bar.add(state);


            zip = new SearchTextBox(" Zip", 5);
            zip.setPreferredSize(new Dimension(70,height));
            bar.add(zip);
        }
    }


    public static class SearchTextBox extends JTextField {

        private String content;
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
                        content = getText();
                    }
                }
            });

            addKeyListener(SearchBar.limitListener(this, limit));
        }

        public String getContent() {
            if (!Objects.equals(getText(), dummyText)) {
                return getText();
            } else {
                return "";
            }
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
                    if (SearchBar.currentlyOpen != null) {
                        SearchBar.setOpenNull();
                    }
                }
            }
        };
    }

    public static MatteBorder debugBorder() {
        return new MatteBorder(3, 3, 3, 3, Color.CYAN);
    }
}
