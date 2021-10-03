package main.java.homeforus.gui;


import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class CreateListingWindow extends JFrame {

    int width;
    int height;
    BaseWindow window;
    RealtorListingsView caller;
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
    private ArrayList<InputField> inputs;
    private JLabel errorFillOut;
    private boolean formComplete;

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
        pack();

        CreateListingWindow t = this;

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                t.setSize(new Dimension(width, height));
                t.setLocationRelativeTo(window);
            }
        });
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
        choosePhotoHolder.add(new JButton("Choose...."));
        grid.add(choosePhotoHolder);

        price = createInputField("Price");
        houseNum = createInputField("House Number");
        street = createInputField("Street Address");
        city = createInputField("City");
        grid.add(price);
        grid.add(houseNum);
        grid.add(street);
        grid.add(city);

        state = createInputField("State");
        zip = createInputField("Zip Code");
        JPanel stateZipHolder = doubleInputFields();
        stateZipHolder.add(state);
        stateZipHolder.add(zip);
        grid.add(stateZipHolder);

        beds = createInputField("Beds");
        baths = createInputField("Baths");
        JPanel bedsBathsHolder = doubleInputFields();
        bedsBathsHolder.add(beds);
        bedsBathsHolder.add(baths);
        grid.add(bedsBathsHolder);

        floors = createInputField("Floors");
        yrBuilt = createInputField("Year Built");
        JPanel floorsYrsHolder = doubleInputFields();
        floorsYrsHolder.add(floors);
        floorsYrsHolder.add(yrBuilt);
        grid.add(floorsYrsHolder);

        JPanel btnHolder = new JPanel();
        JButton createNewListing = new JButton("Create New Listing");
        createNewListing.addActionListener(validateInputAndSubmit());
        btnHolder.setPreferredSize(new Dimension(width - 100, 50));
        btnHolder.add(createNewListing);
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

    private ActionListener validateInputAndSubmit() {
        ActionListener a = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formComplete = true;
                System.out.println("Create New Listing Button Clicked");
                // TODO: For Seth
                // Parse user input and create a sanitized HouseInput object here!

                // Step 1: Get text field from InputField object and trim
                String priceS = oNotNull(price.getTextField().getText()).toString();
                priceS = priceS.trim();

                // Step 2: Loop through and ensure they've all got text in them.
                // Add additional checks for our character length database constraints
                // Idk what they all are so you have to check somehow....
                int someLength = 5;
                for (InputField i:inputs) {
                    if (i.getTextField().getText().isEmpty()) {
                        setError(i);
                    } else {
                        i.getLabel().setForeground(Color.BLACK);
                    }
                    if (i.getLabel().getText().equals("Some Field")) {
                        if (i.getTextField().getText().length() < someLength) {
                            setError(i);
                        } else {
                            i.getLabel().setForeground(Color.BLACK);
                        }
                    }
                }

                // Step 3: if (formComplete) check passes, then convert the int types into ints
                int priceInt = -1;
                priceInt = toNum(priceS);

                // Step 4: Create sanitized HouseInput object
                // HouseInput houseInput = new HouseInput(priceInt, etc... pass arguments from fields here);

                // Step 5: Print object to make sure all of the fields stored OK.
                // System.out.println(houseInput);
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

}
