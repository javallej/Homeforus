package main.java.homeforus.gui;

import main.java.homeforus.core.DBConnect;
import main.java.homeforus.core.Setup;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

public class CreateAccountWindow extends JFrame {

    private BaseWindow window;
    private TopHeader caller;
    private InputField username;
    private InputField password;
    private InputField firstName;
    private InputField lastName;
    private InputField email;
    private InputField phone;
    private JRadioButton consumerBtn;
    private JRadioButton realtorBtn;
    private InputField conDOB;
    private InputField conSSN;
    private InputField realtBN;
    private ArrayList<InputField> inputs;
    private NewUserInput newUserInput;
    private JLabel errorFillOut;
    private JLabel errorSelectUserType;
    private JLabel errorUsernameTaken;
    private boolean formComplete;

    public CreateAccountWindow(TopHeader topHeader, BaseWindow window) {
        this.setCaller(topHeader);
        this.setWindow(window);
        inputs = new ArrayList<>();
        setPreferredSize(new Dimension(500,550));
        add(buildCreateAccount());
        setTitle("Create New User Account");
        setResizable(false);

        pack();
        setLocationRelativeTo(null);
    }

    private JPanel buildCreateAccount() {
        JPanel windowContainer = new JPanel();
        windowContainer.setPreferredSize(new Dimension(500,530));
        windowContainer.setLayout(new BoxLayout(windowContainer, BoxLayout.PAGE_AXIS));
        JPanel inputGrid = buildInputGrid();
        windowContainer.add(inputGrid);
        JButton signInSubmit = new JButton("Create Account");

        signInSubmit.addActionListener(validationCreateListener());
        JPanel signInBtnHolder = new JPanel();
        signInBtnHolder.add(signInSubmit);
        windowContainer.add(signInBtnHolder);

        JPanel errorMsgHolder = new JPanel();
        errorMsgHolder.setMinimumSize(new Dimension(400,45));
        errorMsgHolder.setLayout(new BoxLayout(errorMsgHolder, BoxLayout.PAGE_AXIS));
        errorFillOut = new JLabel("  ");
        errorFillOut.setForeground(Color.red);
        errorMsgHolder.add(errorFillOut);
        errorSelectUserType = new JLabel(" ");
        errorSelectUserType.setForeground(Color.red);
        errorMsgHolder.add(errorSelectUserType);
        errorUsernameTaken = new JLabel( " ");
        errorUsernameTaken.setForeground(Color.red);
        errorMsgHolder.add(errorUsernameTaken);
        windowContainer.add(errorMsgHolder);

        return windowContainer;
    }


    public void setError(InputField i) {
        i.getLabel().setForeground(Color.RED);
        errorFillOut.setText("Error: Please fully fill out the fields in red.");
        formComplete = false;
    }

    public JPanel buildInputGrid() {
        JPanel textBoxHolder = new JPanel();
        textBoxHolder.setMinimumSize(new Dimension(480,150));
        textBoxHolder.setLayout(new GridLayout(8,2));

        username = createInputField("Username");
        password = createInputField("Password");
        firstName = createInputField("First Name");
        lastName = createInputField("Last Name");
        email = createInputField("Email");
        phone = createInputField("Phone");

        JPanel consumerPanel = new JPanel();
        consumerPanel.setLayout(new FlowLayout());
        consumerPanel.setPreferredSize(new Dimension(150,20));
        consumerBtn = new JRadioButton("");
        JLabel consumerLabel = new JLabel("I'm a buyer");
        consumerPanel.add(consumerBtn);
        consumerPanel.add(consumerLabel);
        conDOB = createInputField("Date of Birth");
        conSSN = createInputField("SSN");
        setTextFieldEditable(conDOB, false);
        setTextFieldEditable(conSSN, false);

        JPanel realtorPanel = new JPanel();
        realtorPanel.setLayout(new FlowLayout());
        realtorPanel.setPreferredSize(new Dimension(150,20));
        realtorBtn = new JRadioButton("");
        JLabel realtorLabel = new JLabel("I'm a realtor");
        realtorPanel.add(realtorBtn);
        realtorPanel.add(realtorLabel);
        realtBN = createInputField("Business Name");
        setTextFieldEditable(realtBN, false);

        ButtonGroup b = new ButtonGroup();
        b.add(consumerBtn);
        b.add(realtorBtn);
        consumerBtn.addActionListener(userSelect());
        realtorBtn.addActionListener(userSelect());


        inputs.add(username);
        inputs.add(password);
        inputs.add(firstName);
        inputs.add(lastName);
        inputs.add(email);
        inputs.add(phone);
        for (InputField i:inputs) {
            textBoxHolder.add(i);
        }
        textBoxHolder.add(consumerPanel);
        JPanel blank = new JPanel();
        blank.setMaximumSize(new Dimension(150,20));
        blank.add(new JLabel("  "));
        textBoxHolder.add(blank);
        textBoxHolder.add(conDOB);
        textBoxHolder.add(conSSN);
        textBoxHolder.add(realtorPanel);
        JPanel blank2 = new JPanel();
        blank2.setPreferredSize(new Dimension(150,20));
        blank2.add(new JLabel("  "));
        textBoxHolder.add(blank2);
        textBoxHolder.add(realtBN);

        return textBoxHolder;
    }

    public ActionListener userSelect() {
        ActionListener a = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (consumerBtn.isSelected()) {
                    setTextFieldEditable(conDOB, true);
                    setTextFieldEditable(conSSN, true);
                } else {
                    setTextFieldEditable(conDOB, false);
                    setTextFieldEditable(conSSN, false);
                }
                if (realtorBtn.isSelected()) {
                    setTextFieldEditable(realtBN, true);
                } else {
                    setTextFieldEditable(realtBN, false);
                }
            }
        };
        return a;
    }

    public void setTextFieldEditable(InputField ip, boolean isEditable) {
        if (!isEditable) {
            ip.getTextField().setBackground(new Color(0xA1A1A1));
            ip.getTextField().setText("");
            ip.getTextField().setEditable(false);
        } else {
            ip.getTextField().setBackground(Color.WHITE);
            ip.getTextField().setEditable(true);
        }
        ip.getLabel().setForeground(Color.BLACK);
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

    private ActionListener validationCreateListener() {
        ActionListener a = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formComplete = true;
                // Parse Input
                String usernameS;
                String firstNameS;
                String lastNameS;
                String passwordS;
                String emailS;
                String phoneS;
                boolean isRealtor = false;
                String businessNameS = "";
                String DOBS = "";
                String SSNS = "";
                int ssn = -1;

                usernameS = oNotNull(username.getTextField().getText()).toString();
                usernameS = usernameS.trim();
                firstNameS = oNotNull(getFirstName().getTextField().getText()).toString();
                firstNameS = firstNameS.trim();
                lastNameS = oNotNull(getLastName().getTextField().getText()).toString();
                lastNameS = lastNameS.trim();
                passwordS = oNotNull(getPassword().getTextField().getText()).toString();
                passwordS = passwordS.trim();
                emailS = oNotNull(getEmail().getTextField().getText()).toString();
                emailS = emailS.trim();
                phoneS = oNotNull(getPhone().getTextField().getText()).toString();
                phoneS = phoneS.trim();

                // decide whether user is realtor or not here
                if (consumerBtn.isSelected()) {
                    errorSelectUserType.setText(" ");
                    isRealtor = false;
                    inputs.add(conDOB);
                    inputs.add(conSSN);
                    if (inputs.contains(realtBN)) {
                        inputs.remove(realtBN);
                        realtBN.getLabel().setForeground(Color.black);
                    }
                } else if (realtorBtn.isSelected()) {
                    errorSelectUserType.setText(" ");
                    isRealtor = true;
                    inputs.add(realtBN);
                    if (inputs.contains(conDOB)) {
                        inputs.remove(conDOB);
                        conDOB.getLabel().setForeground(Color.black);
                    }
                    if (inputs.contains(conSSN)) {
                        inputs.remove(conSSN);
                        conSSN.getLabel().setForeground(Color.black);
                    }
                } else {
                    errorSelectUserType.setText("Error: Please select either Buyer or Realtor user type");
                }

                for (InputField i:inputs) {
                    if (i.getTextField().getText().isEmpty()) {
                        setError(i);
                    } else {
                        i.getLabel().setForeground(Color.BLACK);
                    }
                    if (i.getLabel().getText().equals("Phone")) {
                        if (i.getTextField().getText().length() < 10) {
                            setError(phone);
                        } else {
                            i.getLabel().setForeground(Color.BLACK);
                        }
                    }
                    if (!isRealtor) {
                        if (i.getLabel().getText().equals("Date of Birth")) {
                            if (i.getTextField().getText().length() < 8) {
                                setError(conDOB);
                            } else {
                                i.getLabel().setForeground(Color.BLACK);
                            }
                        }
                        if (i.getLabel().getText().equals("SSN")) {
                            if (i.getTextField().getText().length() < 9) {
                                setError(conSSN);
                            } else {
                                i.getLabel().setForeground(Color.BLACK);
                            }
                        }
                    }
                }

                if (formComplete) {
                    phoneS = phoneS.substring(0, 9);
                    if (!isRealtor) {
                        SSNS = oNotNull(conSSN.getTextField().getText()).toString().substring(0, 8);
                        DOBS = oNotNull(conDOB.getTextField().getText()).toString().substring(0, 7);
                        ssn = toNum(SSNS);
                    } else {
                        businessNameS = oNotNull(realtBN.getTextField().getText()).toString();
                        businessNameS = businessNameS.trim();
                    }

                    setNewUserInput(new NewUserInput(usernameS, firstNameS, lastNameS, passwordS, emailS,
                            phoneS, isRealtor, businessNameS, DOBS, ssn));

                    // Add calls to Create Account here
                    try {
                        //This returns false if username is taken
                        formComplete = window.getQueryConnector().verifyUsername(usernameS);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    //if formComplete = true add user
                    if (formComplete){
                        errorUsernameTaken.setText(" ");
                        try {
                            caller.hideCreateAccount();
                            window.getQueryConnector().addUserToDB(newUserInput);
                        } catch (IOException | SQLException ex) {
                            ex.printStackTrace();
                        }
                    }

                    //else output error
                    else{
                        errorUsernameTaken.setText("Error: Username has already been taken");
                    }

                }
            }
        };
        return a;
    }


    public InputField createInputField(String label) {
        return new InputField(label);
    }



    public BaseWindow getWindow() {
        return window;
    }

    public void setWindow(BaseWindow window) {
        this.window = window;
    }

    public TopHeader getCaller() {
        return caller;
    }

    public void setCaller(TopHeader caller) {
        this.caller = caller;
    }

    public InputField getUsername() {
        return username;
    }

    public void setUsername(InputField username) {
        this.username = username;
    }

    public InputField getPassword() {
        return password;
    }

    public void setPassword(InputField password) {
        this.password = password;
    }

    public InputField getFirstName() {
        return firstName;
    }

    public void setFirstName(InputField firstName) {
        this.firstName = firstName;
    }

    public InputField getLastName() {
        return lastName;
    }

    public void setLastName(InputField lastName) {
        this.lastName = lastName;
    }

    public InputField getEmail() {
        return email;
    }

    public void setEmail(InputField email) {
        this.email = email;
    }

    public InputField getPhone() {
        return phone;
    }

    public void setPhone(InputField phone) {
        this.phone = phone;
    }

    public InputField getConDOB() {
        return conDOB;
    }

    public void setConDOB(InputField conDOB) {
        this.conDOB = conDOB;
    }

    public InputField getConSSN() {
        return conSSN;
    }

    public void setConSSN(InputField conSSN) {
        this.conSSN = conSSN;
    }

    public InputField getRealtBN() {
        return realtBN;
    }

    public void setRealtBN(InputField realtBN) {
        this.realtBN = realtBN;
    }

    public NewUserInput getNewUserInput() {
        return newUserInput;
    }

    public void setNewUserInput(NewUserInput newUserInput) {
        this.newUserInput = newUserInput;
    }


    public static MatteBorder debugBorder() {
        return new MatteBorder(3, 3, 3, 3, Color.CYAN);
    }

}
