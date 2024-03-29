package main.java.homeforus.gui;


import main.java.homeforus.core.HouseList;
import main.java.homeforus.core.HouseListObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.swing.JOptionPane.showMessageDialog;

public class CreateListingWindow extends JFrame {

    int width;
    int height;
    BaseWindow window;
    private RealtorListingsView caller;
    private InputField price;
    private InputField houseNum;
    private InputField street;
    private InputField city;
    private InputField state;
    private InputField zip;
    private InputField beds;
    private InputField baths;
    private InputField floors;
    private InputField yrBuilt;
    private InputField sqrFeet;
    private ArrayList<InputField> inputs;
    private JLabel errorFillOut;
    private JButton imgUpload;
    private boolean formComplete;
    private boolean isNewHouse = true;
    private int houseID;
    private File chosenFile;
    private CreateListingWindow t;
    private int contentPanelID;

    // length constraints for input fields
    static final int YEAR_LENGTH = 4;
    static final int STATE_LENGTH = 12; //Road Island being the longest
    static final int VAR_CHAR_LIMIT = 200;
    static final int ZIP_CODE_LENGTH = 5;
    static final int INT_LIMIT = 2147483647;

    public CreateListingWindow(RealtorListingsView r, BaseWindow window) {
        caller = r;
        this.window = window;
        this.inputs = new ArrayList<>();
        width = 500;
        height = 380;
        setPreferredSize(new Dimension(width,height));
        add(buildNewListingsWindow());
        setTitle("Create New House Listing");
        setResizable(false);
        setIconImage(window.getAppIcon());
        pack();

        t = this;

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                t.setMinimumSize(new Dimension(width, height));
                t.setLocationRelativeTo(window);
            }
        });
    }

    public JButton createImgButton() {
        imgUpload = new JButton("Choose....");
        imgUpload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser= new JFileChooser();
                int choice = chooser.showOpenDialog(t);
                if (choice != JFileChooser.APPROVE_OPTION)
                    return;

                chosenFile = chooser.getSelectedFile();

                if (chosenFile != null) {
                    if (chosenFile.length() > 4000000) {
                        showMessageDialog(null, "Image too large. Please choose a different image.");
                        chosenFile = null;
                    } else {
                        imgUpload.setText(chosenFile.getName());
                    }
                }
            }
        });
        return imgUpload;
    }

    public void launchWindow(boolean isNewHouse, int houseID, int contentPanelID) throws SQLException, IOException {
        this.isNewHouse = isNewHouse;
        this.houseID = houseID;
        this.contentPanelID = contentPanelID;
        setNewHouse(isNewHouse());
        if (!isNewHouse()) {
            changeImgUploadBtn();
            populateHouseData(getHouseID());
        }
    }

    public void changeImgUploadBtn() {
        String houseImg = null;
        if (!isNewHouse()) {
            try {
                houseImg = window.getQueryConnector().getImgByHouseID(getHouseID());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            imgUpload.setText(houseImg);
        } else {
            imgUpload.setText("Choose.... ");
        }
    }



    private JPanel buildNewListingsWindow() {
        JPanel holderPanel = new JPanel();
        holderPanel.setPreferredSize(new Dimension(width - 20, height - 20));
        holderPanel.setLayout(new BoxLayout(holderPanel, BoxLayout.PAGE_AXIS));

        JPanel grid = new JPanel();
        grid.setMaximumSize(new Dimension(width - 100, height - 100));
        grid.setLayout(new GridLayout(4,2));
        holderPanel.add(grid);

        JPanel choosePhotoHolder = new JPanel();
        choosePhotoHolder.setPreferredSize(new Dimension(150,20));
        choosePhotoHolder.setLayout(new BoxLayout(choosePhotoHolder,BoxLayout.LINE_AXIS));
        choosePhotoHolder.add(new JLabel("Photo"));
        choosePhotoHolder.add(Box.createHorizontalGlue());
        choosePhotoHolder.add(createImgButton());
        grid.add(choosePhotoHolder);

        price = createInputField("Price");
        houseNum = createInputField("House Number");
        street = createInputField("Street Address");
        city = createInputField("City");
        sqrFeet = createInputField("Square Feet");
        grid.add(price);
        grid.add(houseNum);
        grid.add(street);
        grid.add(city);

        inputs.add(price);
        inputs.add(houseNum);
        inputs.add(street);
        inputs.add(city);
        inputs.add(sqrFeet);

        state = createInputField("State");
        grid.add(state);
        zip = createInputField("Zip Code");
        JPanel stateZipHolder = doubleInputFields();
        stateZipHolder.add(zip);
        stateZipHolder.add(sqrFeet);
        grid.add(stateZipHolder);
        inputs.add(state);
        inputs.add(zip);

        beds = createInputField("Beds");
        baths = createInputField("Baths");
        JPanel bedsBathsHolder = doubleInputFields();
        bedsBathsHolder.add(beds);
        bedsBathsHolder.add(baths);
        grid.add(bedsBathsHolder);
        inputs.add(beds);
        inputs.add(baths);

        floors = createInputField("Floors");
        yrBuilt = createInputField("Year Built");
        JPanel floorsYrsHolder = doubleInputFields();
        floorsYrsHolder.add(floors);
        floorsYrsHolder.add(yrBuilt);
        grid.add(floorsYrsHolder);
        inputs.add(floors);
        inputs.add(yrBuilt);

        JPanel btnHolder = new JPanel();
        JButton updateListing = new JButton("Commit");
        updateListing.addActionListener(validateInputAndSubmit(this.isNewHouse()));
        btnHolder.setPreferredSize(new Dimension(width - 100, 50));
        btnHolder.add(updateListing);
        holderPanel.add(Box.createVerticalGlue());
        holderPanel.add(btnHolder);

        JPanel errorMsgHolder = new JPanel();
        errorMsgHolder.setMinimumSize(new Dimension(width - 50,20));
        errorFillOut = new JLabel("  ");
        errorFillOut.setForeground(Color.red);
        errorMsgHolder.add(errorFillOut);
        holderPanel.add(errorMsgHolder);

        return holderPanel;
    }

    private ActionListener chooseImageUpload() {
        ActionListener a = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        return a;
    }

    private ActionListener validateInputAndSubmit(Boolean isNewHouse) {
        ActionListener a = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formComplete = true;
                // Parse user input and create a sanitized HouseInput object here!

                // Step 1: Get text field from InputField object and trim
                String priceS = oNotNull(price.getTextField().getText()).toString();
                String houseNumS = oNotNull(houseNum.getTextField().getText()).toString();
                String streetS = oNotNull(street.getTextField().getText()).toString();
                String cityS = oNotNull(city.getTextField().getText()).toString();
                String sqrFeetS = oNotNull(sqrFeet.getTextField().getText()).toString();
                String stateS = oNotNull(state.getTextField().getText()).toString();
                String zipS = oNotNull(zip.getTextField().getText()).toString();
                String bedsS = oNotNull(beds.getTextField().getText()).toString();
                String bathsS = oNotNull(baths.getTextField().getText()).toString();
                String floorsS = oNotNull(floors.getTextField().getText()).toString();
                String yearS = oNotNull(yrBuilt.getTextField().getText()).toString();

                priceS = priceS.trim();

                // Step 2: Loop through and ensure they've all got text in them.
                // Add additional checks for our character length database constraints
                // Idk what they all are so you have to check somehow....
                int errors = 0;
                for (InputField i:inputs) {
                    if (i.getTextField().getText().isEmpty()) {
                        setError(i);
                        errors ++;
                    } else {
                        if (i.getLabel().getText().equals("Year Built")) {
                            if (i.getTextField().getText().length() != YEAR_LENGTH) {
                                setError(i);
                                errors ++;
                            } else {
                                i.getLabel().setForeground(Color.BLACK);
                            }
                        }
                        if (i.getLabel().getText().equals("State")) {
                            if (i.getTextField().getText().length() > STATE_LENGTH) {
                                setError(i);
                                errors ++;
                            } else {
                                i.getLabel().setForeground(Color.BLACK);
                            }
                        }
                        if (i.getLabel().getText().equals("City")) {
                            if (i.getTextField().getText().length() > VAR_CHAR_LIMIT) {
                                setError(i);
                                errors ++;
                            } else {
                                i.getLabel().setForeground(Color.BLACK);
                            }
                        }

                        if (i.getLabel().getText().equals("Zip Code")) {
                            if (i.getTextField().getText().length() != ZIP_CODE_LENGTH) {
                                setError(i);
                                errors ++;
                            } else {
                                i.getLabel().setForeground(Color.BLACK);
                            }
                        }

                        if (i.getLabel().getText().equals("Street")) {
                            if (i.getTextField().getText().length() > VAR_CHAR_LIMIT) {
                                setError(i);
                                errors ++;
                            } else {
                                i.getLabel().setForeground(Color.BLACK);
                            }
                        }

                        if (i.getLabel().getText().equals("Price")) {
                            if (i.getTextField().getText().length() >= INT_LIMIT) {
                                setError(i);
                                errors ++;
                            } else {
                                i.getLabel().setForeground(Color.BLACK);
                            }
                        }

                        if (i.getLabel().getText().equals("Square Feet")) {
                            if (i.getTextField().getText().length() >= INT_LIMIT) {
                                setError(i);
                                errors ++;
                            } else {
                                i.getLabel().setForeground(Color.BLACK);
                            }
                        }

                        if (i.getLabel().getText().equals("Beds")) {
                            if (i.getTextField().getText().length() >= INT_LIMIT) {
                                setError(i);
                                errors ++;
                            } else {
                                i.getLabel().setForeground(Color.BLACK);
                            }
                        }

                        if (i.getLabel().getText().equals("Baths")) {
                            if (i.getTextField().getText().length() >= INT_LIMIT) {
                                setError(i);
                                errors ++;
                            } else {
                                i.getLabel().setForeground(Color.BLACK);
                            }
                        }

                        if (i.getLabel().getText().equals("Floors")) {
                            if (i.getTextField().getText().length() >= INT_LIMIT) {
                                setError(i);
                                errors ++;
                            } else {
                                i.getLabel().setForeground(Color.BLACK);
                            }
                        }
                        if (i.getLabel().getText().equals("Street Address")) {
                            if (i.getTextField().getText().length() > VAR_CHAR_LIMIT) {
                                setError(i);
                                errors ++;
                            } else {
                                i.getLabel().setForeground(Color.BLACK);
                            }
                        }
                        if (i.getLabel().getText().equals("House Number")) {
                            if (i.getTextField().getText().length() > VAR_CHAR_LIMIT) {
                                setError(i);
                                errors ++;
                            } else {
                                i.getLabel().setForeground(Color.BLACK);
                            }
                        }
                    }
                }

                // Step 3: if (formComplete) check passes, then convert the int types into ints
                if (errors == 0){
                    int priceInt = -1;
                    int houseNumInt = -1;
                    int yearInt = -1;
                    int floorsInt = -1;
                    int bedsInt = -1;
                    int bathsInt = -1;
                    int sqrFeetInt = -1;
                    priceInt = toNum(priceS);
                    houseNumInt = toNum(houseNumS);
                    yearInt = toNum(yearS);
                    floorsInt = toNum(floorsS);
                    bedsInt = toNum(bedsS);
                    bathsInt = toNum(bathsS);
                    sqrFeetInt = toNum(sqrFeetS);

                    // Step 4: Create sanitized HouseInput object

//                    window.getQueryConnector().addImage();
                     HouseInput houseInput = new HouseInput("img.jpg", stateS, cityS, zipS, streetS,
                             houseNumInt, priceInt, yearInt, floorsInt, bedsInt, bathsInt, sqrFeetInt);

                    // Step 5: Call to QueryConnector and close window
                    if (isNewHouse()) {
                        if (window.getQueryConnector().createNewListing(houseInput, chosenFile)) {
                            showMessageDialog(null,"New Listing Created!");
                        } else {
                            showMessageDialog(null, "Listing could not be created.");
                        }
                    } else {
                        if (window.getQueryConnector().updateHouse(getHouseID(), houseInput, chosenFile)) {

                            if (chosenFile != null) {
                                ArrayList<ContentPanel> panels = caller.getRealtorListingsPanels();
                                for (ContentPanel p:panels) {
                                    if (p.getPANEL_ID() == contentPanelID) {
                                        p.remove(p.getImgArea());
                                        p.buildImgArea(chosenFile.getName(), houseID);
                                    }
                                }
                            }

                            showMessageDialog(null,"Listing Updated!");
                        } else {
                            showMessageDialog(null, "Listing could not be updated.");
                        }
                    }
                    caller.hideCreateListingsWindow(t);
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
            }
        };
        return a;
    }


    private JPanel doubleInputFields() {
        JPanel dbl = new JPanel();
        dbl.setLayout(new BoxLayout(dbl, BoxLayout.LINE_AXIS));
        setPreferredSize(new Dimension(150,20));

        return dbl;
    }

    public InputField createInputField(String label) {
        return new InputField(label);
    }

    public static MatteBorder debugBorder() {

        return new MatteBorder(3, 3, 3, 3, Color.CYAN);
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

    public void setError(InputField i) {
        i.getLabel().setForeground(Color.RED);
        errorFillOut.setText("Error: Please fully fill out the fields in red.");
        formComplete = false;
    }

    public void populateHouseData(int house_ID) throws SQLException, IOException {
        List<HouseListObject> h;
        HouseList house = new HouseList();
        h = house.ListHouseID(house_ID);
        price.setTextField(Integer.toString(h.get(0).getCost()));
        houseNum.setTextField(Integer.toString(h.get(0).getHouseNumber()));
        street.setTextField(h.get(0).getStreet());
        city.setTextField(h.get(0).getCity());
        sqrFeet.setTextField(Integer.toString(h.get(0).getSqrFeet()));
        state.setTextField(h.get(0).getState());
        zip.setTextField(h.get(0).getZip());
        beds.setTextField(Integer.toString(h.get(0).getNumBed()));
        baths.setTextField(Integer.toString(h.get(0).getNumBath()));
        floors.setTextField(Integer.toString(h.get(0).getNumFloors()));
        yrBuilt.setTextField(Integer.toString(h.get(0).getYear()));
    }

    public boolean isNewHouse() {
        return isNewHouse;
    }

    public void setNewHouse(boolean newHouse) {
        isNewHouse = newHouse;
    }

    public int getHouseID() {
        return houseID;
    }

    public void setHouseID(int houseID) {
        this.houseID = houseID;
    }
}
